package part2dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * DFS와 BFS (간선 리스트)
 * 문제 : https://www.acmicpc.net/problem/1260
 * 풀이 : https://www.acmicpc.net/source/share/304dc84b3eb04e1b9832505dae72a0fc
 */
class Edge implements Comparable<Edge> {
    int from, to;

    Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public int compareTo(Edge edge) {
        if (this.from < edge.from) {
            return -1;
        } else if (this.from == edge.from) {
            if (this.to < edge.to) {
                return -1;
            } else if (this.to == edge.to) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}

public class Algorithm1260_2 {

    static Edge[] edges;
    static int[] count;
    static boolean[] check;

    static void showDfs(int n) {
        check[n] = true;
        System.out.println(n + " ");
        for (int i = count[n - 1]; i < count[n]; i++) {
            int next = edges[i].to;
            if (check[next] == false) {
                showDfs(next);
            }
        }
    }

    static void showBfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        check[s] = true;
        while (!queue.isEmpty()) {
            int n = queue.remove();
            System.out.println(n + " ");
            for (int i = count[n - 1]; i < count[n]; i++) {
                int next = edges[i].to;
                if (check[next] == false) {
                    check[next] = true;
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();

        edges = new Edge[2 * m];
        count = new int[n + 1];
        check = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            edges[i] = new Edge(from, to);
            edges[m + i] = new Edge(to, from);
        }

        m *= 2;

        for (int i = 0; i < m; i++) {
            count[edges[i].from] += 1;
        }

        for (int i = 1; i < n + 1; i++) {
            count[i] += count[i - 1];
        }

        showDfs(s);
        System.out.println(n);

        check = new boolean[n + 1];
        showBfs(s);
        System.out.println(n);
    }
}
