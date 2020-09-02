package programmers.pr3bruteforce;

/**
 * 모의고사
 * 문제 : https://programmers.co.kr/learn/courses/30/lessons/42840
 * 풀이 : https://programmers.co.kr/learn/courses/30/lessons/42840/solution_groups?language=java
 */
public class Solution42840 {
    public static void main(String[] args) {
        int numbers[] = {1, 3, 2, 4, 2};
        System.out.println(solution(numbers));
    }

    static public int[] solution(int[] answers) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];

        // a, b, c의 갯수만큼 나머지를 구해서
        // 제시된 문제의 정답과 매칭을 시켜보고 값이 같은지 확인하면 된다.
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == a[i % a.length]) {
                score[0]++;
            }

            if (answers[i] == b[i % b.length]) {
                score[1]++;
            }

            if (answers[i] == c[i % c.length]) {
                score[2]++;
            }
        }

        // 가장 높은 점수를 구하고
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));

        // 6개의 케이스를 모두 분기처리해서 반환한다.
        if (maxScore == score[0] && maxScore == score[1] && maxScore == score[2]) return new int[]{1, 2, 3};
        else if (maxScore == score[0] && maxScore == score[1]) return new int[]{1, 2};
        else if (maxScore == score[1] && maxScore == score[2]) return new int[]{2, 3};
        else if (maxScore == score[0] && maxScore == score[2]) return new int[]{1, 3};
        else if (maxScore == score[0]) return new int[]{1};
        else if (maxScore == score[1]) return new int[]{2};
        return new int[]{3};
    }


}
