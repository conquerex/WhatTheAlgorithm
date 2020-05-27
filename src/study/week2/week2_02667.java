package study.week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Jongkook on 26/05/2020.
 * 문제 출처 :
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class week2_02667 {

    static class Node {
        int y;
        int x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // 정사각형 지도의 한 변 길이
            int n = Integer.parseInt(br.readLine());
            String[] input = new String[n];
            int[][] map = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = input[i].charAt(j);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void doBFS(int sy, int sx) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(sy, sx));
        while (!queue.isEmpty()) {
            Node item = queue.poll();
        }
    }
}
