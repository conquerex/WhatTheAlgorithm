package pr1hash;

import java.util.Arrays;

/**
 * 완주하지 못한 선수
 * 문제 : https://programmers.co.kr/learn/courses/30/lessons/42576
 * 풀이 : https://programmers.co.kr/learn/courses/30/lessons/42576/solution_groups?language=java
 */
public class Solution42577 {
    public static void main(String[] args) {

        String[] part = {"marina", "josipa", "nikola", "vinko", "filipa", "test"};
        String[] comp = {"josipa", "filipa", "marina", "vinko", "nikola"};

        System.out.println(solution(part, comp));
    }

    public static String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i;
        for (i = 0; i < completion.length; i++) {
            if (completion[i] != participant[i]) {
                return participant[i];
            }
        }
        return participant[i];
    }
}
