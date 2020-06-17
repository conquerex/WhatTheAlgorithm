package study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Jongkook on 15/06/2020.
 * 문제 출처 : https://www.acmicpc.net/problem/2343
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class week4_02343 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] arr = br.readLine().split(" ");
            final int lessonCount = Integer.parseInt(arr[0]);
            final int diskCount = Integer.parseInt(arr[1]);
            int[] lessonArr = new int[lessonCount];
            String[] lessonInput = br.readLine().split(" ");

            int max = 0;
            for (int i = 0; i < lessonArr.length; i++) {
                lessonArr[i] = Integer.parseInt(lessonInput[i]);
                max += lessonArr[i];
            }
            Arrays.sort(lessonArr);
            int min = lessonArr[lessonCount - 1];

            while (max >= min) {
//                System.out.println("-------");
//                System.out.println(min);
//                System.out.println(max);
                int count = 0;
                // 이분탐색을 위한 mid값
                int mid = (max + min) / 2;
                int sum = 0;

                for (int i = 0; i < lessonCount; i++) {
                    if (sum + lessonArr[i] > mid) {
                        sum = 0; // reset
                        count++; // 디스크 갯수 세기
                    }
                    sum += lessonArr[i];
                }

                if (sum != 0) count++; // 남은 레슨 길이가 있을 때, 갯수 추가

                if (count <= diskCount) max = mid - 1;
                else min = mid + 1;
            }

            System.out.println(min);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
