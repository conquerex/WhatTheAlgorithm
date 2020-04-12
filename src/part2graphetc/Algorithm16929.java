package part2graphetc;

import java.util.Scanner;

/**
 * Two Dots
 * 문제 : https://www.acmicpc.net/problem/16929
 * 풀이 : https://www.acmicpc.net/source/share/25890be9a91a4ed5ad85c9444a1ae84a
 */
public class Algorithm16929 {

    static char[][] map;
    static boolean[][] check;
    static int[][] distance;
    static int n, m;
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

    static boolean cycleDots(int x, int y, int px, int py, char color) {
        if (check[x][y]) return true;

        check[x][y] = true;
        // 방향이 총 4개이므로
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                // 이전 위치로 이동하지 못하도록 하기 위함
                if (!(nx == px && ny == py)) {
                    // 같은 색끼리 사이클이 되어야 한다.
                    if (map[nx][ny] == color) {
                        if (cycleDots(nx, ny, x, y, color)) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new char[n][m];
        check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = sc.next().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (check[i][j]) continue;
                distance = new int[n][m];
                boolean isTrue = cycleDots(i, j, -1, -1, map[i][j]);
                if (isTrue) {
                    System.out.println("Yes");
                    System.exit(0);
                }
            }
        }

        System.out.println("No");
    }
}
