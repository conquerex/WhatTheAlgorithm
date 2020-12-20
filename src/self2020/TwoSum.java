package self2020;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Jongkook
 * @date : 2020/12/17
 * <p>
 * https://leetcode.com/problems/two-sum/
 */

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 11, 7, 15};
        int target = 9;
        Arrays.stream(twoSum(nums, target)).forEach(System.out::println);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Integer res;
        for (int i = 0; i < nums.length; i++) {
            res = map.get(nums[i]);
            if (res != null) { // 차이값이 존재하면
                return new int[]{res, i}; // 차이값의 위치(hashmap의 value)와 현재 위치 반환
            } else {
                map.put(target - nums[i], i); // 차이값
            }
        }

        return new int[]{};
    }
}
