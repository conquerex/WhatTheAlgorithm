import java.util.Scanner;

/**
 * 1, 2, 3 더하기
 * 정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 3가지가 있다.
 * 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
 * 단, 같은 수를 두 번 이상 연속해서 사용하면 안 된다.
 *
 * 문제 : https://www.acmicpc.net/problem/15990
 * 풀이 : https://www.acmicpc.net/source/share/6f3aa2dc605a486db24895cdda07dae5
 */
public class Algorithm15990 {

    /**
     * 각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 1,000,000,009로 나눈 나머지를 출력한다.
     */
    static final long MOD = 1000000009L;

    /**
     * 첫째 줄에 테스트 케이스의 개수 'T'가 주어진다.
     * 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다.
     * n은 양수이며 100,000보다 작거나 같다.
     */
    static final int LIMIT = 100000;

    // [되어야 하는 수][마지막에 사용한 수 ; 1~3]
    static long[][] d = new long[LIMIT + 1][4];

    public static void main(String[] args) {
        for (int i = 1; i <= LIMIT; i++) {
            if (i-1 >= 0) {
                d[i][1] = d[i-1][2] + d[i-1][3];
                if (i == 1) {
                    d[i][1] = 1;
                }
            }

            if (i-2 >= 0) {
                d[i][2] = d[i-2][1] + d[i-2][3];
                if (i == 2) {
                    d[i][2] = 1;
                }
            }

            if (i-3 >= 0) {
                d[i][3] = d[i-3][1] + d[i-3][2];
                if (i == 3) {
                    d[i][3] = 1;
                }
            }

            d[i][1] = d[i][1] % MOD;
            d[i][2] = d[i][2] % MOD;
            d[i][3] = d[i][3] % MOD;
        }

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트 케이스 갯수
        while (t-- > 0) {
            int n = sc.nextInt();
            long result = 0;
            for (int j = 1 ; j <= 3 ; j++) {
                result += d[n][j];
            }
            System.out.println(result % MOD);
        }
    }
}
