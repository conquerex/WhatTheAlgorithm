package programmers.pr3bruteforce;

/**
 * 소수 찾기
 * 문제 : https://programmers.co.kr/learn/courses/30/lessons/42839
 * 풀이 : https://programmers.co.kr/learn/courses/30/lessons/42839/solution_groups?language=java
 */
public class Solution42839 {
    public static void main(String[] args) {
        System.out.println();
    }

    public int solution(String numbers) {
        int answer = 0;
        // numbers는 길이 1 이상 7 이하인 문자열
        // data : 0 ~ 10000000까지 표현
        boolean[] data = new boolean[10000001];
        // true로 초기화
        for (int i = 0; i < data.length; i++) data[i] = true;
        // 소수 찾기
        for (int i = 2; i < data.length; i++) {
            if (data[i]) {
                for (int j = i * 2; j < data.length; j += i) {
                    // 소수가 아닌 것은 false로
                    data[j] = false;
                }
            }
        }
        // 1은 소수가 아니므로
        data[1] = false;

        // 숫자 쪼개기
        int[] nArr = toNumArray(numbers);
        // 2부터 10000000까지
        // 숫자를 쪼개서 nArr과 비교
        for (int i = 2; i < data.length; i++) {
            // 소수인 것만
            if (data[i]) {
                int[] iArr = toNumArray(Integer.toString(i));
                // 가능한 소수를 찾으면 카운트를 하나씩 올린다.
                if (isPossible(nArr, iArr)) answer++;
            }
        }
        return answer;
    }

    static int[] toNumArray(String s) {
        int[] result = new int[10];
        for (int i = 0; i < s.length(); i++) {
            // 숫자별 갯수 구하기
            result[s.charAt(i) - '0']++;
        }
        return result;
    }

    static boolean isPossible(int[] nArr, int[] iArr) {
        for (int i = 0; i < 10; i++) {
            /**
             * 임의의 숫자의 구성이 제시된 숫자의 구성보다 많을 경우
             * 예시)
             * nArr : 22201 -> 소수라고 가정하자
             * iArr : 002222 -> false : 2가 하나 더 많아서 만들수 있는 숫자가 아니다
             * 위에서 0이 하나 모자라거나 1이 없는 경우는 문제가 되지 않는다.
             */
            if (nArr[i] < iArr[i]) return false;
        }
        return true;
    }
}
