package part1;

import java.util.Scanner;

/**
 * 제곱수의 합
 * 문제 : https://www.acmicpc.net/problem/1699
 * 풀이 : https://www.acmicpc.net/source/share/454e58d9e21a4042ba74ec9af82c13a4
 *
 * 첫째 줄에 자연수 N이 주어진다. (1 ≤ N ≤ 100,000)
 * 주어진 자연수를 제곱수의 합으로 나타낼 때에 그 제곱수 항의 최소 개수를 출력한다.
 */
public class Algorithm1699 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n+1];

        for (int i = 1 ; i <= n ; i++) {
            d[i] = i; // 1^2로 i개만큼 구성하면 최대 == 최소 개수를 출력할 수 있다.
            for (int j = 1 ; j*j <= i; j++) {
                if (d[i] > d[i-j*j] + 1) {
                    // d[j*j] == 1이므로 +1
                    d[i] = d[i-j*j] + 1;
                }
            }
        }

        System.out.println(d[n]);
    }
}
