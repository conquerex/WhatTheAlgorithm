package part1;

import java.util.Scanner;

/**
 * 합분해
 * 문제 : https://www.acmicpc.net/problem/2225
 * 풀이 : https://www.acmicpc.net/source/share/f1f0f435bcf14e2b8c9d8d6d576eb496
 *
 * 0부터 N까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수를 구하는 프로그램을 작성하시오.
 * 덧셈의 순서가 바뀐 경우는 다른 경우로 센다(1+2와 2+1은 서로 다른 경우).
 * 또한 한 개의 수를 여러 번 쓸 수도 있다.
 * 첫째 줄에 두 정수 N(1 ≤ N ≤ 200), K(1 ≤ K ≤ 200)가 주어진다.
 * 첫째 줄에 답을 1,000,000,000으로 나눈 나머지를 출력한다.
 */
public class Algorithm2225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // n : 만들어야 하는 숫자, 동시에 쓸수 있는 숫자 종류, 0부터 시작
        int n = sc.nextInt();
        // c : 사용해야하는 숫자의 갯수 (count)
        int c = sc.nextInt();

        int[][] d = new int[c+1][n+1];
        // 초기화
        d[0][0] = 1;

        /**
         * ? + ? + ... + ? + L = N
         * ---> d[Count][N]
         * ? + ? + ... + ? + = N - L
         * ---> d[Count-1][N-L]
         */
        for (int i = 1; i <= c ; i++) {
            for (int j = 0; j <= n ; j++) {
                for (int l = 0; l <= j; l++) {
                    // 사용해야하는 숫자의 갯수가 i일 때
                    // 그리고 만들어야 하는 수가 j일때 경우의 수
                    d[i][j] += d[i-1][j-l];
                }
            }
        }

        System.out.println(d[c][n]);
    }
}
