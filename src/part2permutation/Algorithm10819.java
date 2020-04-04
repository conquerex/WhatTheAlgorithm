package part2permutation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 차이를 최대로
 * 문제 : https://www.acmicpc.net/problem/10819
 * 풀이 : https://www.acmicpc.net/source/share/d4962757773d4c9294bfabf69229aed5
 * 
 * N개의 정수로 이루어진 배열 A가 주어진다.
 * 이때, 배열에 들어있는 정수의 순서를 적절히 바꿔서 다음 식의 최댓값을 구하는 프로그램을 작성하시오.
 *
 * 첫째 줄에 N (3 ≤ N ≤ 8)이 주어진다.
 * 둘째 줄에는 배열 A에 들어있는 정수가 주어진다.
 * 배열에 들어있는 정수는 -100보다 크거나 같고, 100보다 작거나 같다.
 *
 * [sample]
 * 6
 * 20 1 15 8 4 10
 */
public class Algorithm10819 {

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

    static int cal(int[] p) {
        int sum = 0;
        for (int i = 0; i < p.length; i++) {
            System.out.print(" " + p[i]);
        }
        System.out.println();

        for (int i = 1; i < p.length; i++) {
            sum += Math.abs(p[i] - p[i - 1]);
            System.out.println("*** " + sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }

        Arrays.sort(p);

        int result = 0;

        /**
         * 10972와 다른 부분
         */
        do {
            int temp = cal(p);
            result = Math.max(result, temp);
        } while (nextPermutation(p));

        System.out.println(result);
    }
}
