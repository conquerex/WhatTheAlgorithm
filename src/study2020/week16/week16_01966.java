package study2020.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Jongkook on 2020/09/07.
 * 문제 출처 : https://www.acmicpc.net/problem/1966
 * <p>
 * Time Complexity :
 * Used Algorithm : 시뮬레이션, 큐
 * Used Data structure :
 */

public class week16_01966 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCount = Integer.parseInt(br.readLine());
            for (int i = 0; i < testCount; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken()); // 문서 갯수
                int m = Integer.parseInt(st.nextToken()); // 몇번째로 인쇄가 되었는지 궁금한 문서의 index
                int result = 0;

                StringTokenizer docs = new StringTokenizer(br.readLine());
                Queue<Integer> queue = new LinkedList<>();
                // Collections.reverseOrder : 높은 수부터 출력
                Queue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

                // docs의 count는 nextToken마다 변경되기 때문에 n 자리에 docs.countTokens를 사용하면 안됨
                for (int j = 0; j < n; j++) {
                    int doc = Integer.parseInt(docs.nextToken());
                    queue.offer(doc);
                }
                priorityQueue.addAll(queue);

                while (!queue.isEmpty()) {
                    if (queue.peek().equals(priorityQueue.peek())) {
                        // queue에서 뽑은 것이 가장 큰 것인지 확인
                        result++;
                        if (m == 0) {
                            System.out.println(result);
                            break;  // m번째 문서가 poll되는 것이면 끝
                        } else {
                            m--;    // 그게 아니면 숫자 갱신. 앞의 문서가 없어지므로 -1
                        }
                        queue.poll();
                        priorityQueue.poll();
                    } else {
                        // 가장 큰 것이 아닐 경우
                        queue.offer(queue.poll());
                        if (m == 0) {
                            m = queue.size() - 1;
                        } else {
                            m--; // 앞의 문서가 없어지므로 -1
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
