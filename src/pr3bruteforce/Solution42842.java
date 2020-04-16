package pr3bruteforce;

import java.util.ArrayList;

/**
 * 카펫
 * 문제 : https://programmers.co.kr/learn/courses/30/lessons/42842
 * 풀이 : https://programmers.co.kr/learn/courses/30/lessons/42842/solution_groups?language=java
 */
public class Solution42842 {
    public static void main(String[] args) {
        int[] answer = solution(10, 2);
        System.out.println();
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    static public int[] solution(int brown, int red) {
        int[] answer = new int[2];
        ArrayList<Integer> list = new ArrayList();
        for (int i = 1; i < (red + brown) / 2; i++) {
            // red + brown : 면적
            // 약수를 구함
            if ((red + brown) % i == 0) {
                list.add(i);
                list.add((red + brown) / i);
            }
        }

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }

        for (int i = 0; i < list.size(); i += 2) {
            int line1 = list.get(i) - 1;
            int line2 = list.get(i + 1) - 1;
            // 둘레 조건으로 답을 구함
            if ((line1 + line2) * 2 == brown) {
                // 큰수가 먼저 나와야 하므로 i+1이 0번째에 담김
                answer[0] = list.get(i + 1);
                answer[1] = list.get(i);
                return answer;
            }
        }

        return answer;
    }
}
