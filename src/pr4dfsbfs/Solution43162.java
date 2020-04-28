package pr4dfsbfs;

import java.util.ArrayDeque;

public class Solution43162 {

    static boolean[] check;

    static public int solution(int n, int[][] computers) {
        int answer = 0;
        check = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (check[i] == false) {
                showBfs(n, computers, check, i);
                answer += 1;
            }
        }
        return answer;
    }

    static public void showBfs(int n, int[][] computers, boolean[] check, int i) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(i);

        while (deque.size() > 0) {
            int now = deque.pop();
            check[now] = true;
            for (int k = 0; k < n; k++) {
                if (check[k] == false && computers[now][k] == 1) {
                    deque.add(k);
                }
            }
        }
    }

    public static void main(String[] args) {
        int numbers[][] = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int n = 3;
        System.out.println(solution(n, numbers));
    }
}
