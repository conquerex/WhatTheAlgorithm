package part1;

import java.util.Scanner;

/**
 * 가장 긴 감소하는 부분 수열
 * 문제 : https://www.acmicpc.net/problem/11722
 * 풀이 : https://www.acmicpc.net/source/share/4caa16e09461451b973bbfb8cf70e511
 * <p>
 * 수열 A가 주어졌을 때, 가장 긴 감소하는 부분 수열을 구하는 프로그램을 작성하시오.
 * [sample]
 * 6
 * 10 30 10 20 20 10
 * Answer : 3
 */
public class Algorithm11722 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] list = new int[n + 1];
        int[] d = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = sc.nextInt();
        }

        for (int i = n; i >= 1; i--) {
            // 초기화
            d[i] = 1;
            for (int j = i + 1; j <= n; j++) {
                // j는 i보다 무조건 크거나 같다 (헷갈리지 말자!!!)
                if (list[i] > list[j] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                }
            }
        }

        int result = d[1];
        for (int i = 2; i <= n; i++) {
            if (result < d[i]) {
                result = d[i];
            }
        }

        System.out.println(result);
    }
}
