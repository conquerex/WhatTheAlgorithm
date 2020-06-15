package study.week4;

import javax.management.InvalidAttributeValueException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Jongkook on 15/06/2020.
 * 문제 출처 :
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
            ArrayList<Integer> list = new ArrayList<>();

            while (max > min) {
                int count = 0;
                int diskSize = (max + min) / 2;
                int tempSize = 0;
                for (int i = 0; i < lessonArr.length; i++) {
                    tempSize += lessonArr[i];
                    if (tempSize > diskSize) {
                        tempSize -= lessonArr[i];
                        list.add(tempSize);
                        tempSize = lessonArr[i];
                        count++;
                    }
                }
                if (count > diskCount) {
                    min++;
                } else if (count <= diskCount) {
                    max--;
                }
            }

            Collections.sort(list);
            System.out.println(list.get(0));
            System.out.println(list.get(list.size() - 1));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
