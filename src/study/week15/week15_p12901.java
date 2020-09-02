package study.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Jongkook on 2020/09/03.
 * 문제 출처 :
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
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

        // 366개의 요일
        int i = 0;
        while (i < day.length) {
            int j = 0;
            while (j < week.length) {
                if (i == 366) break; // 366번째 요일이 j의 마지막 회차에 딱 떨어지지 않는 이상 366일이 될 수 있다.
                day[i] = week[j];
                j++;
                i++;
            }
        }

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

        return day[totalDay];
    }
}
