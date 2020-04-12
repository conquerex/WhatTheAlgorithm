package part2graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 단지번호붙이기 - showBfs
 * 문제 : https://www.acmicpc.net/problem/2667
 * 풀이 : https://www.acmicpc.net/source/share/fc2c76b7935048969af1aff47e3cb75e
 * 첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고,
 * 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.
 */
public class Algorithm2667 {

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

    static void showBfs(int[][] map, int x, int y, int[][] group, int count, int n) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        group[x][y] = count;
        // 하나의 단지를 만든다.
        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            x = pair.x;
            y = pair.y;
            // 집의 상하좌우에 위치한 집의 상대적 위치를 파악해야 함으로 : i < 4
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    // 맵에 집이 있고, 단지는 지정되어 있지 않은 경우
                    if (map[nx][ny] == 1 && group[nx][ny] == 0) {
                        queue.add(new Pair(nx, ny));
                        group[nx][ny] = count;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 개행문자(엔터)가 str에 저장되는 것을 방지
        sc.nextLine();

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String houses = sc.nextLine();
            for (int j = 0; j < n; j++) {
                // 아스키코드 때문에 0을 빼줌
                map[i][j] = houses.charAt(j) - '0';
            }
        }

        // 단지 갯수
        int count = 0;
        int[][] group = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 맵에 집이 있고, 단지는 지정되어 있지 않은 경우
                if (map[i][j] == 1 && group[i][j] == 0) {
                    // 단지가 하나 만들어지고 나서 다음 단지를 만들때
                    // 다음 showBfs가 수행되므로 ++count
                    showBfs(map, i, j, group, ++count, n);
                }
            }
        }

        int[] result = new int[count];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 단지 번호가 없는 공터
                if (group[i][j] != 0) {
                    result[group[i][j] - 1] += 1;
                }
            }
        }

        Arrays.sort(result);
        System.out.println(count);
        for (int i = 0; i < count; i++) {
            System.out.println(result[i]);
        }
    }
}
