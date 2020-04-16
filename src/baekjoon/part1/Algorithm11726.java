package baekjoon.part1;

import java.util.Scanner;

/**
 * 2×n 타일링
 * 문제 : https://www.acmicpc.net/problem/11726
 * 풀이 : https://www.acmicpc.net/source/share/30e6fab923b2472b9efdd75a54a9bdd6
 */
public class Algorithm11726 {
    public static void main(String[] args) {
        final int REMAINDER = 10007;

        Scanner sc = new Scanner(System.in);
        // n : 2 × n 직사각형
        int n = sc.nextInt();
        // 첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)
        int[] d = new int[1001];

        d[0] = 1; // 물론 있을 수 없는 상황
        d[1] = 1; // 세로줄 1개

        for (int i = 2 ; i <= n ; i++) {
            // d[i-1] : 마지막 타일이 세로줄 1개 일 때
            // d[i-2] : 마지막 타일이 가로줄 2개 일 때
            d[i] = d[i-1] + d[i-2];
            d[i] = d[i] % REMAINDER;
        }

        System.out.println(d[n]);
    }
}
