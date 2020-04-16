package baekjoon.part2recursion;

import java.util.Scanner;

/**
 * 퇴사
 * 문제 : https://www.acmicpc.net/problem/14501
 * 풀이 : https://www.acmicpc.net/source/share/fdc0c3b04589497995d3035b94b764c2
 * 첫째 줄에 N (1 ≤ N ≤ 15)이 주어진다.
 * T : 상담을 완료하는데 걸리는 기간
 * P : 상담을 했을 때 받을 수 있는 금액
 * 1 ≤ Ti ≤ 5, 1 ≤ Pi ≤ 1,000
 * 최대 이익 구하기
 */
public class Algorithm14501 {
    static int[] t;
    static int[] p;
    static int result;
    static int n;

    static void cal(int day, int sum) {
        // 정답을 찾은 경우
        if (day == n + 1) {
            if (result < sum) result = sum;
            return;
        }

        // 불가능한 경우
        if (day > n + 1) {
            return;
        }

        // 일하기로 했다면 day만큼 이동
        cal(day + t[day], sum + p[day]);
        // 하지 않는다면 그다음날로
        cal(day + 1, sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = new int[n + 1];
        p = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        // 1일, 0원부터 시작
        cal(1, 0);

        System.out.println(result);
    }
}
