package study2020.week1;

import java.util.*;

public class week1_01260_1 {
    static ArrayList<Integer>[] arrayLists;
    static boolean[] checkList;

    public static void showDFS(int s) {
        if (checkList[s] == true) return;
        checkList[s] = true;
        System.out.println(s + " ");
        for (int y : arrayLists[s]) {
            if (checkList[s] == false) showDFS(y);
        }
    }

    public static void showBFS(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        System.out.println(s + " ");
        for (int y : arrayLists[s]) {
            if (checkList[y] == false) {
                checkList[y] = true;
                queue.add(y);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int s = sc.nextInt();

        arrayLists = (ArrayList<Integer>[]) new ArrayList[n + 1];

        for (int i = 1; i < n + 1; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            arrayLists[v1].add(v2);
            arrayLists[v2].add(v1);
        }

        for (int i = 1; i < n + 1; i++) {
            Collections.sort(arrayLists[i]);
        }

        checkList = new boolean[n + 1];
        showDFS(s);
        System.out.println();

        checkList = new boolean[n + 1];
        showBFS(s);
        System.out.println();
    }
}
