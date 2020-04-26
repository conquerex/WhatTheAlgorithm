package baekjoon.part2_07_graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 미로 탐색
 * 문제 : https://www.acmicpc.net/problem/2178
 * 풀이 : https://www.acmicpc.net/source/share/baaf6b955c45466caccda1f2e01cf08b
 * DFS 탐색으로는 문제를 풀 수 없다.
 * BFS는 단계별로 진행된다는 사실을 이용
 */
public class Algorithm2178 {

    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                // 아스키코드 때문에 0을 빼줌
                map[i][j] = s.charAt(j) - '0';
            }
        }

        int[][] distance = new int[n][m];
        boolean[][] check = new boolean[n][m];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));
        check[0][0] = true;
        distance[0][0] = 1;

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            int x = pair.x;
            int y = pair.y;

            // 4개의 방향을 가리킬 수 있으므로
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int my = y + dy[i];
                if (0 <= nx && nx < n && 0 <= my && my < m) {
                    if (map[nx][my] == 1 && distance[nx][my] == 0) {
                        queue.add(new Pair(nx, my));
                        distance[nx][my] = distance[x][y] + 1;
                        check[nx][my] = true;
                    }
                }
            }
        }

        System.out.println(distance[n - 1][m - 1]);
    }
}
