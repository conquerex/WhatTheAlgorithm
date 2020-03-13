package part1challenge;

import java.util.Scanner;

/**
 * 합분해
 * 문제 : https://www.acmicpc.net/problem/2225
 * 풀이 : https://www.acmicpc.net/source/share/4a6b3ffc40154b3e8dd4aa0dc8870855
 *
 * D[K][N]   = D[K-1][0] + D[K-1][1] + ... + D[K-1][N-1] + D[K-1][N]
 * D[K][N-1] = D[K-1][0] + D[K-1][1] + ... + D[K-1][N-1]
 * D[K][N]   = D[K][N-1] + D[K-1][N]
 */
public class Algorithm2225 {

    static final long MOD = 1000000000L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 만들어야 하는 수
        int count = sc.nextInt(); // 갯수

        long[][] d = new long[count+1][n+1];

        // 첫번째 값
        d[0][0] = 1;

        for (int i = 1; i <= count ; i++) {
            for (int j = 0; j <= n ; j++) {
                d[i][j] = d[i-1][j];
                if (j-1 >= 0) {
                    d[i][j] += d[i][j-1];
                }
                d[i][j] %= MOD;
            }
        }

        System.out.println(d[count][n] % MOD);
    }
}

/**
 4개 3까지
 d[4][3]
 3개로 N만드는 방법
     = d[3][0] + d[3][1] + d[3][2] + d[3][3]
     // d[3][0] + d[3][1] + d[3][2] + d[3][3]
     000
     100 010 001
     011 101 110 002 020 200
     111 012 102 120 021 201 210 003 030 300

     // d[4][3]
     0003
     1002 0102 0012
     0111 1011 1101 0021 0201 2001
     1110 0120 1020 1200 0210 2010 2100 0030 0300 3000

     // d[4][3]를 정리
     0003 0030 0300 3000
     0012 0021 0102 0201 0120 0210 1002 1020 1200 2001 2010 2100
     0111 1011 1101 1110
 */
