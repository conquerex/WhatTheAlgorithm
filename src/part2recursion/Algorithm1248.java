package part2recursion;

import java.util.Scanner;

/**
 * 맞춰봐
 * 문제 : https://www.acmicpc.net/problem/1248
 * 풀이 : https://www.acmicpc.net/source/share/d309c55d1c6c44ff99f153eccea218fd
 * 추가 풀이 : https://www.acmicpc.net/source/share/aa9a3c07908d48da924049db290183cc
 * 추가 풀이 : https://www.acmicpc.net/source/share/424e62fb723a4d79b780c7e580a731e1
 * A[i]는 규현이가 i번째 쓴 수이다.
 * 그리고, S[i][j]는 A[i]부터 A[j]까지 합이 0보다 크면 +, 0이면 0, 0보다 작으면 -이다.
 * [sample]
 * 4
 * -+0++++--+
 * +-----+---+---+---+---+
 * | i\j | 1 | 2 | 3 | 4 |
 * +-----+---+---+---+---+
 * | 1   | - | + | 0 | + |
 * +-----+---+---+---+---+
 * | 2   | x | + | + | + |
 * +-----+---+---+---+---+
 * | 3   | x | x | - | - |
 * +-----+---+---+---+---+
 * | 4   | x | x | x | + |
 * +-----+---+---+---+---+
 */
public class Algorithm1248 {

    static int n;
    static int[][] sign;
    static int[] result;

    static boolean check() {
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += result[i];
                if (sign[i][j] == 0) {
                    if (sum != 0) return false;
                } else if (sign[i][j] > 0) {
                    if (sum <= 0) return false;
                } else if (sign[i][j] < 0) {
                    if (sum >= 0) return false;
                }
            }
        }
        return true;
    }

    static boolean cal(int index) {
        if (index == n) {
            return check();
        }

        /**
         * 21^10 --> 10^10
         * 그래도 경우의 수 많음
         */
        if (sign[index][index] == 0) {
            result[index] = 0;
            return cal(index + 1);
        }
        for (int i = 1; i <= 10; i++) {
            result[index] = sign[index][index] * i;
            if (cal(index + 1)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        result = new int[n];
        sign = new int[n][n];

        String text = sc.next();
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                char ch = text.charAt(count);
                if (ch == '0') {
                    sign[i][j] = 0;
                } else if (ch == '+') {
                    sign[i][j] = 1;
                } else {
                    sign[i][j] = -1;
                }
                count += 1;
            }
        }

        cal(0);

        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println(n);
    }
}
