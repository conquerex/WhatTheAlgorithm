package part2recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 부등호
 * 문제 : https://www.acmicpc.net/problem/2529
 * 풀이 : https://www.acmicpc.net/source/share/745b86e0551d4d9b90898bd25bd5da7f
 * 추가 풀이 : https://www.acmicpc.net/source/share/210b99c6ff4f4e55a84e2f46d8f603b0
 * 두 종류의 부등호 기호 ‘<’와 ‘>’가 k개 나열된 순서열  A가 있다.
 * 이 부등호 기호 앞뒤에 서로 다른 한 자릿수 숫자를 넣어서 모든 부등호 관계를 만족시키려고 한다.
 * 첫 줄에 부등호 문자의 개수를 나타내는 정수 k가 주어진다.
 * 그 다음 줄에는 k개의 부등호 기호가 하나의 공백을 두고 한 줄에 모두 제시된다.
 * k의 범위는 2 ≤ k ≤ 9 이다.
 * 선택된 숫자는 모두 달라야 한다.
 */
public class Algorithm2529 {

    static int n;
    static char[] list = new char[20]; // 20은 대충 큰 수
    static ArrayList<String> result = new ArrayList<>();
    static boolean[] check = new boolean[10]; // 0 ~ 9

    /*static boolean checkNum(String num) {
        for (int i = 0; i < n; i++) {
            // n+1이 있어도 되는 이유, : 부등호 이전과 이후만 체크하기 때문
            if (list[i] == '<') {
                if (num.charAt(i) > num.charAt(i + 1)) return false;
            } else if (list[i] == '>') {
                if (num.charAt(i) < num.charAt(i + 1)) return false;
            }
        }
        return true;
    }*/

    static boolean checkNum(char x, char y, char op) {
        if (op == '<') {
            if (x > y) return false;
        } else if (op == '>') {
            if (x < y) return false;
        }
        return true;
    }

    static void cal(int index, String num) {
        // n+1 : 마지막 부등호 다음에 오는 숫자
        // 결과 중 하나를 찾은 경우
        if (index == n + 1) {
//            if (checkNum(num)) {
//                result.add(num);
//            }
            result.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (check[i]) continue;
            // 마지막에 검사하느냐 '과정'에 검사하느냐
            if (index == 0 || checkNum(num.charAt(index - 1), (i+"").toCharArray()[0], list[index - 1])) {
                check[i] = true;
                cal(index + 1, num + "" + i);
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            list[i] = sc.next().toCharArray()[0];
        }
        cal(0, "");
        Collections.sort(result);
        int count = result.size();
        System.out.println(result.get(count - 1));
        System.out.println(result.get(0));
    }
}
