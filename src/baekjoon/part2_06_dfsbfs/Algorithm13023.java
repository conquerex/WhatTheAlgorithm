package baekjoon.part2_06_dfsbfs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ABCDE
 * 문제 : https://www.acmicpc.net/problem/13023
 * 풀이 : https://www.acmicpc.net/source/share/9e95120c2a744876813ae5198c84993b
 * 첫째 줄에 사람의 수 N (5 ≤ N ≤ 2000)과 친구 관계의 수 M (1 ≤ M ≤ 2000)이 주어진다.
 * 둘째 줄부터 M개의 줄에는 정수 a와 b가 주어지며, a와 b가 친구라는 뜻이다. (0 ≤ a, b ≤ N-1, a ≠ b)
 * 같은 친구 관계가 두 번 이상 주어지는 경우는 없다.
 */
public class Algorithm13023 {

    static class Edge {
        int from, to;

        Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // 인접 행렬
        boolean[][] list = new boolean[n][n];
        // 인접 리스트
        ArrayList<Integer>[] g = new ArrayList[n];
        // 간선 리스트
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            // 간선 리스트 : 양방향
            edges.add(new Edge(from, to));
            edges.add(new Edge(to, from));

            // 인접 행렬
            list[from][to] = list[to][from] = true;

            // 인접 리스트
            g[from].add(to);
            g[to].add(from);
        }

        // m : 친구 관계 수, 양방향이므로 간선의 수는 2
        m *= 2;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println("==== 스타트 ====");
                // a --> b : 간선 리스트
                int a = edges.get(i).from;
                int b = edges.get(i).to;
                // c --> d : 간선 리스트
                int c = edges.get(j).from;
                int d = edges.get(j).to;

                if (a == b | a == c | a == d | b == c | b == d | c == d) {
                    System.out.println("a ::: " + a);
                    System.out.println("b ::: " + b);
                    System.out.println("c ::: " + c);
                    System.out.println("d ::: " + d);
                    System.out.println("간선 리스트");
                    continue;
                }
                System.out.println("-- mid1 --");
                // ab --> cd : 인접 행렬
                if (!list[b][c]) {
                    System.out.println("인접 행렬");
                    continue;
                }
                System.out.println("-- mid2 --");
                // abcd --> e : 인접 리스트
                for (int e : g[d]) {
                    if (a == e | b == e | c == e | d == e) {
                        System.out.println("인접 리스트");
                        continue;
                    }
                    System.out.println("a ::: " + a);
                    System.out.println("b ::: " + b);
                    System.out.println("c ::: " + c);
                    System.out.println("d ::: " + d);
                    System.out.println("e ::: " + e);
                    System.out.println(1);
                    System.exit(0);
                }
            }
        }

        System.out.println(0);
    }
}
