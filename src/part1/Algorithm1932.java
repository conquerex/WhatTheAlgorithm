package part1;

import java.util.Scanner;

/**
 * 정수 삼각형
 * 문제 : https://www.acmicpc.net/problem/1932
 * 풀이 : https://www.acmicpc.net/source/share/fbc271224ec54d57b0c225f834435156
 *
 * 맨 위층 숫자부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때,
 * 이제까지 선택된 수의 합이 최대가 되는 경로를 구하는 프로그램을 작성하라.
 * [sample]
 * 5
 * 7
 * 3 8
 * 8 1 0
 * 2 7 4 4
 * 4 5 2 6 5
 * Answer : 30
 */
public class Algorithm1932 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] list = new int[n][n];
        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                list[i][j] = sc.nextInt();
            }
        }

        // 초기화, 가장 상단
        d[0][0] = list[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                // 윗행의 오른쪽 수를 받아온다.
                d[i][j] = d[i-1][j] + list[i][j];
                if (j-1 >= 0 && d[i][j] < d[i-1][j-1] + list[i][j]) {
                    // 윗행의 왼쪽 수가 더 큰 경우
                    d[i][j] = d[i-1][j-1] + list[i][j];
                }
            }
        }

        int result = d[n-1][0];
        for (int i = 1; i < n; i++) {
            if (result < d[n-1][i]) {
                result = d[n-1][i];
            }
        }
        System.out.println(result);
    }
}
