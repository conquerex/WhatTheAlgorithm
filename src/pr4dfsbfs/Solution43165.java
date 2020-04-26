package pr4dfsbfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution43165 {
    boolean[] checkList;

    public int solution(int[] numbers, int target) {
        int answer = 0;
        checkList = new boolean[numbers.length + 1];
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            int now = queue.remove();

            if (now > 0) {
                queue.add(1);
                // 진행중......
            } else {

            }
        }
        for (int i = 0; i < numbers.length - 1; i++) {

        }

        return answer;
    }
}
