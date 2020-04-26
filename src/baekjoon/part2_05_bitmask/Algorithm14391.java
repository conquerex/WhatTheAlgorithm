package baekjoon.part2_05_bitmask;

import java.util.Scanner;

/**
 * 종이 조각
 * 문제 : https://www.acmicpc.net/problem/14391
 * 풀이 : https://www.acmicpc.net/source/share/0723f85d7e7c4a99a150ba83796c1432
 * 첫째 줄에 종이 조각의 세로 크기 N과 가로 크기 M이 주어진다. (1 ≤ N, M ≤ 4)
 * 둘째 줄부터 종이 조각이 주어진다. 각 칸에 쓰여 있는 숫자는 0부터 9까지 중 하나이다.
 */
public class Algorithm14391 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] paper = new int[n][m];

        for (int i = 0; i < n; i++) {
            String input = sc.next();
            for (int j = 0; j < m; j++) {
                // 아스키코드 때문에 0을 빼줌
                paper[i][j] = input.charAt(j) - '0';
            }
        }

        int result = 0;

        // 0 : -
        // 1 : |
        // 모든 집합의 케이스
        for (int i = 0; i < (1 << (n * m)); i++) {
            int sum = 0;
            /**
             * 가로줄
             */
            for (int j = 0; j < n; j++) {
                int cur = 0;
                for (int k = 0; k < m; k++) {
                    // /m ==> j
                    // %m ==> k
                    int num = j * m + k;
                    // 0 : - ===> '0'이여야 한다.
                    if ((i & (1 << num)) == 0) {
                        // 기존의 수에서 10을 곱해서 자릿수를 올린다.
                        cur = cur * 10 + paper[j][k];
                    } else {
                        // 지금까지 구했던 cur를 sum에 넣고 cur는 리셋
                        sum += cur;
                        cur = 0;
                    }
                }
                // if ((i & (1 << num)) == 0)로 끝났을 경우를 대비한 sum 처리
                sum += cur;
            }

            /**
             * 세로줄
             */
            for (int j = 0; j < m; j++) {
                int cur = 0;
                for (int k = 0; k < n; k++) {
                    // /n ==> j
                    // %n ==> k
                    int num = k * m + j; // j와 k의 역할이 바뀌었으므로 이부분도 변경해야함
                    // 1 : | ===> '0'이 아니여야 한다.
                    if ((i & (1 << num)) != 0) {
                        // 기존의 수에서 10을 곱해서 자릿수를 올린다.
                        // j와 k의 순서는 위와 다르게 바뀐다
                        cur = cur * 10 + paper[k][j];
                    } else {
                        // 지금까지 구했던 cur를 sum에 넣고 cur는 리셋
                        sum += cur;
                        cur = 0;
                    }
                }
                // if ((i & (1 << num)) == 0)로 끝났을 경우를 대비한 sum 처리
                sum += cur;
            }
            result = Math.max(result, sum);
        }

        System.out.println(result);
    }
}
