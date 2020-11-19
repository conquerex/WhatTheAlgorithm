package study.week27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jongkook on 2020/11/19.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/68644
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class week27_p68644 {
    public static void main(String[] args) {
        //
    }

    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int result = numbers[i] + numbers[j];
                // result가 list에 포함되어 있는지 확인
                if (!list.contains(result)) list.add(result);
            }
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }
}
