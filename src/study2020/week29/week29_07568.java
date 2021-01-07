package study2020.week29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Jongkook on 2020/12/09.
 * 문제 출처 :
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class week29_07568 {


    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int COUNT = Integer.parseInt(br.readLine());

            int[][] array = new int[COUNT][2];

            for (int i = 0; i < COUNT; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                array[i][0] = Integer.parseInt(st.nextToken());
                array[i][1] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < COUNT; i++) {
                int rank = 1;

                for (int j = 0; j < COUNT; j++) {
                    if (i == j) continue;
                    if (array[i][0] < array[j][0] && array[i][1] < array[j][1]) {
                        rank++; // i보다 덩치 큰 것 갯수 찾기
                    }
                }
                System.out.print(rank + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
