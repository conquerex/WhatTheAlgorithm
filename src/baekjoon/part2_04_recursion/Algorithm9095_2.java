package baekjoon.part2_04_recursion;

import java.util.Scanner;

/**
 * 1, 2, 3 더하기
 * 문제 : https://www.acmicpc.net/problem/9095
 * 풀이 : https://www.acmicpc.net/source/share/0dfb2b005a6249c297748a3def93e4d2
 */
public class Algorithm9095_2 {

    static int cal(int sum, int goal) {
        // 불가능한 상태
        if (sum > goal) {
            return 0;
        }

        if (sum == goal) {
            // 방법의 수를 1개씩 늘림
            return 1;
        }

        // 방법의 수 세기
        int count = 0;
        for (int i = 1 ; i <= 3 ; i++) {
            count += cal(sum+i, goal);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // input 갯수
        int n = sc.nextInt();

        while (n-- > 0) {
            int m = sc.nextInt();
            System.out.println(cal(0, m));
        }
    }
}
