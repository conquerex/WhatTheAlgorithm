package study2020.week30;

/**
 * Created by Jongkook on 2020/12/13.
 * 문제 출처 :
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class week27_p42883 {
    public static void main(String[] args) {
        System.out.println(solution("4177252841", 4));
    }

    public static String solution(String number, int k) {
        int length = number.length();
        // 반드시 남아야하는 숫자 갯수
        int count = length - k;

        StringBuilder sb = new StringBuilder(count);

        int index = -1;
        while (count > 0) {
            int max = 0;
            // 지정된 인덱스 다음 ~ 반드시 남아 있어야하는 숫자열
            for (int i = index + 1; i <= length - count; i++) {
                int num = number.charAt(i) - '0';
                if (num > max) {
                    max = num;
                    index = i;
                }
            }
            // 가장 큰 값을 하나씩 추가
            // (범위 : 지정된 인덱스 다음 ~ 반드시 남아 있어야하는 숫자열)
            sb.append(max);
            count--;
        }

        return sb.toString();
    }
}
