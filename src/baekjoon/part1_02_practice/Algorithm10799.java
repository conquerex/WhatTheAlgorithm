package baekjoon.part1_02_practice;

import java.util.Scanner;
import java.util.Stack;

/**
 * 쇠막대기
 * 문제 : https://www.acmicpc.net/problem/10799
 * 풀이 : https://www.acmicpc.net/source/share/dc40a92c327543c6958c28ca4cde6daa
 */
public class Algorithm10799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine().trim();
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '(') {
                stack.push(i);
            } else {
                // text.charAt(i) == ')'
                if (stack.peek() + 1 == i) {
                    stack.pop();
                    count += stack.size();
                } else {
                    stack.pop();
                    count += 1;
                }
            }
        }

        System.out.println(count);
    }
}
