package study2020.week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class week1_02178 {

    class Node {
        int y;
        int x;
        int dist;

        Node(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }

    int[][] map;
    boolean[][] check;
    Node end;
    int n, m;

    int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        new week1_02178().solve();
    }

    void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            Queue<Node> queue = new ArrayDeque<>();
            String[] info = br.readLine().split(" ");
            n = Integer.parseInt(info[0]);
            m = Integer.parseInt(info[1]);

            map = new int[n][m];
            check = new boolean[n][m];
            end = new Node(n - 1, m - 1, -1);

            queue.offer(new Node(0, 0, 1));
            check[0][0] = true;

            for (int i = 0; i < n; i++) {
                String[] splits = br.readLine().split("");
                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(splits[j]);
                }
            }

            int newY;
            int newX;

            while (!queue.isEmpty()) {
                Node item = queue.poll();

                if (item.y == end.y && item.x == end.x) {
                    System.out.println(item.dist);
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    newY = item.y + direction[i][0];
                    newX = item.x + direction[i][1];

                    if (newY >= n || newY < 0 || newX >= m || newX < 0) {
                        continue;
                    }

                    if (map[newY][newX] == 0) {
                        continue;
                    }

                    if (check[newY][newX]) {
                        continue;
                    }

                    check[newY][newX] = true;
                    queue.offer(new Node(newY, newX, item.dist + 1));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
