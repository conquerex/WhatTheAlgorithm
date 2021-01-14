package study2021.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Jongkook on 2021/01/14.
 * 문제 출처 :https://www.acmicpc.net/problem/3273
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class week02_03273 {
    public static void main(String[] args) {
        long sum = 0;
        long result = 0;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine()); // 첫째줄
            StringTokenizer st = new StringTokenizer(br.readLine()); // 둘째줄
            int x = Integer.parseInt(br.readLine()); // 셋째줄

            int[] input = new int[n];

            int start = 0;
            int end = n - 1; // 중요 : 2개의 포인터를 어디에 맞출 것인가에 따라 속도가 다를 수 있다.

            while (st.hasMoreTokens()) {
                input[start++] = Integer.parseInt(st.nextToken());
            }

            // 반드시 start 초기화
            start = 0;

            // 투포인터 사용시 반드시 정렬 먼저
            Arrays.parallelSort(input);

            while (start < end) {
                // sum을 다시 하는 시점이 중요
                sum = input[start] + input[end];

                if (sum > x) {
                    // start 위치를 옮기는 동시에 end도 재조정
                    end--;
                } else {
                    start++;
                }

                if (sum == x) result++;
            }

            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
