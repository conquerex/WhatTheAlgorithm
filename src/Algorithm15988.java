import java.util.Scanner;

/**
 * 1, 2, 3 더하기 3
 * 문제 : https://www.acmicpc.net/problem/15988
 * 풀이 : https://www.acmicpc.net/source/share/b494f455c9e64ceeb7080ce88a87cfc9
 *
 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
 * 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 1,000,000보다 작거나 같다.
 * 각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 1,000,000,009로 나눈 나머지를 출력한다.
 */
public class Algorithm15988 {
    static final int LIST_LIMIT = 1000000;
    static final long MOD = 1000000009L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] d = new long[LIST_LIMIT + 1];
        int n = sc.nextInt();

        // 초기화 : 0으로 만드는 방법이 있나? 공집합도 하나의 결과라고 봐야하나?
        d[0] = 1;

        for (int i = 1; i <= LIST_LIMIT; i++) {
            for (int j = 1; j <= 3; j++) {
                /**
                 * d[n-1] : 마지막 숫자가 1일 때 경우의 수
                 * d[n-2] : 마지막 숫자가 2일 때 경우의 수
                 * d[n-3] : 마지막 숫자가 3일 때 경우의 수
                 * d[n] = d[n-1] + d[n-2] + d[n-3]
                 */
                if (i-j >= 0) {
                    d[i] += d[i-j];
                }
            }
        }

        while (n-- > 0) {
            int t = sc.nextInt();
            System.out.println(d[t]);
        }
    }
}
