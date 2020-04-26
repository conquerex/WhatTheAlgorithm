package baekjoon.part2_05_bitmask;

import java.util.Scanner;

/**
 * 부분수열의 합
 * 문제 : https://www.acmicpc.net/problem/1182
 * 풀이 : https://www.acmicpc.net/source/share/1b9e73111817405697121eee82e1bc1b
 * N개의 정수로 이루어진 수열이 있을 때,
 * 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.
 */
public class Algorithm1182 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }

        int result = 0;
        // 1, 10, 11 .... 까지 확인하기 : 모든 집합 확인
        // 공집합 제외
        for (int i = 1; i < (1 << n); i++) {
            int sum = 0;
            // 수열의 수를 대입하는 부분
            for (int j = 0; j < n; j++) {
                // 집합에 어떤 수로 구성되어 있는지 확인
                // 만약 i = 7이면 0111이므로 list[0~2]의 합이 나온다.
                if ((i & (1 << j)) != 0) {
                    sum += list[j];
                }
            }
            if (sum == s) {
                result += 1;
            }
        }

        System.out.println(result);
    }
}
