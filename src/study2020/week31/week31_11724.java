package study2020.week31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Jongkook on 2020/12/24.
 * 문제 출처 :https://www.acmicpc.net/problem/11724
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class week31_11724 {

    public static Queue<Integer> queue;
    public static ArrayList<ArrayList<Integer>> arrayLists;
    public static boolean[] visited;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int result = 0;

            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]); // 정점의 개수
            int m = Integer.parseInt(input[1]); // 간선의 개수

            // 초기화
            arrayLists = new ArrayList<>();
            visited = new boolean[n + 1];

            // 숫자가 1부터 n까지
            for (int i = 0; i < n + 1; i++) {
                arrayLists.add(new ArrayList<>());
            }

            // 간선
            for (int i = 0; i < m; i++) {
                String[] uv = br.readLine().split(" ");
                int u = Integer.parseInt(uv[0]);
                int v = Integer.parseInt(uv[1]);

                arrayLists.get(u).add(v);
                arrayLists.get(v).add(u);
            }

            for (int i = 1; i < n + 1; i++) {
                if (!visited[i]) {
//                    doBfs(i);
                    doDfs(i);
                    result += 1;
                }
            }

            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void doDfs(int n) {
        visited[n] = true;
        for (int i = 0; i < arrayLists.get(n).size(); i++) {
            int next = arrayLists.get(n).get(i);
            if (!visited[next]) {
                doDfs(next);
            }
        }
    }

    public static void doBfs(int n) {
        queue = new LinkedList<>();
        visited[n] = true;
        queue.offer(n);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int i = 0; i < arrayLists.get(x).size(); i++) {
                int y = arrayLists.get(x).get(i);
                if (!visited[y]) {
                    visited[y] = true;
                    queue.offer(y);
                }
            }
        }
    }
}
