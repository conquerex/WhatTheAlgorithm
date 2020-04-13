package part2challenge;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 다리 만들기
 * 문제 : https://www.acmicpc.net/problem/2146
 * 풀이 : https://www.acmicpc.net/source/share/dc3ddf21fff74a649925847fdba0afe4
 */
public class Algorithm2146_2 {

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
        int n = sc.nextInt();

        int[][] land = new int[n][n];       // 육지와 바다 구분
        int[][] distance = new int[n][n];   // 거리
        int[][] group = new int[n][n];      // 그룹 (단지 개념)

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                land[i][j] = sc.nextInt();
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                /**
                 * 육지이며 그룹이 없는 부분
                 * BFS
                 * while (!queue.isEmpty())이 끝나면 다음 그룹을 찾는다. : ++count
                 */
                if (land[i][j] == 1 && group[i][j] == 0) {
                    Queue<Pair> queue = new LinkedList<>();
                    group[i][j] = ++count;
                    queue.add(new Pair(i, j));

                    while (!queue.isEmpty()) {
                        Pair pair = queue.remove();
                        int x = pair.x;
                        int y = pair.y;
                        // 4개의 방향
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            // 이동할 수 있는 범위 안인지 체크
                            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                                // 목적지가 육지인지 그리고 그룹이 없는지 확인
                                if (land[nx][ny] == 1 && group[nx][ny] == 0) {
                                    queue.add(new Pair(nx, ny));
                                    // 목적지에 기존의 그룹과 동일한 그룹번호 부여
                                    group[nx][ny] = count;
                                }
                            }
                        }
                    }
                }
            }
        }
        // 그룹이 모두 만들어진 상황
        //////////////////////

        /**
         * 아래부터 변경
         */

        Queue<Pair> queue = new LinkedList<>();
        // 육지에는 distance값을 0으로 세팅, 그외는 -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = -1;
                if (land[i][j] == 1) {
                    queue.add(new Pair(i, j));
                    distance[i][j] = 0;
                }
            }
        }

        // 그룹별 육지에서 바다까지 거리 구하기
        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            int x = pair.x;
            int y = pair.y;
            // 4개의 방향
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    // 바다에 거리값주기
                    if (distance[nx][ny] == -1) {
                        distance[nx][ny] = distance[x][y] + 1;
                        queue.add(new Pair(nx, ny));
                        group[nx][ny] = group[x][y];
                    }
                }
            }
        }

        int result = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (0 <= x && x < n && 0 <= y && y < n) {
                        // 단지와 단지가 인접한 구간 찾기
                        if (group[x][y] != group[i][j]) {
                            // 인접 구간의 양쪽 distance값의 합이 다리 길이이다.
                            // 결과가 -1이거나 양쪽 distance값의 합이 현재의 결과 값보다 작으면 결과값 갱신
                            if (result == -1 || distance[i][j] + distance[x][y] < result) {
                                result = distance[i][j] + distance[x][y];
                            }
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }
}
