package study2020.week33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Jongkook on 2021/01/07.
 * 문제 출처 : https://www.acmicpc.net/problem/2003
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 * <p>
 * N개의 수로 된 수열 A[1], A[2], …, A[N] 이 있다.
 * 이 수열의 i번째 수부터 j번째 수까지의 합
 * A[i] + A[i+1] + … + A[j-1] + A[j]가 M이 되는 경우의 수를 구하는 프로그램을 작성하시오.
 */

public class week33_02003 {
    public static void main(String[] args) {
        long sum = 0;
        int start = 0, end = 0;
        long result = 0;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] list = new int[n];
            while (st.hasMoreTokens()) {
                list[start++] = Integer.parseInt(st.nextToken());
            }

            start = 0;

            while (start < n) {
                if (sum > m || end == n) {
                    sum -= list[start];
                    start++;
                } else {
                    // 가장 첫 sum
                    // sum이 m보다 작고 end가 n-1이 아닐 때
                    sum += list[end];
                    end++;
                }

                if (sum == m) result++;
            }

            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
