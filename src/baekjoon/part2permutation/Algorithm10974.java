package baekjoon.part2permutation;

import java.util.Scanner;

/**
 * 다음 순열
 * 문제 : https://www.acmicpc.net/problem/10974
 * 풀이 : https://www.acmicpc.net/source/share/343de5d49ae74b6daac615f4424f92a5
 * <p>
 * N이 주어졌을 때, 1부터 N까지의 수로 이루어진 순열을 사전순으로 출력하는 프로그램을 작성하시오.
 * 첫째 줄에 N(1 ≤ N ≤ 8)이 주어진다.
 */
public class Algorithm10974 {

    // 10972와 동일
    static boolean nextPermutation(int[] p) {
        int i = p.length - 1; // 마지막 위치 찾기 위함

        while (i > 0 && p[i] <= p[i - 1]) {
            i -= 1;
        }

        if (i <= 0) {
            // 현시점이 마지막 숫자
            return false;
        }

        int j = p.length - 1; // 마지막 위치 찾기 위함

        while (p[j] <= p[i - 1]) {
            j -= 1;
        }

        int temp = p[j];
        p[j] = p[i - 1];
        p[i - 1] = temp; // 7 2 4 6 5 3 1

        j = p.length - 1; // 마지막 위치 찾기 위함, j == 6

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
            // 10972와 다른 부분
            p[i] = i + 1;
        }

        /**
         * 10972와 다른 부분
         */
        do {
            for (int i = 0; i < n; i++) {
                System.out.print(p[i] + " ");
            }
            System.out.println();
        } while (nextPermutation(p));
    }
}
