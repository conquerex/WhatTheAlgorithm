package baekjoon.part1_01_datastructure;

import java.util.Scanner;
import java.util.Stack;

/**
 * 문제 : https://www.acmicpc.net/problem/1874
 * 소스 : http://codeplus.codes/4799b36eb5dd488ea4c291751e381da8
 *
 * 테스트 입력값
 * 8
 * 4
 * 3
 * 6
 * 8
 * 7
 * 5
 * 2
 * 1
 *
 **/
public class Algorithm1874 {

    public static void solve(int[] a) {
//        int n = a.length;
        Stack<Integer> stack = new Stack<>();
        // stack에 들어가는 숫자가 1부터 시작한다. 그래서 while문 안에 1을 더하고 시작한다.
        int m = 0;
        StringBuilder builder = new StringBuilder();
        for (int x : a) {
            if (x > m) {
                while (x > m) {
                    m += 1;
                    stack.push(m);
                    builder.append("+\n");
                }
                stack.pop(); // 테스트 입력값에서 4가 입력 되었을 때
                builder.append("-\n");
//                builder.append(x + "-\n"); // pop되는 숫자를 보고 싶다면 위 append를 주석처리하고 본 라인의 주석을 풀어서 확인하면 된다.
            } else {
                if (stack.peek() != x) {
                    // 가장 마지막에 담은 것만 pop할 수 있기 때문
                    System.out.println("NO");
                    return;
                }
                stack.pop(); // 테스트 입력값에서 3이 입력 되었을 때
                builder.append("-\n");
//                builder.append(x + "-\n"); // pop되는 숫자를 보고 싶다면 위 append를 주석처리하고 본 라인의 주석을 풀어서 확인하면 된다.
            }
        }
        System.out.println(builder);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] list = new int[n];

        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }
        solve(list);
    }
}
