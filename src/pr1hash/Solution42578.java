package pr1hash;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때
 * 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
 */
public class Solution42578 {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}};
    }

    public static int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1); // 1개만 선택되는 경우
            }
        }

        Iterator<Integer> iterator = map.values().iterator();
        while (iterator.hasNext()) {
            answer *= iterator.next().intValue() + 1;
        }
        answer -= 1;

        return answer;
    }
}
