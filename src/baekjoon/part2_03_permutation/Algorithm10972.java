package baekjoon.part2_03_permutation;

import java.util.Scanner;

/**
 * 다음 순열
 * 문제 : https://www.acmicpc.net/problem/10972
 * 풀이 : https://www.acmicpc.net/source/share/cbbd695b7ba34e14b36ea43f11047a88
 * <p>
 * 1부터 N까지의 수로 이루어진 순열이 있다.
 * 이때, 사전순으로 다음에 오는 순열을 구하는 프로그램을 작성하시오.
 * 첫째 줄에 N(1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄에 순열이 주어진다.
 */
public class Algorithm10972 {

    static boolean nextPermutation(int[] p) {
        int i = p.length - 1; // 마지막 위치 찾기 위함

        /**
         * 순열의 마지막 수에서 끝나는 가장 긴 감소수열을 찾아야 한다
         * 7 2 3 < 6 5 4 1
         * 즉 i[3] > i[2]
         * i == 3일 때, while 이탈
         */
        while (i > 0 && p[i] <= p[i - 1]) {
            i -= 1;
        }

        if (i <= 0) {
            // 현시점이 마지막 숫자
            return false;
        }

        int j = p.length - 1; // 마지막 위치 찾기 위함

        // 순열의 마지막 수에서 끝나는 가장 긴 감소수열을 찾아야 한다
        // p[i - 1] == p[2] == 3
        while (p[j] <= p[i - 1]) {
            j -= 1;
        }

        /**
         * 7 2 3 < 6 5 4 1
         * 즉 i[3] > i[2]
         * 이 시점에서 순서를 바꿈
         */
        int temp = p[j];
        p[j] = p[i - 1];
        p[i - 1] = temp; // 7 2 4 6 5 3 1

        j = p.length - 1; // 마지막 위치 찾기 위함, j == 6

        // 한 단위의 마지막 순열을 첫번째 순열로 변경
        // 6 5 3 1 --> 1 3 5 6
        while (i < j) {
            temp = p[i];
            p[i] = p[j];
            p[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }

        if (nextPermutation(p)) {
            for (int i = 0; i < n; i++) {
                System.out.print(p[i] + " ");
            }
        } else {
            System.out.print("-1");
        }
    }
}
