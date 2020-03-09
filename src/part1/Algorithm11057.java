package part1;

import java.util.Scanner;

/**
 * 오르막 수
 * 문제 : https://www.acmicpc.net/problem/11057
 * 풀이 : https://www.acmicpc.net/source/share/dc186ddd614b4569af3f34313b67bbd5
 * 수의 길이 N이 주어졌을 때, 오르막 수의 개수를 구하는 프로그램을 작성하시오. 수는 0으로 시작할 수 있다.
 * 첫째 줄에 길이가 N인 오르막 수의 개수를 10,007로 나눈 나머지를 출력한다.
 */
public class Algorithm11057 {

    static final long MOD = 10007L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // D[i][j] = 길이가 i이고 마지막 숫자가 j 인 오르막 수의 개수
        int[][] d = new int[n+1][10];

        // 한자리 수인 경우
        for (int i = 0; i <= 9; i++) {
            d[1][i] = 1;
        }

        // 두자리 이상의 경우
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j; k++) {
                    d[i][j] += d[i-1][k];
                    d[i][j] %= MOD;
                }
            }
        }

        long answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer += d[n][i];
        }

        System.out.println(answer % MOD);
    }
}
