package pr1hash;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 완주하지 못한 선수
 * 문제 : https://programmers.co.kr/learn/courses/30/lessons/42576
 * 풀이 : https://programmers.co.kr/learn/courses/30/lessons/42576/solution_groups?language=java
 */
public class Solution42576 {
    public static void main(String[] args) {

        String[] part = {"marina", "josipa", "nikola", "vinko", "filipa", "test"};
        String[] comp = {"josipa", "filipa", "marina", "vinko", "nikola"};

        System.out.println(solution(part, comp));
    }
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        List<String> pList = Arrays.asList(participant);
        Collections.sort(pList);
        List<String> cList = Arrays.asList(completion);
        Collections.sort(cList);

        for (int i = 0; i < cList.size() ; i++) {
            if (pList.get(i).equals(cList.get(i))) continue;
            else return pList.get(i);
        }
        answer = pList.get(pList.size() - 1);
        return answer;
    }
}
