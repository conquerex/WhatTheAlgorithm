package baekjoon.part2tree;

import java.util.Scanner;

/**
 * 트리의 높이와 너비
 * 문제 : https://www.acmicpc.net/problem/2250
 * 풀이 : https://www.acmicpc.net/source/share/0d1a8f4e8d1c453d9f0c0a923ae00124
 */
public class Algorithm2250 {

    static final int NUM = 10001;
    static Node[] a = new Node[NUM];
    static int[] left = new int[NUM];
    static int[] right = new int[NUM];
    static int[] cnt = new int[NUM];
    static int order = 0;

    static void inOrder(int node, int depth) {
        if (node == -1) return;
        inOrder(a[node].left, depth + 1);
        // order : 열의 순서, 하나의 열에는 하나의 노드만 들어갈 수 있다.
        a[node].order = ++order;
        a[node].depth = depth;
        inOrder(a[node].right, depth + 1);
    }

    static class Node {
        int left, right;
        int order, depth;

        Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            a[x] = new Node(y, z);
            if (y != -1) cnt[y] += 1;
            if (z != -1) cnt[z] += 1;
        }

        int root = 0;

        // 루트 찾기
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == 0) {
                root = i;
            }
        }

        inOrder(root, 1);

        int maxDepth = 0;
        for (int i = 1; i <= n; i++) {
            int depth = a[i].depth;
            int order = a[i].order;

            // 0이 포함되면 Math.min에 무조건 0만 나온다.
            // 그래서 left만 분기 처리
            if (left[depth] == 0) {
                left[depth] = order;
            } else {
                left[depth] = Math.min(left[depth], order);
            }
            right[depth] = Math.max(right[depth], order);
            maxDepth = Math.max(maxDepth, depth);
        }

        int result = 0;
        int resultLevel = 0;
        for (int i = 1; i <= maxDepth; i++) {
            if (result < right[i] - left[i] + 1) {
                result = right[i] - left[i] + 1;
                resultLevel = i;
            }
        }

        System.out.println(resultLevel + " " + result);
    }
}
