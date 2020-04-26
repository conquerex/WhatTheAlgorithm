package baekjoon.part2_02_nm;

import java.util.Scanner;

/**
 * N과 M (2)
 * 문제 : https://www.acmicpc.net/problem/15650
 * 풀이 : https://www.acmicpc.net/source/share/3e0bd9810463437484c31ce83eca802c
 * <p>
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열 (1 ≤ M ≤ N ≤ 8)
 * 고른 수열은 오름차순이어야 한다.
 */
public class Algorithm15650 {
    static int[] result = new int[10];

    // index : 재귀함수를 쓰기 위해 인덱스를 받는다. 갯수별 배열을 만들기 위함
    // n : 1 ~ n
    // m : 위 숫자의 갯
    static void move(int index, int selected, int n, int m) {
        // 아래 if문 : 15649 문제와 비교 :: index --> selected
        if (selected == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(result[i]);
                if (i != m - 1) System.out.print(" ");
            }
            System.out.println();
            return;
        }

        if (index > n) return;
        /**
         * index를 결과에 추가
         * n = 4, m = 2 일때
         * index = 1, selected = 0이 되면
         * "1 2"까지 여기에 찍힌다.
         */
        result[selected] = index;
        // 오름차순이라서 index보다 1더 큰 숫자부터 찾으면 된다.
        move(index+1, selected+1, n, m);

        /**
         * index를 결과에 추가 안함, 위와 순서 바뀌면 안됨
         * "1 3", "1 4"는 여기에 찍힌다.
         */
        result[selected] = 0;
        move(index+1, selected, n, m);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        move(1,0, n, m);
    }
}
