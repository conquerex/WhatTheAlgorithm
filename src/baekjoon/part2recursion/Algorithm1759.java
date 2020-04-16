package baekjoon.part2recursion;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 암호 만들기
 * 문제 : https://www.acmicpc.net/problem/1759
 * 풀이 : https://www.acmicpc.net/source/share/f38ae1748ce24e85816698676b4cc6cf
 * 첫째 줄에 두 정수 L, C가 주어진다. (3 ≤ L ≤ C ≤ 15)
 * 다음 줄에는 C개의 문자들이 공백으로 구분되어 주어진다.
 * 주어지는 문자들은 알파벳 소문자이며, 중복되는 것은 없다.
 */
public class Algorithm1759 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 서로 다른 n개의 알파벳 소문자들로 구성
        int n = sc.nextInt();
        // 암호에 사용될 제시된 문자 수 : m개
        int m = sc.nextInt();

        String[] ch = new String[m];
        for (int i = 0; i < m; i++) {
            ch[i] = sc.next();
        }

        Arrays.sort(ch);

        showPw(n, ch, "", 0);
    }

    /**
     * @param n  : 만들어야 하는 암호의 길이
     * @param ch : 사용할 수 있는 알파벳
     * @param pw : 현재까지 만든 암호
     * @param i  : 사용할지 말지 결정해야 하는 알파벳의 인덱스
     */
    static void showPw(int n, String[] ch, String pw, int i) {
        if (pw.length() == n) {
            if (check(pw)) {
                System.out.println(pw);
            }
            return;
        }

        if (i >= ch.length) return;

        // 두가지 경우를 모두 확인해야 하므로
        // i번째 글자를 선택한 경우
        showPw(n, ch, pw + ch[i], i + 1);
        // i번째 글자를 선택하지 않은 경우
        showPw(n, ch, pw, i + 1);
    }

    // 자음, 모음 체크
    static boolean check(String password) {
        int ja = 0;
        int mo = 0;

        for (char ch : password.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                mo += 1;
            } else {
                ja += 1;
            }
        }
        return mo >= 1 && ja >= 2;
    }
}
