package study2020.week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Jongkook on 26/05/2020.
 * 문제 출처 : https://www.acmicpc.net/problem/1912
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class week1_01912 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // todo : String tokenizer
            int n = Integer.parseInt(br.readLine());
            String[] arrayText = br.readLine().split(" ");
            int[] array = new int[n];

            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(arrayText[i]);
            }

            int[] sum = new int[n];
            int result = sum[0] = array[0];

            for (int i = 1; i < n; i++) {
                sum[i] = max(array[i], array[i] + sum[i - 1]);
                result = max(result, sum[i]);
            }

            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static int max(int a, int b) {
        return a > b ? a : b;
    }
}
