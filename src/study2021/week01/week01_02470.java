package study2021.week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Jongkook on 2021/01/14.
 * 문제 출처 :https://www.acmicpc.net/problem/2470
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class week01_02470 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] input = new int[n];
            for (int i = 0; i < n; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.parallelSort(input);

            // 산성은 무조건 0보다 크다
            // 알칼리성은 무조건 0보다 작다
            if (input[0] > 0) {
                // 제일 작은 수가 양수인가
                System.out.println(input[0] + " " + input[1]);
            } else if (input[n - 1] < 0) {
                // 제일 큰 수가 음수인가
                System.out.println(input[n - 2] + " " + input[n - 1]);
            } else {
                int[] result = solution(input);
                System.out.println(result[0] + " " + result[1]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] solution(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int saveSum = 2000000000;
        int[] result = new int[2];

        int sum = 0;

        while (start < end) {
            sum = arr[start] + arr[end];

            if (Math.abs(sum) < saveSum) {
                result[0] = arr[start];
                result[1] = arr[end];
                saveSum = Math.abs(sum);
            }

            if (sum > 0)
                // 큰쪽 수를 줄이기
                end--;
            else
                // 작은쪽 수를 늘리기
                start++;
        }

        return result;
    }
}
