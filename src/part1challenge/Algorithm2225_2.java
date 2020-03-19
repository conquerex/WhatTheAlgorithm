package part1challenge;

import java.util.Scanner;

/**
 * 합분해 (1차원 배열로 풀어보자)
 * 문제 : https://www.acmicpc.net/problem/2225
 * 풀이 : https://www.acmicpc.net/source/share/7becba12ef1b42079b1163544b5be6b4
 *
 * [sample data]
 * 20 2
 * answer : 21
 */
public class Algorithm2225_2 {

    static final long MOD = 1000000000L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 만들어야 하는 수
        int count = sc.nextInt(); // 갯수
        int[] d = new int[n + 1];
        d[0] = 1;
        // 갯수를 점점 늘린다.
        for (int i = 1; i <= count; i++) {
            // 만들어야 하는 숫자를 대입한다.
            for (int j = 1; j <= n; j++) {
                d[j] += d[j-1];
                d[j] %= MOD;
            }
        }

        System.out.println(d[n] % MOD);
    }
}