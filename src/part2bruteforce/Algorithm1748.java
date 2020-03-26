package part2bruteforce;

import java.util.Scanner;

/**
 * 수 이어 쓰기 1
 * 문제 : https://www.acmicpc.net/problem/1748
 * 풀이 : https://www.acmicpc.net/source/share/5d4c53a6cde44bb3ac01c65d13651cb5
 *
 * 1부터 N까지의 수를 이어서 쓰면 다음과 같이 새로운 하나의 수를 얻을 수 있다.
 * 이렇게 만들어진 새로운 수는 몇 자리 수일까? 이 수의 자릿수를 구하는 프로그램을 작성하시오.
 * 첫째 줄에 N(1≤N≤100,000,000)이 주어진다.
 * 120 --> 252
 */
public class Algorithm1748 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long result = 0;

        // len은 자리수
        // i는 len 자리수의 첫번재 숫자
        for (int i = 1, len = 1 ; i <= n ; i *= 10, len++) {
            int end = i * 10 - 1;
            if (end > n) {
                end = n;
            }
            result += (long)(end - i + 1) * len;
        }

        System.out.println(result);
    }
}
