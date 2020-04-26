package baekjoon.part2_02_nm;

import java.util.Scanner;

/**
 * N과 M (1)
 * 문제 : https://www.acmicpc.net/problem/15649
 * 풀이 : https://www.acmicpc.net/source/share/ca1af2d3cdd04f3b9fc5ad9810d9770c
 * <p>
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열 (1 ≤ M ≤ N ≤ 8)
 */
public class Algorithm15649 {
    static boolean[] selected = new boolean[10];
    static int[] result = new int[10];

    // index : 재귀함수를 쓰기 위해 인덱스를 받는다. 갯수별 배열을 만들기 위함
    // n : 1 ~ n
    // m : 위 숫자의 갯
    static void move(int index, int n, int m) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(result[i]);
                if (i != m - 1) System.out.print(" ");
            }
            System.out.println();
            return;
        }

        // n은 숫자이므로 1부터 시작
        for (int i = 1; i <= n; i++) {
            if (selected[i]) continue;
            selected[i] = true;
            result[index] = i;

            // 여기가 핵심
            // 첫번째 숫자를 고정하고 두번째 숫자를 배치
            move(index+1, n, m);

            selected[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        move(0, n, m);
    }
}
