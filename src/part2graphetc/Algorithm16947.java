package part2graphetc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 서울 지하철 2호선
 * 문제 : https://www.acmicpc.net/problem/16947
 * 풀이 : https://www.acmicpc.net/source/share/b830798e0d4943f6bb60e89dc150b60b
 * 각 역과 순환선 사이의 거리를 구해보자.
 * [sample - -1한 값으로]
 * 6
 * 0 1 -- [0]
 * 2 3
 * 5 3
 * 1 2
 * 0 2
 * 2 4 -- [5]
 *
 *  0 --- 1
 *  |     |
 *  +---- 2 -- 3 -- 5
 *        |
 *        4
 */
public class Algorithm16947 {

    static ArrayList<Integer>[] way;
    static int[] check;
    static int[] distance;

    /**
     * DFS를 사용
     * return 값이...
     * -2 : 사이클 찾음, 사이클에 포함 x
     * -1 : 사이클 찾지 못함
     * 0 ~ n-1 중 하나 : 사이클 찾음, 시작점을 반환
     */
    static int cycleStatus(int x, int pre) {

        if (check[x] == 1) {
            return x;
        }

        // 지나온 것 표시
        // 사이클에 포함된 인덱스
        check[x] = 1;

        /**
         * cycleStatus(0, -1) == -2
         * check[0] == 1
         * cycleStatus(1, 0) == -2
         *   check[1] == 1
         *   0 == 0 : continue
         *   cycleStatus(2, 1) == 0
         *     check[2] == 1
         *     cycleStatus(3, 2) == -1
         *       check[3] == 1
         *       2 == 2 : continue
         *       cycleStatus(5, 3) == -1
         *         check[5] == 1
         *         3 == 3 : continue
         *         retrun -1
         *     1 == 1 : continue
         *     cycleStatus(0, 2) == 0
         *     check[2] == 2
         *   check[1] == 2
         * check[0] == 2
         */
        for (int y : way[x]) {
            // 왔던 길로 돌아가는 것을 확인
            if (y == pre) continue;
            int res = cycleStatus(y, x);
            if (res == -2) return -2;
            if (res >= 0) {
                // 사이클에 포함된 인덱스
                check[x] = 2;
                if (x == res) return -2;
                else return res;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        way = new ArrayList[n];
        distance = new int[n];
        check = new int[n];

        for (int i = 0; i < n; i++) {
            way[i] = new ArrayList<>();
        }

        /**
         * 인접 리스트
         * way[0] : 1, 2
         * way[1] : 0, 2
         * way[2] : 3, 1, 0, 4
         * way[3] : 2, 5
         * way[4] : 2
         * way[5] : 3
         */
        for (int i = 0; i < n; i++) {
            // 역 번호가 1번부터 시작이므로 1을 빼준다.
            int v1 = sc.nextInt() - 1;
            int v2 = sc.nextInt() - 1;
            way[v1].add(v2);
            way[v2].add(v1);
        }

        cycleStatus(0, -1);

        // BFS를 사용
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (check[i] == 2) {
                // 사이클에 포함되어 있어서
                distance[i] = 0;
                queue.add(i);
            } else {
                // 사이클에 비포함, 뒤에서 거리 계산함
                distance[i] = -1;
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.remove();
            // way[2]의 경우, y == 3
            // way[3]의 경우, y == 5
            for (int y : way[x]) {
                if (distance[y] == -1) {
                    queue.add(y);
                    distance[y] = distance[x] + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(distance[i] + " ");
        }
        System.out.println();
    }
}
