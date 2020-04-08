package part2dfsbfs;

import java.util.*;

/**
 * DFS와 BFS (인접 리스트)
 * 문제 : https://www.acmicpc.net/problem/1260
 * 풀이 : https://www.acmicpc.net/source/share/8749c68651d64a4993d3e47c476886e4
 */
public class Algorithm1260 {

    static ArrayList<Integer>[] arrayList;
    static boolean[] checkList;

    public static void showDfs(int x) {
        if (checkList[x]) return;
        checkList[x] = true;
        System.out.println(x + " ");
        for (int y : arrayList[x]) {
            if (checkList[y] == false) {
                showDfs(y);
            }
        }
    }

    public static void showBfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        checkList[s] = true;

        while (!queue.isEmpty()) {
            int x = queue.remove();
            System.out.println(x + " ");
            for (int y : arrayList[x]) {
                if (checkList[y] == false) {
                    checkList[y] = true;
                    queue.add(y);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();
        arrayList = new ArrayList[n + 1];

        for (int i = 1; i < n + 1; i++) {
            arrayList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            arrayList[v1].add(v1);
            arrayList[v2].add(v2);
        }

        for (int i = 1; i < n + 1; i++) {
            Collections.sort(arrayList[i]);
        }

        checkList = new boolean[n+1];
        showDfs(s);
        System.out.println();

        checkList = new boolean[n+1];
        showBfs(s);
        System.out.println();
    }
}
