package pr2array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 가장 큰 수
 * 문제 : https://programmers.co.kr/learn/courses/30/lessons/42746
 * 풀이 : url
 */
public class Solution42746 {
    public static void main(String[] args) {
        int[] array = {3, 30, 34, 5, 9};
        System.out.println(solution(array));
    }

    static public String solution(int[] numbers) {
        String answer = "";
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer t0, Integer t1) {
                String s0 = String.valueOf(t0);
                String s1 = String.valueOf(t1);
                return - Integer.compare(Integer.parseInt(s0 + s1), Integer.parseInt(s1 + s0));
            }
        });

        for (int i : list) {
            answer += i;
        }

        if (answer.charAt(0) == '0') {
            return "0";
        }
        return answer;
    }
}

