package part2permutation;

import java.util.Scanner;

/**
 * 외판원 순회 2
 * 문제 : https://www.acmicpc.net/problem/10971
 * 풀이 : https://www.acmicpc.net/source/share/3fd7e661e2be4186a75a7b27450b35a2
 * <p>
 * 외판원 순회 문제는 영어로 Traveling Salesman problem (TSP) 라고 불리는 문제로
 * computer science 분야에서 가장 중요하게 취급되는 문제 중 하나이다.
 * N과 비용 행렬이 주어졌을 때, 가장 적은 비용을 들이는 외판원의 순회 여행 경로를 구하는 프로그램을 작성하시오.
 */
public class Algorithm10971 {

    // 10972와 동일
    static boolean nextPermutation(int[] p) {
        int i = p.length - 1; // 마지막 위치 찾기 위함

        while (i > 0 && p[i] <= p[i - 1]) {
            i -= 1;
        }

        if (i <= 0) {
            // 현시점이 마지막 숫자
            return false;
        }

        int j = p.length - 1; // 마지막 위치 찾기 위함

        while (p[j] <= p[i - 1]) {
            j -= 1;
        }

        int temp = p[j];
        p[j] = p[i - 1];
        p[i - 1] = temp; // 7 2 4 6 5 3 1

        j = p.length - 1; // 마지막 위치 찾기 위함, j == 6

        while (i < j) {
            temp = p[i];
            p[i] = p[j];
            p[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] p = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                p[i][j] = sc.nextInt();
            }
        }

        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = i;
        }

        // 최소값을 구하는 것이므로 디폴트는 맥스값으로.
        int result = Integer.MAX_VALUE;

        do {
            if (d[0] != 0) break; // 시작점 고정
            boolean ok = true;
            int sum = 0;

            // nextPermutation에서 순서를 바꿔주기에 이중 for문 같은게 필요없다.
            for (int i = 0; i < n - 1; i++) {
                if (p[d[i]][d[i + 1]] == 0) {
                    ok = false;
                } else {
                    sum += p[d[i]][d[i + 1]];
                }
            }

            // 끝자리에서 0자리까지 비용을 더한다.
            if (ok && p[d[n - 1]][d[0]] != 0) {
                sum += p[d[n - 1]][d[0]];
                if (result > sum) result = sum;
            }
        } while (nextPermutation(d));

        System.out.println(result);
    }
}
