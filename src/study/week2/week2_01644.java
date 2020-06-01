package study.week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Jongkook on 01/06/2020.
 * 문제 출처 : https://www.acmicpc.net/problem/1644
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class week2_01644 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int number = Integer.parseInt(br.readLine());
            boolean[] arr = new boolean[number + 1];
            ArrayList<Integer> list = new ArrayList<>();

            // 에라토스테네스의 체
            for (int i = 2; i * i <= number; i++) {
                for (int j = i * i; j <= number; j += i) {
                    arr[j] = true;
                }
            }

            // 소수만 따로 담기
            for (int i = 2; i <= number; i++) {
                if (!arr[i]) {
                    list.add(i);
                }
            }

            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                int sum = 0;
                for (int j = i; j < list.size(); j++) {
                    sum += list.get(j);

                    if (sum == number) {
                        count++;
                        break;
                    } else if (sum > number) {
                        break;
                    }
                }
            }

            System.out.println(count);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
