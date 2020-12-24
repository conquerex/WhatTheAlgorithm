package study.week31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Jongkook on 2020/12/24.
 * 문제 출처 :https://www.acmicpc.net/problem/2583
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class week31_2583 {

    public static boolean[][] visited;
    public static Queue<Integer> queue;
    public static int m;
    public static int n;
    public static int k;

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); // 세로 길이, y
            n = Integer.parseInt(st.nextToken()); // 가로 길이, x
            k = Integer.parseInt(st.nextToken()); // 사각형 개수

            visited = new boolean[m][n];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                checkSqure(
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken())
                );
            }

            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[j][i]) {
                        result.add(doBfs(i, j));
                    }
                }
            }

            // 결과 출력
            System.out.println(result.size());
            result.stream().sorted().forEach(i -> {
                System.out.print(i + " ");
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int doBfs(int x, int y) {
        int count = 0;
        queue = new LinkedList<>();
        visited[y][x] = true;
        count++;
        queue.offer(x);
        queue.offer(y);

        while (!queue.isEmpty()) {
            int px = queue.poll();
            int py = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newX = px + dx[i];
                int newY = py + dy[i];
                if (newX < 0 || newX >= n || newY < 0 || newY >= m) continue;
                
                if (!visited[newY][newX]) {
                    visited[newY][newX] = true;
                    count++;
                    queue.offer(newX);
                    queue.offer(newY);
                }
            }
        }
        return count;
    }

    // lb : left bottom
    // rt : right top
    public static void checkSqure(int lbX, int lbY, int rtX, int rtY) {
        for (int i = lbX; i < rtX; i++) {
            for (int j = lbY; j < rtY; j++) {
                visited[j][i] = true;
            }
        }
    }
}
