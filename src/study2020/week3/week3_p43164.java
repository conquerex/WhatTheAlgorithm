package study2020.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Jongkook on 15/06/2020.
 * 여행경로
 * 문제 출처 :https://programmers.co.kr/learn/courses/30/lessons/43164
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class week3_p43164 {
    public static void main(String[] args) {
        String[][] tickets
                = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};

        for (String port : solution(tickets)) {
            System.out.println(port);
        }
    }

    public static String[] solution(String[][] tickets) {
        boolean[] visited = new boolean[tickets.length];

        // 만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
        Arrays.sort(tickets, Comparator.comparing(
                (String[] array) -> array[1]
        ));

        List<String> answer = new ArrayList<>();
        getDfs("ICN", tickets, visited, answer);

        return answer.toArray(new String[]{});
    }

    private static boolean getDfs(String from, String[][] ticket, boolean[] visited, List<String> list) {
        list.add(from);

        // 티켓이 4장인 경우, 중복 포함 5군데를 거치게 됨.
        if (list.size() == visited.length + 1) {
            return true;
        }

        for (int i = 0; i < ticket.length; i++) {
            // 1. 입력된 from이 티켓의 출발지와 동일한가.
            // 2. 방문하지 않은 곳인가.
            if (from.equals(ticket[i][0]) && !visited[i]) {
                visited[i] = true; // 방문 표시

                // 티켓의 도착지를 from에 입력하여 getDfs를 재귀로
                boolean success = getDfs(ticket[i][1], ticket, visited, list);

                // "list.size() == visited.length + 1"를 만족한 경우
                if (success) return true;

                // "list.size() == visited.length + 1"를 만족하지 않은 경우이므로
                // 방문하지 않은 것으로 복구
                visited[i] = false;
                // list에서도 빼야 함.
                list.remove(list.size() - 1);
            }
        }
        return false;
    }
}
