package study2020.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Jongkook on 04/06/2020.
 * 문제 출처 : https://www.acmicpc.net/problem/2579
 * <p>
 * Time Complexity :
 * Used Algorithm : DP
 * Used Data structure :
 */

public class week2_02579 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            System.out.println(stepUp(arr));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int stepUp(int[] arr) {
        int length = arr.length;
        if (length <= 1) return arr[0];
        if (length <= 2) return arr[0] + arr[1];

        int[] dp = new int[length];
        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        dp[2] = maxValue(arr[0], arr[1]) + arr[2];

        for (int i = 3; i < length; i++) {
            dp[i] = maxValue(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
        }
        return dp[length - 1];
    }

    static int maxValue(int a, int b) {
        return a > b ? a : b;
    }
}
