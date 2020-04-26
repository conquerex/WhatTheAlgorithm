package baekjoon.part2_07_graph;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 연결 요소의 개수
 * 문제 : https://www.acmicpc.net/problem/11724
 * 풀이 : https://www.acmicpc.net/source/share/dbcc0c3d8022443d9a6319e16a1e2c99
 * 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
 * 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2)
 * 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.
 */
public class Algorithm11724 {
    /**
     * 깊이 우선, Stack
     * @param arrayLists : 간선
     * @param check : 확인한 정점인지
     * @param x : 확인할 정점
     */
    static void showDfs(ArrayList<Integer>[] arrayLists, boolean[] check, int x) {
        if (check[x]) return;
        check[x] = true;

        for (int y : arrayLists[x]) {
            if (check[y] == false) {
                showDfs(arrayLists, check, y);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // 인접 리스트
        ArrayList<Integer>[] arrayLists = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            arrayLists[v1].add(v2);
            arrayLists[v2].add(v1);
        }

        boolean[] check = new boolean[n+1];
        int result = 0;

        for (int i = 1; i < n + 1; i++) {
            if (check[i] == false) {
                // i = 1일때부터 dfs의 재귀함수로 인해 check될 것이고
                // i = 2부터는 check가 된 곳은 빠질테니 result에 하나씩 값이 올라감
                showDfs(arrayLists, check, i);
                result += 1;
            }
        }

        System.out.println(result);
    }
}
