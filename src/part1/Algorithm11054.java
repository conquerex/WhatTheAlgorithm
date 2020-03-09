package part1;

import java.util.Scanner;

/**
 * 가장 긴 바이토닉 부분 수열 (증가 + 감소 경우)
 * 문제 : https://www.acmicpc.net/problem/11054
 * 풀이 : https://www.acmicpc.net/source/share/9aa0833f59ff4bba9fedd03f0ab89ed5
 * {10, 20, 30, 25, 20}과 {10, 20, 30, 40}, {50, 40, 25, 10} 은 바이토닉 수열이지만,
 * {1, 2, 3, 2, 1, 2, 3, 2, 1}과 {10, 20, 30, 40, 20, 30} 은 바이토닉 수열이 아니다.
 *
 * [sample]
 * 10
 * 1 5 2 1 4 3 4 5 2 1
 * 예제의 경우 {'1' 5 '2' 1 4 '3' '4' '5' '2' '1'}이 가장 긴 바이토닉 부분 수열이다.
 */
public class Algorithm11054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] list = new int[n + 1];
        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }

        int[] dIncrease = new int[n];
        int[] dDecrease = new int[n];

        for (int i = 0; i < n; i++) {
            dIncrease[i] = 1;
            for (int j = 0; j < i; j++) {
                // i보다 j가 더 작다. 즉 i > j, list[i] > list[j]
                if (list[i] > list[j] && dIncrease[i] < dIncrease[j] + 1) {
                    dIncrease[i] = dIncrease[j] + 1;
                }
            }
        }

        for (int i = n-1; i >= 0; i--) {
            dDecrease[i] = 1;
            for (int j = i+1; j < n; j++) {
                // i보다 j가 더 큰 숫자. 즉 i < j, list[i] > list[j]
                if (list[i] > list[j] && dDecrease[i] < dDecrease[j] + 1) {
                    dDecrease[i] = dDecrease[j] + 1;
                }
            }
        }

        // 두개의 리스트에 중복되는 가운데 숫자 1개는 빼줘야한다.
        int result = dIncrease[0] + dDecrease[0] - 1;

        for (int i = 0; i < n; i++) {
            if (result < dIncrease[i] + dDecrease[i] - 1) {
                result = dIncrease[i] + dDecrease[i] - 1;
            }
        }

        System.out.println(result);
    }
}
