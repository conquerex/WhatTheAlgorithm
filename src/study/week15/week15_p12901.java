package study.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Jongkook on 2020/09/03.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12901
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 * .
 * 처음에 전 일정의 요일을 담았으나 비효율적이라고 생각되어 개선
 * String day[] = new String[366];
 * 테스트 13 〉	통과 (0.83ms, 42.3MB)
 * 테스트 14 〉	통과 (0.86ms, 42.7MB)
 * .
 * 개선된 코드 -- 비슷하네 ㅎㅎㅎ
 * 테스트 13 〉	통과 (0.88ms, 43.4MB)
 * 테스트 14 〉	통과 (0.83ms, 42.7MB)
 */

public class week15_p12901 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // 월 입력
            int a = Integer.parseInt(br.readLine());
            // 일 입력
            int b = Integer.parseInt(br.readLine());

            System.out.println(solution(a, b));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String solution(int a, int b) {

        // 2016년 1월 1일은 금요일입니다.
        String week[] = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        // 2016년은 윤년 == 366일
        String day[] = new String[366];

        int monthInfo[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // a월 b일이 첫해가 된지 며칠째인지
        int totalDay = 0;

        // 주의할점!!
        // 해당 월을 제외한 그 이전의 월만 합산해야 하기에 x < a - 1
        for (int x = 0; x < a - 1; x++) {
            totalDay += monthInfo[x];
        }

        // 1을 빼주는 것을 잊지말자
        // 100일째를 찾는 것이면 index == 99
        totalDay += b - 1;

        return week[totalDay % 7];
    }
}
