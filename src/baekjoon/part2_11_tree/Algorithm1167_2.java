package baekjoon.part2_11_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 트리의 지름 (포스트 오더 이용한 소스)
 * 문제 : https://www.acmicpc.net/problem/1167
 * 풀이 : https://www.acmicpc.net/source/share/40b58ad7a1514aa1aa3cef299e44000a
 */
public class Algorithm1167_2 {

    static class Edge {
        public int to;
        public int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static class Pair {
        public int diameter;
        public int height;

        Pair(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    static List<Edge>[] a;
    static boolean[] check;

    static Pair dfs(int x) {
        check[x] = true;
        ArrayList<Integer> heights = new ArrayList<>();
        int ans = 0;
        for (Edge e : a[x]) {
            int y = e.to;
            int cost = e.cost;
            if (check[y] == false) {
                Pair p = dfs(y);
                if (ans < p.diameter) ans = p.diameter;
                heights.add(p.height + cost);
            }
        }
        int height = 0;
        Collections.sort(heights, Collections.reverseOrder());
        if (heights.size() >= 1) {
            height = heights.get(0);
            if (ans < height) {
                ans = height;
            }
        }
        if (heights.size() >= 2) {
            int temp = heights.get(0) + heights.get(1);
            if (ans < temp) {
                ans = temp;
            }
        }
        return new Pair(ans, height);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = (List<Edge>[]) new List[n + 1];
        check = new boolean[n + 1];
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
        Pair ans = dfs(1);
        System.out.println(ans.diameter);
    }
}
