package baekjoon.part1_07_challenge;

import java.util.Scanner;

/**
 * 동물원
 * 문제 : https://www.acmicpc.net/problem/1309
 * 풀이 : https://www.acmicpc.net/source/share/aa648f9f4b55408fb022225cb79e50fd
 *
 * 마지막에는 반드시 동물이 있어야 한다.
 * [sample]
 * 4
 * answer : 41
 */
public class Algorithm1309 {

    static final int MOD = 9901;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        /**
         * d[i] = d[i-1] + 2*d[i-2] + 2*d[i-3] + ...
         * d[i-1] : d[i]와 반대방향으로 한가지 경우 뿐이다.
         * d[i-1] 외 경우 : d[i]와 상관없으므로 "OX" 혹은 "XO"
         * sum[i] = d[0] + d[1] + ... + d[i]
         * 즉, d[i] = d[i-1] + 2*sum[i-2]
         */
        int[] d = new int[n+1];
        int[] sum = new int[n+1];

        d[0] = 1;
        sum[0] = d[0];
        d[1] = 2;
        sum[1] = d[0] + d[1];

        for (int i = 2; i <= n ; i++) {
            d[i] = d[i-1] + 2 * sum[i-2];
            sum[i] = sum[i-1] + d[i];
            d[i] %= MOD;
            sum[i] %= MOD;
        }

        System.out.println(sum[n]);
    }
}
