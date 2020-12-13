package study.week30;

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
        String answer = "";
        int removePoint = k;
        // 일단 k번째 숫자 중 가장 큰것을 구하자
        char[] nums = number.toCharArray();
        char[] result = new char[nums.length - k];
        for (int i = 0; i < k; i++) {
            if (result.length > 0) {
                for (int j = 0; j < result.length; j++) {

                }
            } else {
                result[0] = nums[0];;
            }
        }
        return answer;
    }
}
