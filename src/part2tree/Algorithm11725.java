package part2tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 트리의 부모 찾기
 * 문제 : https://www.acmicpc.net/problem/11725
 * 풀이 : https://www.acmicpc.net/source/share/c447cc9e46dc4d22b2c499b7a5b69a2c
 */
public class Algorithm11725 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer>[] a = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            a[v1].add(v2);
            a[v2].add(v1);
        }

        boolean[] check = new boolean[n + 1];
        int[] parent = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        check[1] = true;

        while (!queue.isEmpty()) {
            int x = queue.remove();
            for (int y : a[x]) {
                if (check[y] == false) {
                    check[y] = true;
                    parent[y] = x;
                    queue.add(y);
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }
}
