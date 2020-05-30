package study.week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Jongkook on 26/05/2020.
 * 문제 출처 : https://www.acmicpc.net/problem/2667
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

    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int n;
    static int groupCount = 0;
    static int[][] map;
    static boolean[][] check;
    // 각 단지 갯수 저장용
    static ArrayList<Integer> groupList = new ArrayList<>();

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // 정사각형 지도의 한 변 길이
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            check = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                String[] splits = br.readLine().split("");
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(splits[j]);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1 && check[i][j] == false) {
                        groupCount++;
                        doBFS(i, j);
                    }
                }
            }

            System.out.println(groupCount);
            for (int i = 0; i < groupList.size(); i++) {
                System.out.println(groupList.get(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void doBFS(int sy, int sx) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(sy, sx));

        int ny, nx;
        int groupTotal = 1;
        check[sy][sx] = true;

        while (!queue.isEmpty()) {
            Node item = queue.poll();

            for (int i = 0; i < 4 ; i++) {
                ny = item.y + direction[i][0];
                nx = item.x + direction[i][1];

                // 0보다 크거나 같고 n보다 작은 것만
                if (ny >= n || ny < 0 || nx >= n || nx < 0) {
                    continue;
                }

                // 숫자 1인 것만 찾아야 함
                if (map[ny][nx] == 0) {
                    continue;
                }

                // check가 false인 것만
                if (check[ny][nx]) {
                    continue;
                }

                groupTotal++;
                check[ny][nx] = true;
                queue.offer(new Node(ny, nx));
            }
        }

        groupList.add(groupTotal);
    }
}
