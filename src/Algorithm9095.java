import java.util.Scanner;

/**
 * 1, 2, 3 더하기
 * 문제 : https://www.acmicpc.net/problem/9095
 * 풀이 : https://www.acmicpc.net/source/share/859f6162aa764caa93e92ad3f65c25dc
 */
public class Algorithm9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 예제 갯
        int n = sc.nextInt();

        // 정수 n이 주어진다. n은 양수이며 11보다 작다.
        int[] d = new int[11];
        // 공집합도 결국 존재하는 것이므로
        d[0] = 1;

        for (int i = 1; i <= 10; i++) {
            // D[i] = D[i-1] + D[i-2] + D[i-3]
            for (int j = 1; j <= 3; j++) {
                if (i - j >= 0) {
                    d[i] = d[i] + d[i - j];
                }
            }
        }

        while (n-- > 0) {
            int m = sc.nextInt();
            System.out.println(d[m]);
        }
    }
}
