package baekjoon.part2_10_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 숨바꼭질
 * 문제 : https://www.acmicpc.net/problem/1697
 * 풀이 : https://www.acmicpc.net/source/share/3e1de147337841668fe7af0dd257ae8e
 * 첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.
 */
public class Algorithm1697 {

    static final int MAX = 1000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 찾는 사람 위치
        int n = sc.nextInt();
        // 숨어있는 사람 위치
        int m = sc.nextInt();
        boolean[] check = new boolean[MAX];
        int[] distance = new int[MAX];

        check[n] = true;
        distance[n] = 0; // 결과값 초기 세팅
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n); // 초기 위치 세팅

        while (!queue.isEmpty()) {
            int now = queue.remove();

            // x - 1 이동
            if (now - 1 >= 0) {
                if (check[now - 1] == false) {
                    queue.add(now - 1);
                    check[now - 1] = true;
                    distance[now - 1] = distance[now] + 1;
                }
            }

            // x + 1 이동
            if (now + 1 < MAX) {
                if (check[now + 1] == false) {
                    queue.add(now + 1);
                    check[now + 1] = true;
                    distance[now + 1] = distance[now] + 1;
                }
            }

            // x * 2 이동
            if (now * 2 < MAX) {
                if (check[now * 2] == false) {
                    queue.add(now * 2);
                    check[now * 2] = true;
                    distance[now * 2] = distance[now] + 1;

                }
            }
        }

        System.out.println(distance[m]);
    }
}
