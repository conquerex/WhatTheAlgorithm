package study2020.week3;

/**
 * Created by Jongkook on 08/06/2020.
 * 문자열 압축
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/60057
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class week3_p60057 {
    public static void main(String[] args) {
        System.out.println(solution("ababcdcdababcdcd"));  // 9
        System.out.println(solution("abcabcabcabcdededededede"));  // 14
    }

    static public int solution(String s) {
        int answer = 0;

        if (s.length() == 1) {
            return 1;
        }

        // i : 압축할 단위
        for (int i = 1; i < s.length(); i++) {
            String ss = s;
            int num = 1; // 패턴이 몇번 나오는지

            for (int j = 0; j < i; j++) {
                // k ~ k + i와 k + i ~ k + i + i를 비교해야 한다.
                // 단위 2배의 공백이 있어야 k + i + i까지 확인 할 수 있다.
                // i==2이고 "ababc"에서 두번째 ab는 "c"와 비교할 필요가 없어 보이지만
                // 구조상 "c와 다르다"를 인지하고 압축 여부를 결정하려면 이 단계가 필요하다.
                ss = ss + "  ";
            }

            String unit = ""; // 압축할 단위 문자
            StringBuilder zip = new StringBuilder(); // 압축한 결과

            for (int k = 0; k < s.length(); k += i) {
                if (ss.length() > k + i + i) {
                    unit = ss.substring(k, k + i);

                    // 압축이 가능하도록 앞뒤 단위가 같은지
                    if (unit.equals(ss.substring(k + i, k + i + i))) {
                        num++;
                    } else {
                        if (num == 1) {
                            // 압축 안함
                            zip.append(unit);
                        } else {
                            // 압축함
                            zip.append(num).append(unit);
                            num = 1;
                        }
                    }
                }
            }

            zip = new StringBuilder(zip.toString().trim());

            if (i == 1) {
                answer = zip.length();
            } else {
                // 최소를 구해야 함으로
                if (answer > zip.length()) {
                    answer = zip.length();
                }
            }
        }

        return answer;
    }
}
