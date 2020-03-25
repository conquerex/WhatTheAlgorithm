package study;

import java.util.Arrays;

/**
 * 완주하지 못한 선수
 * 문제 : https://programmers.co.kr/learn/courses/30/lessons/42576
 * 풀이 : https://programmers.co.kr/learn/courses/30/lessons/42576/solution_groups?language=java
 */
public class Programmers42576 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] part = {"marina", "josipa", "nikola", "vinko", "filipa", "test"};
        String[] comp = {"josipa", "filipa", "marina", "vinko", "nikola"};

        System.out.println(solution.solution(part, comp));
    }
}

class Solution {
    public String solution(String[] participant, String[] completion) {
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
