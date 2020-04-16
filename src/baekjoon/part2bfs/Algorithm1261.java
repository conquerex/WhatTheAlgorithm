package baekjoon.part2bfs;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * 알고스팟
 * 문제 : https://www.acmicpc.net/problem/1261
 * 풀이 : https://www.acmicpc.net/source/share/b6650d4652c041f6a791d4ab1ef24eee
 * 첫째 줄에 미로의 크기를 나타내는 가로 크기 M, 세로 크기 N (1 ≤ N, M ≤ 100)이 주어진다.
 * 다음 N개의 줄에는 미로의 상태를 나타내는 숫자 0과 1이 주어진다. 0은 빈 방을 의미하고, 1은 벽을 의미한다.
 * (1, 1)과 (N, M)은 항상 뚫려있다.
 * (N, M)으로 이동하기 위해 벽을 최소 몇 개 부수어야 하는지 출력
 */
public class Algorithm1261 {

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
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        int[][] broken = new int[n][m];
        ArrayDeque<Pair> deque = new ArrayDeque<>();
        deque.add(new Pair(0, 0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                broken[i][j] = -1;
            }
        }
        broken[0][0] = 0;

        while (!deque.isEmpty()) {
            Pair pair = deque.poll();
            int x = pair.x;
            int y = pair.y;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (broken[nx][ny] == -1) {
                        if (map[nx][ny] == 0) {
                            // 방인 경우
                            broken[nx][ny] = broken[x][y];
                            deque.addFirst(new Pair(nx, ny));
                        } else {
                            // 벽인 경
                            broken[nx][ny] = broken[x][y] + 1;
                            deque.addLast(new Pair(nx, ny));
                        }
                    }
                }

            }
        }

        System.out.println(broken[n - 1][m - 1]);
    }
}
