package codetest.klc;

/**
 * @author Jongkook
 * @date : 2020/09/07
 */

public class Decimal {
    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 6, 4};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        int answer = 0;

        // 첫번째 선택
        for (int i = 0; i < nums.length - 2; i++) {
            // 두번째 선택
            for (int j = i + 1; j < nums.length - 1; j++) {
                // 세번째 선택
                for (int k = j + 1; k < nums.length; k++) {
                    int num = nums[i] + nums[j] + nums[k];

                    // 소수 검산
                    int n = 2;
                    boolean check = true;
                    while (n < num) {
                        if (num % n == 0) {
                            check = false;
                            break;
                        }
                        n++;
                    }

                    if (check) answer++;
                }
            }
        }

        return answer;
    }
}
