package study.week3;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Created by Jongkook on 15/06/2020.
 * 더 맵게
 * 문제 출처 :https://programmers.co.kr/learn/courses/30/lessons/42626
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class week3_p42626 {
    public static void main(String[] args) {
        int[] sc = {1, 2, 3, 9, 10, 12};
        System.out.println(solution(sc, 7));
    }

    public static int solution(int[] scoville, int K) {
        // Arrays.stream : 배열로부터 스트림 얻기
        // boxed : int, long, double 요소를 Integer, Long, Double 요소로 박싱해서 Stream을 생성
        // collect : 최종 처리 기능으로 요소들을 수집 또는 그룹핑
        List<Integer> list = Arrays.stream(scoville).boxed().collect(Collectors.toList());
        // PriorityQueue : 무조건 작은 숫자부터 poll된다.
        Queue<Integer> queue = new PriorityQueue<>(list);

        int count = 0;
        while (queue.size() > 1 && queue.peek() <= K) {
            int firstMild = queue.poll();
            int secondMild = queue.poll();
            queue.offer(firstMild + (secondMild * 2));
            count++;
        }
        return queue.peek() >= K ? count : -1;
    }
}
