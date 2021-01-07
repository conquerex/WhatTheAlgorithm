package study2020.week1;

/**
 * https://leetcode.com/problems/climbing-stairs/
 */
public class week1_00003 {

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    public static int climbStairs(int n) {
        if (n < 3) {
            if (n == 0) {
                return 1;
            }
            return n;
        }

        int first = 1;
        int second = 2;
        int result = 0;

        for (int i = 3; i <= n ; i++) {
            result = first + second;
            first = second;
            second = result;
        }

        return second;
    }

}
