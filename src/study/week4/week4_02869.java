package study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Jongkook on 11/06/2020.
 * 문제 출처 :
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class week4_02869 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] arr = br.readLine().split(" ");
            final int a = Integer.parseInt(arr[0]);
            final int b = Integer.parseInt(arr[1]);
            final int v = Integer.parseInt(arr[2]);

            int date = 0;
            int now = 0;

            while (now < v) {
                date++;
                switch (date) {
                    case 1:
                        now = a;
                        break;
                    default:
                        now = now - b + a;
                        break;
                }
            }

            System.out.println(date);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
