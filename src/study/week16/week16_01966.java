package study.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Jongkook on 2020/09/07.
 * 문제 출처 : https://www.acmicpc.net/problem/1966
 * 첫 줄에 test case의 수가 주어진다. 각 test case에 대해서
 * 문서의 수 N(100이하)와
 * 몇 번째로 인쇄되었는지 궁금한 문서가 현재 Queue의 어떤 위치에 있는지를 알려주는 M(0이상 N미만)이 주어진다.
 * 다음줄에 N개 문서의 중요도가 주어지는데, 중요도는 1 이상 9 이하이다.
 * 중요도가 같은 문서가 여러 개 있을 수도 있다. 위의 예는 N=4, M=0(A문서가 궁금하다면), 중요도는 2 1 4 3이 된다.
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
                for (int j = 0; j < docs.countTokens(); j++) {
                    int doc = Integer.parseInt(docs.nextToken());
                    queue.offer(doc);
                    priorityQueue.offer(doc);
                }

                while (!queue.isEmpty()) {
                    if (queue.peek() == priorityQueue.peek()) {
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
