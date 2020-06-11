package study.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Jongkook on 04/06/2020.
 * 피보나치 수
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12945
 * <p>
 * Time Complexity :
 * Used Algorithm : DP
 * Used Data structure :
 */

public class week3_p12945 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
//            int[] arr = new int[n + 1];
//
//            if (n == 0) arr[0] = 0;
//            if (n > 0) arr[1] = 1;
//
//            if (n > 1) {
//                for (int i = 2; i < n + 1; i++) {
//                    arr[i] = arr[i - 1] + arr[i - 2];
//                }
//            }
//            System.out.println(arr[n]);
            System.out.println(solution(n));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int solution(int n) {
        int[] arr = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            if (i <= 1) {
                arr[i] = i;
                continue;
            }
            arr[i] = arr[i - 1] + arr[i - 2];
            arr[i] %= 1234567;
        }

        return arr[n];
    }
}
