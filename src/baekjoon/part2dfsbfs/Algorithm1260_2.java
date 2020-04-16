package baekjoon.part2dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * DFS와 BFS (간선 리스트 : 간선을 모두 저장하고 있다.)
 * 문제 : https://www.acmicpc.net/problem/1260
 * 풀이 : https://www.acmicpc.net/source/share/304dc84b3eb04e1b9832505dae72a0fc
 * [sample]
 * 4 5 1
 * 1 2
 * 1 3
 * 1 4
 * 2 4
 * 3 4
 * [edges]
 * edges[0] : 1 2
 * edges[5] : 2 1
 */

public class Algorithm1260_2 {

    static Edge[] edges;
    static int[] count; // 나중에 번호별 누적으로 쌓인다. 무슨 의미인지 모르겠으면 아래 println를 참고
    static boolean[] check;

    /**
     * DFS 시나리오
     * 1 -> 2 -> 4 -> 3
     */
    static void showDfs(int n) {
        check[n] = true;
        System.out.print(n + " ");

        // s = 1
        // n = 1 ==> i = count[0] ; i < count[1] ; i++
        // n = 2 ==> i = count[1] ; i < count[2] ; i++
        // n = 4 ==> i = count[3] ; i < count[4] ; i++
        // n = 3 ==> i = count[2] ; i < count[3] ; i++
        for (int i = count[n - 1]; i < count[n]; i++) {
//            System.out.print(i + "::: ");
            // i : 0, edges[0] : 1 2, to : 2
            // i : 3, edges[3] : 2 4, to : 4
            // i : 7/8/9, edges[9] : 4 3, to : 3
            // i : 5/6, to ==> 1(t)
            // i : 4, to ==> 4(t)
            // i : 1/2, to ==> 3(t), 4(t)
            int next = edges[i].to;
            if (check[next] == false) {
                showDfs(next);
            }
        }
    }

    /**
     * BFS 시나리오
     * 1 -> 2-> 3 -> 4
     */
    static void showBfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        // s = 1
        queue.add(s);
        check[s] = true;
        while (!queue.isEmpty()) {
            int n = queue.remove();
//            System.out.print(">>> "+queue.size() + " / ");
            System.out.print(n + " ");
            // i = count[0], i< count[1], i++, edges[0,1,2], to:2,3,4 ==> add(2,3,4) q:2,3,4 ==> 사실상 여기서 끝
            // i = count[1], i< count[2], i++, edges[3,4], to:4,4 ==> add(x) q:3,4
            // i = count[2], i< count[3], i++, edges[5,6], to:1,1 ==> add(x) q:4
            // i = count[3], i< count[4], i++, edges[7,8,9], to:1,2,3 ==> add(x) q:없음
            for (int i = count[n - 1]; i < count[n]; i++) {
//                System.out.print(i + ":: ");
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
        // 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000),
        // 간선의 개수 M(1 ≤ M ≤ 10,000),
        // 탐색을 시작할 정점의 번호 V가 주어진다. --> s : start
        int n = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();

        // 간선 갯수 = 정점 * 2
        edges = new Edge[2 * m];
        // 정점이 1부터 시작하므로 n + 1
        count = new int[n + 1];
        check = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            edges[i] = new Edge(from, to);
            edges[m + i] = new Edge(to, from);
        }

        // m : 간선 갯수
        m *= 2;

        // 정점과 이어진 간선 갯수
        for (int i = 0; i < m; i++) {
            count[edges[i].from] += 1;
        }

        // count[n+1] : 모든 간선의 합 * 2 (양방향)
        for (int i = 1; i < n + 1; i++) {
            count[i] += count[i - 1];
        }

        System.out.println(">>> 0 : " + count[0]);
        System.out.println(">>> 1 : " + count[1]);
        System.out.println(">>> 2 : " + count[2]);
        System.out.println(">>> 3 : " + count[3]);
        System.out.println(">>> 4 : " + count[4]);

        // DFS
        showDfs(s);
        System.out.println();

        // BFS
        // check 리셋
        check = new boolean[n + 1];
        showBfs(s);
        System.out.println();
    }
}

class Edge implements Comparable<Edge> {
    int from, to;

    // 간선 정의
    Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public int compareTo(Edge edge) {
        // 이 문제에서는 상관없는 코드
//        if (this.from < edge.from) {
//            return -1;
//        } else if (this.from == edge.from) {
//            if (this.to < edge.to) {
//                return -1;
//            } else if (this.to == edge.to) {
//                return 0;
//            } else {
//                return 1;
//            }
//        } else {
//            return 1;
//        }
        return 0;
    }
}