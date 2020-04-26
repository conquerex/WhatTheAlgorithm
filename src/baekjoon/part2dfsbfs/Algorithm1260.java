package baekjoon.part2dfsbfs;

import java.util.*;

/**
 * DFS와 BFS (인접 리스트)
 * 문제 : https://www.acmicpc.net/problem/1260
 * 풀이 : https://www.acmicpc.net/source/share/8749c68651d64a4993d3e47c476886e4
 * [sample]
 * 4 5 1
 * 1 2 --> [1]
 * 1 3
 * 1 4
 * 2 4
 * 3 4 --> [5]
 * [ArrayList]
 * 2 3 4
 * 1 4
 * 1 4
 * 1 2 3
 */
public class Algorithm1260 {

    static ArrayList<Integer>[] arrayLists;
    static boolean[] checkList;

    /**
     * DFS 시나리오 (Stack)
     * 1 -> 2 -> 1(t), 4 -> 1(t), 2(t), 3
     */
    public static void showDfs(int x) {
        // 첫 진입시 false
        // x == s : 1
        if (checkList[x]) return;
        checkList[x] = true;
        System.out.print(x + " ");
        for (int y : arrayLists[x]) {
            // arrayList[1] : 1(t) 2(f)
            if (checkList[y] == false) {
                showDfs(y);
            }
        }
    }

    /**
     * BFS 시나리오 (Queue)
     * 1 -> arraylist[1] : (2, 3, 4)
     */
    public static void showBfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        checkList[s] = true;

        while (!queue.isEmpty()) {
            int x = queue.remove();
            System.out.print(x + " ");
            for (int y : arrayLists[x]) {
                if (checkList[y] == false) {
                    checkList[y] = true;
                    queue.add(y);
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
        // 1부터라서 n + 1
        arrayLists = (ArrayList<Integer>[]) new ArrayList[n + 1];

        for (int i = 1; i < n + 1; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            // 간선이 연결하는 두 정점의 번호
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            // 양방향이므로 add는 반대로
            arrayLists[v1].add(v2);
            arrayLists[v2].add(v1);
        }

        for (int i = 1; i < n + 1; i++) {
            Collections.sort(arrayLists[i]);
        }

        // DFS
        checkList = new boolean[n+1];
        showDfs(s);
        System.out.println();

        // BFS
        checkList = new boolean[n+1];
        showBfs(s);
        System.out.println();
    }
}
