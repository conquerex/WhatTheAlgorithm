package part1;

import java.util.Scanner;

/**
 * 동물원
 * 문제 : https://www.acmicpc.net/problem/1309
 * 풀이 : https://www.acmicpc.net/source/share/dcbc1412fd644cd6a68538f4fb748990
 *
 * 이 동물원에는 사자들이 살고 있는데 사자들을 우리에 가둘 때, 가로로도 세로로도 붙어 있게 배치할 수는 없다.
 * 첫째 줄에 사자를 배치하는 경우의 수를 9901로 나눈 나머지를 출력하여라.
 */
public class Algorithm1309 {

    static final long MOD = 9901L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        /**
         * 동물원 사이즈 : nX2
         * n+1 : 사이즈
         * 3 : 경우의 수
         *  - 0 : 동물 배치 안함
         *  - 1 : 왼쪽에 배치
         *  - 2 : 오른쪽에 배치
         */
        int[][] d = new int[n+1][3];
        // 초기화
        d[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            // 동물 배치 안함
            d[i][0] = d[i-1][0] + d[i-1][1] + d[i-1][2];
            // 왼쪽에 배치
            d[i][1] = d[i-1][0] + d[i-1][2];
            // 오른쪽에 배치
            d[i][2] = d[i-1][0] + d[i-1][1];

            for (int j = 0 ; j < 3; j++) {
                d[i][j] %= MOD;
            }
        }

        int answer = 0;
        for (int j = 0 ; j < 3; j++) {
            answer += d[n][j];
        }

        System.out.println(answer % MOD);
    }
}
