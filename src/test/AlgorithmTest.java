package test;

import java.util.Scanner;

/**
 * 테스트(과제)용
 */
public class AlgorithmTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        solve(a);
    }

    public static void solve(int input) {
        for (int i = 1; i <= input; i++) { // 입력은 1부터 input까지 되어야 한다.
            if (i % 15 == 0) { // 15는 3과 5의 최소공배수이기 때문에 먼저 체크를 한다.
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}