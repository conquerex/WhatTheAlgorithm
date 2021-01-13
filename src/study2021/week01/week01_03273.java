package study2021.week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by Jongkook on 2021/01/14.
 * 문제 출처 :https://www.acmicpc.net/problem/3273
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class week01_03273 {
    public static void main(String[] args) {
        long sum = 0;
        int start = 0, end = 1;
        long result = 0;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine()); // 첫째줄
            StringTokenizer st = new StringTokenizer(br.readLine()); // 둘째줄
            int x = Integer.parseInt(br.readLine()); // 셋째줄

            int[] input = new int[n];
            PriorityQueue<Integer> queue = new PriorityQueue();
            while (st.hasMoreTokens()) {
//                input[start++] = Integer.parseInt(st.nextToken());
                queue.add(Integer.parseInt(st.nextToken()));
            }

            // 다시 초기화
            start = 0;

            // 투포인터 사용시 반드시 정렬 먼저
//            List<Integer> list = Arrays.stream(input).sorted().boxed().collect(Collectors.toList());

            int[] array = new int[queue.size()];
            for (int i = 0; i < n; i++) {
                array[i] = queue.poll();
            }

            while (start < n) {
                // sum을 다시 하는 시점이 중요
                if (end < n)
//                    sum = list.get(start) + list.get(end);
                    sum = array[start] + array[end];
                else
//                    sum = list.get(start) + list.get(n - 1);
                    sum = array[start] + array[n - 1];

                if (sum >= x || end == n) {
                    // start 위치를 옮기는 동시에 end도 재조정
                    start++;
                    end = start + 1;
                } else {
                    end++;
                }

                if (sum == x) result++;
            }

            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
