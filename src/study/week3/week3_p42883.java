package study.week3;

/**
 * Created by Jongkook on 15/06/2020.
 * 문제 출처 :
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class week3_p42883 {
    public static void main(String[] args) {
        System.out.println(solution("1231234", 3));
        System.out.println(solution("4177252841", 4));
    }

    public static String solution(String number, int k) {
        final int length = number.length();
        int count = length - k; // 결과값의 자릿수

        StringBuilder builder = new StringBuilder(count);
        int index = -1;

        // builder에 하나씩 숫자를 채울때마다 자릿수값을 하나씩 빼서 원하는 값을 찾아낸다.
        while (count > 0) {
            int max = 0;

            // "4177252841"에서 k가 4인 경우에 count == 6
            // 숫자열의 앞부분, 0~5번째가 되는 "41772"에서 가장 큰 값이 결과값의 첫번째 숫자가 된다.
            // int i = index + 1 : 숫자를 찾게 되면 그다음 숫자열부터 큰 숫자를 찾으면 된다.
            for (int i = index + 1; i <= length - count; i++) {
                int num = number.charAt(i) - '0';
                if (max < num) {
                    max = num;
                    index = i;
                }
                builder.append(max);
                count--;
            }
        }
        return builder.toString();
    }
}
