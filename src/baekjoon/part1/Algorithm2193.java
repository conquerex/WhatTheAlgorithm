package baekjoon.part1;

import java.util.Scanner;

/**
 * 이친수
 * 문제 : https://www.acmicpc.net/problem/2193
 * 풀이 : https://www.acmicpc.net/source/share/b542f75a4ffe498ab6112170172b50fd
 *
 * 1. 이친수는 0으로 시작하지 않는다.
 * 2. 이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.
 * 첫째 줄에 N이 주어진다.
 * 첫째 줄에 N자리 이친수의 개수를 출력한다.
 * N(1 ≤ N ≤ 90)이 주어졌을 때, N자리 이친수의 개수를 구하는 프로그램을 작성하시오.
 */
public class Algorithm2193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 수의 길이가 n인 경우
        long[] d = new long[n+1];

        // 한자리인 경우, 0을 들어갈 수 없다. 오직 1
        d[1] = 1;

        if (n > 1) {
            d[2] = 1; // 11은 불가, 오직 10
        }

        for (int i = 3 ; i <= n; i++) {
            /**
             * 0으로 끝나는 경우 : d[i-1], 앞에 0/1 모두 올 수 있다.
             * 1으로 끝나는 경우 : d[i-2], 앞에 0만 가능, ***01처럼 2개의 숫자를 세트로 묶는다.
             */
            d[i] = d[i-1] + d[i-2];
        }

        System.out.println(d[n]);
    }
}
