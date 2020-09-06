package study.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Jongkook on 2020/09/07.
 * 문제 출처 : https://www.acmicpc.net/problem/2161
 * <p>
 * Time Complexity :
 * Used Algorithm : 시뮬레이션, 구현
 * Used Data structure :
 */

public class week16_02161 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine()); // 카드 갯수

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                queue.offer(i + 1);
            }

            while (!queue.isEmpty()) {
                // 먼저 출력
                System.out.print(queue.poll() + " ");
                // 비었으면 끝
                if (queue.isEmpty()) break;
                // 비지 않았으면 꺼내서 가장 아래로. (가장 먼저 들어간게 가장 아래기 때문)
                queue.offer(queue.poll());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
