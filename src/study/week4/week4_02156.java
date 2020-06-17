package study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Jongkook on 17/06/2020.
 * 포도주 시식
 * 문제 출처 : https://www.acmicpc.net/problem/2156
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class week4_02156 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];
            int[] dp = new int[n + 1];

            // for문 범위 지정에 주의
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            dp[0] = 0;
            dp[1] = arr[1];
            dp[2] = arr[1] + arr[2];

            // for문 범위 지정에 주의
            for (int i = 3; i <= n; i++) {
                // 3번 연속으로 마실수 없으므로
                dp[i] = getMax(
                        dp[i - 3] + arr[i - 1] + arr[i],
                        dp[i - 2] + arr[i]);
                // 이전것과 비교를 해서 무엇이 더 큰지 한번 더 확인해야 한다.
                dp[i] = getMax(dp[i], dp[i - 1]);
            }

            System.out.println(dp[n]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getMax(int a, int b) {
        return a > b ? a : b;
    }
}
