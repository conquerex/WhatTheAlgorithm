package baekjoon.part2challenge;

import java.util.*;

/**
 * BFS 스페셜 저지
 * 문제 : https://www.acmicpc.net/problem/16940
 * 풀이 : https://www.acmicpc.net/source/share/9107adffea9a4008810ad7cd19d59301
 * 첫째 줄에 정점의 수 N(2 ≤ N ≤ 100,000)이 주어진다.
 * 둘째 줄부터 N-1개의 줄에는 트리의 간선 정보가 주어진다.
 * 마지막 줄에는 BFS 방문 순서가 주어진다.
 */
public class Algorithm16940_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer>[] list = new ArrayList[n];
        int[] b = new int[n];
        int[] order = new int[n]; // BFS 방문 순서
        boolean[] check = new boolean[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        // 인접 리스트
        for (int i = 0; i < n - 1; i++) {
            int v1 = sc.nextInt() - 1;
            int v2 = sc.nextInt() - 1;
            list[v1].add(v2);
            list[v2].add(v1);
        }

        // 제시된 방문 순서
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt() - 1;
            order[b[i]] = i;
        }

        for (int i = 0; i < n; i++) {
            // 오름차순 구현
            Collections.sort(list[i], new Comparator<Integer>() {
                @Override
                public int compare(Integer t0, Integer t1) {
                    if (order[t0] < order[t1]) {
                        return -1;
                    } else if (order[t0] == order[t1]) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            });
        }

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        check[0] = true;
        // bfsOrder : 옳은 방문 순서 구하기
        ArrayList<Integer> bfsOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int x = queue.remove();
            bfsOrder.add(x);

            for (int y : list[x]) {
                if (check[y] == false) {
                    check[y] = true;

                    // 같은 부모를 가지는 정점을 모두 담는다.
                    queue.add(y);
                }
            }

        }

        boolean isTrue = true;
        for (int i = 0; i < n; i++) {
            // 제시된 것과 옳은 방문 순서를 비교
            if (bfsOrder.get(i) != b[i]) {
                isTrue = false;
            }
        }

        if (isTrue) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
