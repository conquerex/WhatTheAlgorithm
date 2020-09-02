package programmers.pr2array;

import java.util.Arrays;

/**
 * K번째수
 * 문제 : https://programmers.co.kr/learn/courses/30/lessons/42748
 * 풀이 : url
 */
public class Solution42747 {
    public static void main(String[] args) {
//        int[] array = {3, 0, 6, 1, 5};
        int[] array = {3, 4, 4, 4, 4, 4};
        System.out.println(solution(array));
    }

    static public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int[] count = new int[citations.length + 1];

        for (int i = 1; i <= citations.length; i++) {
            for (int j = 0; j < citations.length; j++) {
                if (i <= citations[j]) {
                    count[i]++;
                }
            }
        }

        for (int i = 1; i <= citations.length; i++) {
            if (count[i] >= i) {
                answer = Math.max(answer, i);
            }
        }
        return answer;
    }
}

