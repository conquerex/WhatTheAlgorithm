package baekjoon.part2tree;

import java.util.Scanner;

/**
 * 트리 순회
 * 문제 : https://www.acmicpc.net/problem/1991
 * 풀이 : https://www.acmicpc.net/source/share/5579a90defb9426fb5f04745246cb20c
 * <p>
 * 첫째 줄에는 이진 트리의 노드의 개수 N(1≤N≤26)이 주어진다.
 * 둘째 줄부터 N개의 줄에 걸쳐 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드가 주어진다.
 * 노드의 이름은 A부터 차례대로 영문자 대문자로 매겨지며, 항상 A가 루트 노드가 된다.
 * 자식 노드가 없는 경우에는 .으로 표현된다.
 */
public class Algorithm1991 {

    static class Node {
        int left, right;

        Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    // (루트) (왼쪽 자식) (오른쪽 자식)
    static void preOrder(Node[] a, int x) {
        if (x == -1) return;
        System.out.print((char) (x + 'A'));
        preOrder(a, a[x].left);
        preOrder(a, a[x].right);
    }

    // (왼쪽 자식) (루트) (오른쪽 자식)
    static void inOrder(Node[] a, int x) {
        if (x == -1) return;
        inOrder(a, a[x].left);
        System.out.print((char) (x + 'A'));
        inOrder(a, a[x].right);
    }

    // (왼쪽 자식) (오른쪽 자식) (루트)
    static void postOrder(Node[] a, int x) {
        if (x == -1) return;
        postOrder(a, a[x].left);
        postOrder(a, a[x].right);
        System.out.print((char) (x + 'A'));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 노드의 개수

        Node[] a = new Node[26];

        for (int i = 0; i < n; i++) {
            int x = sc.next().charAt(0) - 'A'; // 루트
            char y = sc.next().charAt(0);
            char z = sc.next().charAt(0);
            int left = -1;
            int right = -1;

            if (y != '.') {
                left = y - 'A'; // Integer화
            }

            if (z != '.') {
                right = z - 'A'; // Integer화
            }

            a[x] = new Node(left, right);
        }

        preOrder(a, 0);
        System.out.println();

        inOrder(a, 0);
        System.out.println();

        postOrder(a, 0);
        System.out.println();
    }
}
