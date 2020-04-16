package baekjoon.part2bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 이모티콘
 * 문제 : https://www.acmicpc.net/problem/14226
 * 풀이 : https://www.acmicpc.net/source/share/489a4b9a719c4958bbe6a02a7d860f74
 * <p>
 * 1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
 * 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
 * 3. 화면에 있는 이모티콘 중 하나를 삭제한다.
 * S개의 이모티콘을 화면에 만드는데 걸리는 시간의 최솟값
 */
public class Algorithm14226 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 2 종류의 정점 : [a][b]
        // a : 화면에 보이는 이모티콘 갯수
        // b : 클립보드
        int[][] d = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(d[i], -1);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(0);
        d[1][0] = 0;

        while (!queue.isEmpty()) {
            int s = queue.remove();
            int c = queue.remove();

            // 1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
            if (d[s][s] == -1) {
                d[s][s] = d[s][c] + 1;
                queue.add(s);
                queue.add(s);
            }

            // 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
            if (s + c <= n && d[s + c][c] == -1) {
                d[s + c][c] = d[s][c] + 1;
                queue.add(s + c);
                queue.add(c);
            }

            // 3. 화면에 있는 이모티콘 중 하나를 삭제한다.
            if (s - 1 >= 0 && d[s - 1][c] == -1) {
                d[s - 1][c] = d[s][c] + 1;
                queue.add(s - 1);
                queue.add(c);
            }
        }

        int result = -1;

        for (int i = 0; i <= n; i++) {
            if (d[n][i] != -1) {
                if (result == -1 || result > d[n][i]) {
                    result = d[n][i];
                }
            }
        }

        System.out.println(result);
    }
}
