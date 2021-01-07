package study2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Jongkook on 2021/01/07.
 * 문제 출처 :https://www.acmicpc.net/problem/1644
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class week33_01644 {
    public static void main(String[] args) {
        long sum = 0;
        int start = 0, end = 0;
        long result = 0;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            boolean[] arr = new boolean[n + 1];
            arr[0] = arr[1] = true;

            // i의 배수를 거를 때, 그 이전 수를 거른 뒤 첫 대상이 i*i
            for (int i = 2; i * i < n; i++) {
                // i가 소수일 때
                if (!arr[i]) {
                    for (int j = i * i; j <= n; j += i) arr[j] = true;
                }
            }

            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                if (!arr[i]) list.add(i);
            }

            while (start < list.size()) {
                if (sum > n || end == list.size()) {
                    sum -= list.get(start);
                    start++;
                } else {
                    sum += list.get(end);
                    end++;
                }

                if (sum == n) result++;
            }

            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
