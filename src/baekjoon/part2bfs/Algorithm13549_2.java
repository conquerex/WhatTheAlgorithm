package baekjoon.part2bfs;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * 숨바꼭질 3 (덱 소스)
 * 문제 : https://www.acmicpc.net/problem/13549
 * 풀이 : https://www.acmicpc.net/source/share/c2201205287445dd9fd2ded648e7b5d4
 * <p>
 * 첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.
 * 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
 * <p>
 * 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
 * 순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.
 */
public class Algorithm13549_2 {

    static final int MAX = 1000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 아래 2개 모두 위치값을 인자로 받는다.
        boolean[] check = new boolean[MAX];
        int[] time = new int[MAX];

        // init
        check[n] = true;
        time[n] = 0;

        // 덱을 사용해 순간 이동은 덱의 앞에, 걷기는 덱의 뒤에 넣는 방법도 있다
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(n);

        while (!deque.isEmpty()) {
            int now = deque.poll();

            // 3가지 이동패턴을 하나씩
            for (int next : new int[]{now * 2, now - 1, now + 1}) {
                if (next >= 0 && next < MAX) {
                    if (check[next] == false) {
                        check[next] = true;
                        if (now * 2 == next) {
                            // 순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.
                            deque.addFirst(next);
                            time[next] = time[now];
                        } else {
                            // 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
                            deque.addLast(next);
                            time[next] = time[now] + 1;
                        }
                    }
                }
            }

            // 더이상 now에서 꺼낼 값이 없으면 다음값을 지금으로 당기고
            // 다음값은 초기화한다.
            // 현재시간 --> 다음시간
//            if (nowQueue.isEmpty()) {
//                nowQueue = nextQueue;
//                nextQueue = new LinkedList<>();
//            }
        }

        System.out.println(time[m]);
    }
}
