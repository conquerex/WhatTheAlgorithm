package baekjoon.part2graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 나이트의 이동
 * 문제 : https://www.acmicpc.net/problem/7562
 * 풀이 : https://www.acmicpc.net/source/share/22e081fad6ab4a088f6c4f05851aeeb1
 * 입력의 첫째 줄에는 테스트 케이스의 개수가 주어진다.
 * 각 테스트 케이스는 세 줄로 이루어져 있다.
 * 첫째 줄에는 체스판의 한 변의 길이 l(4 ≤ l ≤ 300)이 주어진다. 체스판의 크기는 l × l이다.
 * 체스판의 각 칸은 두 수의 쌍 {0, ..., l-1} × {0, ..., l-1}로 나타낼 수 있다.
 * 둘째 줄과 셋째 줄에는 나이트가 현재 있는 칸, 나이트가 이동하려고 하는 칸이 주어진다.
 */
public class Algorithm7562 {

    static final int[] dx = {-2,-1,1,2,2,1,-1,-2};
    static final int[] dy = {-1,-2,-2,-1,1,2,2,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseCount = sc.nextInt();

        while (caseCount-- > 0) {
            int n = sc.nextInt();
            int startX = sc.nextInt();
            int startY = sc.nextInt();
            int endX = sc.nextInt();
            int endY = sc.nextInt();
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(map[i], -1);
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.add(startX);
            queue.add(startY);
            map[startX][startY] = 0;

            while (!queue.isEmpty()) {
                int x = queue.remove();
                int y = queue.remove();
                for (int i = 0; i < 8; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                        if (map[nx][ny] == -1) {
                            map[nx][ny] = map[x][y] + 1;
                            queue.add(nx);
                            queue.add(ny);
                        }
                    }
                }
            }
            System.out.println(map[endX][endY]);
        }
    }
}
