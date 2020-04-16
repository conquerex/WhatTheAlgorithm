package pr3bruteforce;

/**
 * 숫자 야구
 * 문제 : https://programmers.co.kr/learn/courses/30/lessons/42841
 * 풀이 : https://programmers.co.kr/learn/courses/30/lessons/42841/solution_groups?language=java
 */
public class Solution42841 {
    public static void main(String[] args) {
        System.out.println();
    }

    static public int solution(int[][] baseball) {
        int result = 0;
        // 세 자리의 수
        boolean data[] = new boolean[1000];
        for (int i = 0; i < data.length; i++) {
            String n = Integer.toString(i);
            // 자릿수가 안맞는 경우
            if (n.length() < 3) data[i] = true;
            // 0이 포함된 경우
            else if (n.charAt(0) == '0' || n.charAt(1) == '0' || n.charAt(2) == '0') data[i] = true;
            // 숫자가 중된 경우
            else if (n.charAt(0) == n.charAt(1) || n.charAt(0) == n.charAt(2) || n.charAt(1) == n.charAt(2))
                data[i] = true;
        }

        for (int i = 0; i < baseball.length; i++) {
            int answer = baseball[i][0];
            int s = baseball[i][1];
            int b = baseball[i][2];

            for (int j = 123; j <= 987; j++) {
                if (!data[j]) {
                    int[] sbData = judge(Integer.toString(j), Integer.toString(answer));
                    // 스트라이크 혹은 볼 조건이 맞지 않으면 true
                    if (sbData[0] != s || sbData[1] != b) data[j] = true;
                }
            }
        }

        // 모든 false를 찾는다.
        for (int i = 0; i < data.length; i++) {
            if (!data[i]) result++;
        }
        return result;
    }

    /**
     * @param num : 123~789
     * @param answer
     * @return
     */
    static int[] judge(String num, String answer) {
        int s = 0;
        int b = 0;
        char[] c = answer.toCharArray();
        for (int i = 0; i < 3; i++) {
            // 해당 숫자가 어디에든 위치해 있다면
            if (num.indexOf(c[i]) >= 0) {
                // 이때 위치한 곳이 같다면 스트라이크++
                if (num.charAt(i) == c[i]) s++;
                // 그렇지 않으면 볼++
                else b++;
            }
        }
        return new int[]{s, b};
    }
}
