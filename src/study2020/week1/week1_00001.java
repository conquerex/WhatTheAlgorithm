package study2020.week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class week1_00001 {

    public static void main(String[] args) {
        new week1_00001().solve();
    }

    // 좌표값, 방문한 정보
    class Node {
        int y;
        int x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    // 테스트케이스를 입력하기 위함
    int[][] map;

    // 방문한 것 표시
    boolean[][] visit;

    // 종료점
    Node end;

    // 우좌하상 {y, x}
    int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            Queue<Node> queue = new ArrayDeque<>();
            map = new int[4][4];
            visit = new boolean[4][4];

            // 시작점 입력
            queue.offer(new Node(0, 0));
            // 시작점은 이미 방문
            visit[0][0] = true;

            /** 초기화 시작 **/
            for (int i = 0; i < 4; i++) {
                String[] splits = br.readLine().split("");
                for (int j = 0; j < 4; j++) {
                    map[i][j] = Integer.parseInt(splits[j]);
                }
            }

            end = new Node(3, 3);

            /** 초기화 끝 **/

            // 이동할 지점
            int newY;
            int newX;

            // BFS
            while (!queue.isEmpty()) {
                Node item = queue.poll();

                if (item.y == end.y && item.x == end.x) {
                    System.out.println("arrive!");
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    newY = item.y + direction[i][0];
                    newX = item.x + direction[i][1];

                    if (newY >= 4 || newY < 0 || newX >= 4 || newX < 0) {
                        continue;
                    }

                    if (map[newY][newX] == 0) {
                        continue;
                    }

                    if (visit[newY][newX]) {
                        continue;
                    }

                    System.out.println(newY + ", " + newX);

                    visit[newY][newX] = true;
                    queue.offer(new Node(newY, newX));
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
