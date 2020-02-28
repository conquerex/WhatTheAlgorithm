import java.util.HashMap;
import java.util.Scanner;

/**
 * 테스트(과제)용
 */
public class AlgorithmTest2 {
    public static void main(String[] args) {
        //[2, 5, 7, 11, 15, 4], 9
        Scanner sc = new Scanner(System.in);
//        int a = sc.nextin;
//        solve();
    }

    public static int[] solve(int[] arrayParam, int targetParam) {
        // e.g. arrayParam = [2, 5, 7, 11, 15, 4]
        // e.g. targetParam = 9
        HashMap map = new HashMap();
        int[] answer = new int[2];

        for (int i = 0; i < arrayParam.length; i++) {
            int subtraction = targetParam - arrayParam[i];
            if (map.containsKey(subtraction)) {
                answer[0] = (int) map.get(subtraction);
                answer[1] = i;
                return answer;
            }
            map.put(arrayParam[i], i);
        }
        return null; // 해당없음
    }
}