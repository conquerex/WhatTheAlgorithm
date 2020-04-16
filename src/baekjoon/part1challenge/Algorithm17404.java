package baekjoon.part1challenge;

import java.util.Scanner;

/**
 * RGB거리 2
 * 문제 : https://www.acmicpc.net/problem/17404
 * 풀이 : https://www.acmicpc.net/source/share/5f0c113a1e554c15a59d2cd6bd34d22c
 * 1번 집의 색은 2번, N번 집의 색과 같지 않아야 한다.
 * N번 집의 색은 N-1번, 1번 집의 색과 같지 않아야 한다.
 * i(2 ≤ i ≤ N-1)번 집의 색은 i-1, i+1번 집의 색과 같지 않아야 한다.
 * 첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.
 * [sample]
 * 3
 * 26 40 83
 * 49 60 57
 * 13 89 99
 * answer : 110
 */
public class Algorithm17404 {
    public static void main(String[] args) {
        final int HIGH_COST = 1000 * 1000 + 1;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = HIGH_COST;
        int[][] list = new int[n+1][3];
        int[][] d = new int[n+1][3];

        for (int i = 1; i <= n ; i++) {
            for (int j = 0; j < 3 ; j++) {
                list[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3 ; j++) {
                // 첫번째 집의 색이 i일 때
                if (i == j) {
                    d[1][j] = list[1][j];
                } else {
                    /**
                     * 모든 경우의 값을 다 넣어야 하고
                     * 결국 min값을 구하는 것이기 때문에
                     * 불필요한 경우를 거르기 위해 큰값을 다른 색의 경우에 넣어둔다.
                     */
                    d[1][j] = HIGH_COST;
                }
            }

            // d[j-1][] : 이전것과 다른 색인 경우만 찾으면 된다.
            for (int j = 2; j <= n ; j++) {
                d[j][0] = Math.min(d[j-1][1], d[j-1][2]) + list[j][0];
                d[j][1] = Math.min(d[j-1][0], d[j-1][2]) + list[j][1];
                d[j][2] = Math.min(d[j-1][0], d[j-1][1]) + list[j][2];
            }

            for (int j = 0; j < 3 ; j++) {
                if (i == j) continue; // 첫번째 집이 i 컬러이기 때문
                result = Math.min(result, d[n][j]);
            }
        }

        System.out.println(result);
    }
}
