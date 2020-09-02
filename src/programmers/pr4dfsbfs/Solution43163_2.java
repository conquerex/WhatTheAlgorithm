package programmers.pr4dfsbfs;

import java.util.*;

public class Solution43163_2 {

    static List<Stack<String>> result;
    static String[][] ticketArray;

    public static String[] solution(String[][] tickets) {
        result = new ArrayList<>();
        ticketArray = tickets;

        boolean[] visited = new boolean[tickets.length];
        Stack<String> stack = new Stack<>();
        stack.push("ICN");

        showDfs(visited, stack, 0);

        if (result.size() > 1) {
            Collections.sort(result, new Comparator<Stack<String>>() {
                @Override
                public int compare(Stack<String> t0, Stack<String> t1) {
                    for (int i = 0; i < t0.size(); i++) {
                        String s0 = t0.get(i);
                        String s1 = t1.get(i);

                        if (!s0.equals(s1)) {
                            return s0.compareTo(s1);
                        }
                    }
                    return 0;
                }
            });
        }

        Stack<String> res = result.remove(0);
        String[] answer = new String[res.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = res.get(i);
        }

        return answer;
    }

    public static void showDfs(boolean[] visited, Stack<String> stack, int len) {
        if (len == ticketArray.length) {
            Stack<String> res = new Stack<>();
            for (String s : stack) {
                res.push(s);
            }

            result.add(res);
            return;
        }

        String arrive = stack.peek();

        for (int i = 0; i < ticketArray.length; i++) {
            String[] tic = ticketArray[i];
            if (!visited[i] && arrive.equals(tic[0])) {
                stack.push(tic[1]);
                visited[i] = true;

                showDfs(visited, stack, len + 1);
                visited[i] = false;
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        String[][] t = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[] result = solution(t);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
