package study.week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 토마토
 */
public class week1_07576 {

    class Node {
        int y;
        int x;
        int day;

        Node(int y, int x, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    int[][] map;
//    boolean[][] check;
    Node item;
    int n, m;
    int days = 0;

    int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        System.out.println(new week1_07576().solve());;
    }

    int solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            Queue<Node> queue = new LinkedList<>();
            String[] info = br.readLine().split(" ");
            n = Integer.parseInt(info[1]);
            m = Integer.parseInt(info[0]);

            map = new int[n][m];
//            check = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                String[] splits = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(splits[j]);
                    if (map[i][j] == 1) {
                        queue.add(new Node(i, j, 0));
                    }
                }
            }

            int ny;
            int nx;

            while (!queue.isEmpty()) {
                item = queue.poll();


                // 더이상 익을 토마토가 없을 때

                for (int i = 0; i < 4; i++) {
                    ny = item.y + direction[i][0];
                    nx = item.x + direction[i][1];

                    if (ny >= n || ny < 0 || nx >= m || nx < 0) {
                        continue;
                    }

                    if (map[ny][nx] == -1 || map[ny][nx] == 1) {
                        continue;
                    }

//                    if (check[ny][nx]) {
//                        continue;
//                    }

//                    check[ny][nx] = true; // 필요없지 않나???
                    map[ny][nx] = 1;
                    queue.offer(new Node(ny, nx, item.day + 1));
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 0) {
                        return -1;
                    }
                }
            }

            return item.day;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }
}
