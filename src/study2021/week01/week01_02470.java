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
                int start = 0;
                int end = input.length - 1;
                int mult = -1;
                while (mult < 0) {
                    end--;
                    mult = input[0] * input[end];
                }

                // 짧은 구간 찾기
                if (end + 1 > input.length / 2) {
                    start = end;
                    end = input.length - 1;
                } else {
                    System.out.println();
                    end++;
                }

                int saveSum = 2000000000;
                int[] saveValue = new int[2];
                for (int i = start; i <= end; i++) {
                    int value = binarySearch(input, input[i]);
                    int absSum = Math.abs(input[i] + value);
                    if (saveSum > absSum) {
                        saveSum = absSum;
                        saveValue[0] = value;
                        saveValue[1] = input[i];
                    }
                }

                Arrays.sort(saveValue);
                System.out.println(saveValue[0] + " " + saveValue[1]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end) / 2;
        int sum = 0;
        int saveSum = 2000000000;
        int savePosition = 0;

        while (start <= end) {
            sum = Math.abs(arr[mid] + target); // 절대값

            if (sum == 0) {
                System.out.println(mid);
            } else {
                if (sum < saveSum) {
                    saveSum = sum;
                    savePosition = mid;
                }

                if (arr[mid] + target > 0) end = mid - 1;
                else start = mid + 1;
            }
        }

        return arr[savePosition];
    }
}
