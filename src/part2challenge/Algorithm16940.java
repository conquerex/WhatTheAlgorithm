package part2challenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * BFS 스페셜 저지
 * 문제 : https://www.acmicpc.net/problem/16940
 * 풀이 : https://www.acmicpc.net/source/share/6c58c942cff74fc39d27f890916cce95
 * 첫째 줄에 정점의 수 N(2 ≤ N ≤ 100,000)이 주어진다.
 * 둘째 줄부터 N-1개의 줄에는 트리의 간선 정보가 주어진다.
 * 마지막 줄에는 BFS 방문 순서가 주어진다.
 */
public class Algorithm16940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer>[] list = new ArrayList[n];
        int[] parent = new int[n];
        int[] order = new int[n]; // BFS 방문 순서
        boolean[] check = new boolean[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        // 인접 리스트
        for (int i = 0; i < n - 1; i++) {
            int v1 = sc.nextInt() - 1;
            int v2 = sc.nextInt() - 1;
            list[v1].add(v2);
            list[v2].add(v1);
        }

        // BFS 방문 순서
        for (int i = 0; i < n; i++) {
            order[i] = sc.nextInt() - 1;
        }

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        check[0] = true;
        int m = 1;

        for (int i = 0; i < n; i++) {
            // queue가 비어있는 경우
            if (queue.isEmpty()) {
                System.out.println(0);
                System.exit(0);
            }

            int x = queue.remove();
            // queue에서 나온 숫자가 order의 숫자와 다를 경우
            if (x != order[i]) {
                System.out.println(0);
                System.exit(0);
            }

            int count = 0;
            for (int y : list[x]) {
                if (check[y] == false) {
                    // 한 정점이 어느 정점의 부모인지 표시
                    parent[y] = x;
                    // 같은 부모를 가지는 정점이 몇개인지
                    count++;
                }
            }
            // 자식들 queue에 담기
            for (int j = 0; j < count; j++) {
                // m + j : 자식 인덱스
                if (m + j >= n || parent[m + j] != x) {
                    System.out.println(0);
                    System.exit(0);
                }
                // 자식 queue에 담기
                queue.add(order[m + j]);
                check[m + j] = true;
            }
            // 확인한 자식수만큼 인덱스 이동
            m += count;
        }

        System.out.println(1);
    }
}
