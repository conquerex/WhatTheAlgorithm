package study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Jongkook on 02/06/2020.
 * 문제 출처 : https://www.acmicpc.net/problem/1806
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class week2_01806 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] arr = br.readLine().split(" ");
            int n = Integer.parseInt(arr[0]);
            int s = Integer.parseInt(arr[1]);

            String[] arr2 = br.readLine().split(" ");
            int[] arrNum = new int[arr2.length];
            for (int i = 0; i < arr2.length; i++) {
                arrNum[i] = Integer.parseInt(arr2[i]);
            }

            int total = 0, count = 0;
            int start = 0, end = 0;

            while (true) {
                if (total >= s) {
                    if (count == 0 || count > end - start) {
                        count = end - start;
                    }
                    total -= arrNum[start++];
                } else if (end == n) {
                    break;
                } else {
                    total += arrNum[end++];
                }
            }

//            for (int i = 0; i < arrNum.length; i++) {
//                int sum = 0;
//                int cnt = 0;
//                for (int j = i; j < arrNum.length; j++) {
//                    sum += arrNum[j];
//                    cnt++;
//                    if (sum >= s) {
//                        if (count == 0 || count > cnt) {
//                            count = cnt;
//                            break;
//                        }
//                    }
//                }
//            }

            System.out.println(count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
