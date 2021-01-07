package study2020.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by Jongkook on 04/06/2020.
 *
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12973
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class week3_p12973 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String text = br.readLine();
            System.out.println(solution(text));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
            if (stack.size() >= 2) {
                if (stack.get(stack.size() - 2) == stack.get(stack.size() - 1) ) {
                    stack.pop();
                    stack.pop();
                }
            }
        }

        return stack.size() > 0 ? 0 : 1;
    }
}
