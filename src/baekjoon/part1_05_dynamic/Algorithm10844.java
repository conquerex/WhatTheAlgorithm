package baekjoon.part1_05_dynamic;

import java.util.Scanner;

/**
 * 쉬운 계단 수
 * 문제 : https://www.acmicpc.net/problem/10844
 * 풀이 : https://www.acmicpc.net/source/share/60135ec83b494a03bf93e8fb3c04b98b
 * 첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 100보다 작거나 같은 자연수이다.
 * 첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.
 */
public class Algorithm10844 {
    public static void main(String[] args) {
        final long MOD = 1000000000L;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        /**
         * n+1 : 0을 제외한 계단 수 (수의 자리수, ex: n = 3, 123/345/565)
         * 10  : 0 ~ 9, 해당 계단의 가장 마지막의 수
         */
        long[][] d = new long[n+1][10];

        // 계단이 1개일 때
        for (int i = 1; i < 10; i++) {
            d[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                d[i][j] = 0;
                if (j-1 >= 0) {
                    d[i][j] += d[i-1][j-1];
                }

                if (j+1 < 10) {
                    d[i][j] += d[i-1][j+1];
                }

                d[i][j] %= MOD;
            }
        }

        long answer = 0;
        // 마지막 수가 0~9인 경우를 모두 합함
        for (int i = 0 ; i <= 9 ; i++) {
            answer += d[n][i];
        }
        answer %= MOD;
        System.out.println(answer);
    }
}
