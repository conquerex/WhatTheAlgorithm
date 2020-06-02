package study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Jongkook on 02/06/2020.
 * 문제 출처 : https://www.acmicpc.net/problem/2206
 * <p>
 * Time Complexity :
 * Used Algorithm : BFS
 * Used Data structure :
 */

public class week2_2206 {

    static class Node {
        int y;
        int x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[][] map;
    static boolean[][] check;
    static Node end;
    static int n, m;

    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String[] info = br.readLine().split(" ");
            n = Integer.parseInt(info[0]);
            m = Integer.parseInt(info[1]);

            map = new int[n][m];
            check = new boolean[n][m];
            end = new Node(n - 1, m - 1);

            for (int i = 0; i < n; i++) {
                String[] splits = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(splits[j]);
                }
            }

            doBFS(0, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void doBFS(int sy, int sx) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(sy, sx));
        check[0][0] = true;

        int ny, nx;

        while (!queue.isEmpty()) {
            Node item = queue.poll();

            if (item.y == end.y && item.x == end.x) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                ny = item.y + direction[i][0];
                nx = item.x + direction[i][1];

                if (ny >= n || ny < 0 || nx >= m || nx < 0) continue;
                if (map[ny][nx] == 1) continue;
                if (check[ny][nx]) continue;

                check[ny][nx] = true;
                queue.offer(new Node(ny, nx));
            }
        }
    }

}
