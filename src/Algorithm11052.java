import java.util.Scanner;

/**
 * 카드 구매하기
 * 문제 : https://www.acmicpc.net/problem/11052
 * 풀이 : https://www.acmicpc.net/source/share/03e95c4468d7473289fe4829f13419b5
 */
public class Algorithm11052 {

    /**
     * 카드 n개를 구매하는 방법
     * D[n] = max(D[N-i] + P[i])
     * 1 <= i <= n
     *
     * 시간복잡도 : O(n^2)
     * 1. 전체 문제의 갯수 == 배열의 크기 (n개 구매하는 비용) -> n
     * 2. n개의 수를 비교해서 그 값에 최대값을 구해야 함 -> 하나의 칸을 구하는데 O(n)
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] packList = new int[n+1];
        for (int i = 1; i <= n; i++) {
            packList[i] = sc.nextInt();
        }

        int[] d = new int[n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // 점화식
                if (d[i] < d[i-j] + packList[j]) {
                    // D[n] = max(D[N-i] + P[i])
                    // d[n] : 카드 n개 구매하는 최대 비용
                    d[i] = d[i-j] + packList[j];
                }
            }
        }

        System.out.println(d[n]);
    }
}
