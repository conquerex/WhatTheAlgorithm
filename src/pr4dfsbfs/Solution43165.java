package pr4dfsbfs;

public class Solution43165 {

    static public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = showDfs(numbers, 0, 0, target);
        return answer;
    }

    static int showDfs(int[] numbers, int n, int sum, int target) {
        if (n == numbers.length) {
            // 식이 완성되었을 때
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        // + 였을 때 모든 케이스 갯수
        int result1 = showDfs(numbers, n + 1, sum + numbers[n], target);
        // - 였을 때 모든 케이스 갯수
        int result2 = showDfs(numbers, n + 1, sum - numbers[n], target);

        return result1 + result2;
    }

    public static void main(String[] args) {
        int numbers[] = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }
}
