package study.week22;

import java.util.ArrayList;

/**
 * Created by Jongkook on 2020/10/20.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42586
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class week15_p42586 {
    public static void main(String[] args) {
        // 예시 1
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        for (int x : solution(progresses, speeds)) {
            System.out.println(x);
        }
    }

    static public int[] solution(int[] progresses, int[] speeds) {
        int compare = -1;
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int day = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            if (day > compare) {
                if (count > 0) list.add(count);
                count = 1;
                compare = day;
            } else {
                count++;
            }
        }

        // 최종 count를 추가해야 함
        list.add(count);
        return list.stream().mapToInt(i -> i).toArray();
    }
}
