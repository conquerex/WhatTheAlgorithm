package codetest.klc;

/**
 * @author Jongkook
 * @date : 2020/09/07
 */

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(solution(1000, 1111));
    }

    public static int solution(int n, int m) {
        int answer = 0;

        for (int i = n; i <= m; i++) {
            char[] s = (i + "").toCharArray();

            // 숫자가 1자리인 경우
            if (s.length == 1) answer++;
            // 숫자가 2자리 이상인 경우
            if (s.length > 1) {
                boolean check = true;
                for (int j = 0; j < s.length / 2; j++) {
                    if (s[j] != s[s.length - 1 - j]) {
                        check = false;
                        break;
                    }
                }
                if(check) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
