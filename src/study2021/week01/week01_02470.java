package study2021.week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Jongkook on 2021/01/14.
 * 문제 출처 :
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class week01_02470 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int result = 0;

            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] input = new int[n];
            for (int i = 0; i < n; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.parallelSort(input);
            for (int i : input) System.out.print(i + " ");

            // 산성은 무조건 0보다 크다
            // 알칼리성은 무조건 0보다 작다
            if (input[0] > 0) {
                // 제일 작은 수가 양수인가
                result = input[0] + input[1];
            } else if (input[n - 1] < 0) {
                // 제일 큰 수가 음수인가
                result = input[n - 2] + input[n - 1];
            } else {
                // 핵심!!
            }

            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
