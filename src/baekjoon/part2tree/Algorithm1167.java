package baekjoon.part2tree;

import java.util.*;

/**
 * 트리의 지름 (탐색 2번 이용한 소스)
 * 문제 : https://www.acmicpc.net/problem/1167
 * 풀이 : https://www.acmicpc.net/source/share/40b58ad7a1514aa1aa3cef299e44000a
 */
public class Algorithm1167 {

    static class Edge {
        public int to;
        public int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static int[] bfs(int n, List<Edge>[] a, int start) {
        boolean[] check = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Queue<Integer> q = new LinkedList<Integer>();
        check[start] = true;
        q.add(start);
        while (!q.isEmpty()) {
            int x = q.remove();
            for (Edge e : a[x]) {
                int y = e.to;
                int cost = e.cost;
                if (check[y] == false) {
                    dist[y] = dist[x] + cost;
                    q.add(y);
                    check[y] = true;
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Edge>[] a = (List<Edge>[]) new List[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<Edge>();
        }
        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            while (true) {
                int y = sc.nextInt();
                if (y == -1) break;
                int z = sc.nextInt();
                a[x].add(new Edge(y, z));
            }
        }
        int[] dist = bfs(n, a, 1);
        int start = 1;
        for (int i = 2; i <= n; i++) {
            if (dist[i] > dist[start]) {
                start = i;
            }
        }
        dist = bfs(n, a, start);
        int ans = dist[1];
        for (int i = 2; i <= n; i++) {
            if (ans < dist[i]) {
                ans = dist[i];
            }
        }
        System.out.println(ans);
    }
}
