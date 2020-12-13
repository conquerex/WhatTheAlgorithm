package study.week30;

/**
 * Created by Jongkook on 2020/12/13.
 * 문제 출처 :https://programmers.co.kr/learn/courses/30/lessons/42862
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class week30_p42862 {
    public static void main(String[] args) {
        int[] lost = {2, 4};
        int[] reserve = {3};
        System.out.println(solution(5, lost, reserve));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] status = new int[n];

        //  0 : 체육복이 있는 경우
        //  1 : 여분이 있음
        // -1 : 잃어버림
        for (int i : lost) {
            status[i - 1]--;
        }
        for (int i : reserve) {
            status[i - 1]++;
        }


        for (int i = 0; i < n; i++) {
            if (status[i] < 0) {
                if (i != 0 && status[i - 1] > 0) {
                    // 앞번호가 여분이 있는지
                    status[i]++;
                    status[i - 1]--;
                } else if (i != n - 1 && status[i + 1] > 0) {
                    // 뒷번호가 여분이 있는지
                    status[i]++;
                    status[i + 1]--;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (status[i] >= 0) answer++;
        }

        return answer;
    }
}
