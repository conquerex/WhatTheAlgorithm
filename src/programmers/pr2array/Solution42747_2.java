package programmers.pr2array;

import java.util.Arrays;

/**
 * K번째수
 * 문제 : https://programmers.co.kr/learn/courses/30/lessons/42748
 * 풀이 : https://programmers.co.kr/learn/courses/30/lessons/42747/solution_groups?language=java
 */
public class Solution42747_2 {
    public static void main(String[] args) {
//        int[] array = {3, 0, 6, 1, 5};
        int[] array = {3, 4, 4, 4, 4, 4};
        System.out.println(solution(array));
    }

    static public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int smaller = Math.min(citations[i], citations.length - 1);
            answer = Math.max(smaller, answer);
        }
        return answer;
    }
}

