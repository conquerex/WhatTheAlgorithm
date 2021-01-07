package study2020.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Jongkook on 2020/09/03.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42586
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class week15_p42586 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // 예시 1
            int[] progresses = {93, 30, 55};
            int[] speeds = {1, 30, 5};

            // 예시 2
//            int[] progresses = {95, 90, 99, 99, 80, 99};
//            int[] speeds = {1, 1, 1, 1, 1, 1};

            System.out.println(solution(progresses, speeds));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        return answer;
    }
}
