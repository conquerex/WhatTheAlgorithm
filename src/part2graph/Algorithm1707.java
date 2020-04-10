package part2graph;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 이분 그래프
 * 문제 : https://www.acmicpc.net/problem/1707
 * 풀이 : https://www.acmicpc.net/source/share/3766db41630d45e5a2a9edba40557a5c
 * 이 그래프가 이분 그래프인지 아닌지 판별
 * 첫째 줄에 테스트 케이스의 개수 K(2≤K≤5)
 * 각 테스트 케이스의 첫째 줄에는 그래프의 정점의 개수 V(1≤V≤20,000)와 간선의 개수 E(1≤E≤200,000)
 * 각 정점에는 1부터 V까지 차례로 번호가 붙어 있다
 * 둘째 줄부터 E개의 줄에 걸쳐 간선에 대한 정보
 * 이분 그래프이면 YES, 아니면 NO
 */
public class Algorithm1707 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseCount = sc.nextInt();
        while (caseCount-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<Integer>[] arrayList = new ArrayList[n + 1];
            for (int i = 1; i < n + 1; i++) {
                arrayList[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                arrayList[v1].add(v2);
                arrayList[v2].add(v1);
            }

            // check의 역할
            // 0 : 그룹 없음
            // 1 : 1번 그룹
            // 2 : 2번 그룹
            int[] color = new int[n + 1];
            boolean isGraph = true;
            for (int i = 1; i < n + 1; i++) {
                if (color[i] == 0) {
                    if (showDfs(arrayList, color, i, 1) == false) {
                        isGraph = false;
                    }
                }
            }

            if (isGraph) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static boolean showDfs(ArrayList<Integer>[] list, int[] color, int x, int group) {
        color[x] = group;
        for (int y : list[x]) {
            if (color[y] == 0) {
                // color 구조가 0~2이기에 3 - group로 다른 그룹으로 분류함
                if (showDfs(list, color, y, 3 - group) == false) {
                    return false;
                }
            } else if (color[y] == color[x]) {
                return false;
            }
        }
        return true;
    }
}
