package part2bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * 숨바꼭질 4
 * 문제 : https://www.acmicpc.net/problem/13913
 * 풀이 : https://www.acmicpc.net/source/share/74337f7a446944948d0a209ee4972ffa
 * 첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.
 * 첫째 줄에 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
 * 둘째 줄에 어떻게 이동해야 하는지 공백으로 구분해 출력한다.
 */
public class Algorithm13913 {

    static final int MAX = 1000000;

    static void print(int[] from, int n, int m) {
        if (n != m) {
            print(from, n, from[m]);
        }
        System.out.print(m + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 찾는 사람 위치
        int m = sc.nextInt(); // 숨어있는 사람 위치
        boolean[] check = new boolean[MAX];
        int[] distance = new int[MAX];
        int[] from = new int[MAX]; // stack

        // init
        check[n] = true;
        distance[n] = 0; // 결과값 초기 세팅
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n); // 초기 위치 세팅

        while (!queue.isEmpty()) {
            int now = queue.remove();

            // x - 1 이동
            if (now - 1 >= 0) {
                if (check[now - 1] == false) {
                    queue.add(now - 1);
                    check[now - 1] = true;
                    distance[now - 1] = distance[now] + 1;
                    from[now - 1] = now;
                }
            }

            // x + 1 이동
            if (now + 1 < MAX) {
                if (check[now + 1] == false) {
                    queue.add(now + 1);
                    check[now + 1] = true;
                    distance[now + 1] = distance[now] + 1;
                    from[now + 1] = now;
                }
            }

            // x * 2 이동
            if (now * 2 < MAX) {
                if (check[now * 2] == false) {
                    if (check[now * 2] == false) {
                        queue.add(now * 2);
                        check[now * 2] = true;
                        distance[now * 2] = distance[now] + 1;
                        from[now * 2] = now;
                    }
                }
            }
        }

        // result 1.
        System.out.println(distance[m]);
        print(from, n, m);

        // result 2. print with stack
//        Stack<Integer> result = new Stack<>();
//        // m부터 시작해서 from[i]로 Stack에 쌓아둠
//        for (int i = m; i != n; i = from[i]) {
//            result.push(i);
//        }
//        // 마지막으로 첫번째 위치를 stack에 입력
//        result.push(n);
//        while (!result.isEmpty()) {
//            // stack에 꺼내면서 출력
//            System.out.print(result.pop() + " ");
//        }

        System.out.println();
    }
}
