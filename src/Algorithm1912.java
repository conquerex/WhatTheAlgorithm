import java.util.Scanner;

/**
 * 연속합
 * 문제 : https://www.acmicpc.net/problem/1912
 * 풀이 : https://www.acmicpc.net/source/share/aa386e1924344132b116d243460a4dd1
 * n개의 정수로 이루어진 임의의 수열이 주어진다.
 * 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다.
 * 단, 수는 한 개 이상 선택해야 한다.
 * 예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자.
 * 여기서 정답은 12+21인 33이 정답이 된다.
 *
 * 첫째 줄에 정수 n(1 ≤ n ≤ 100,000)이 주어지고 둘째 줄에는 n개의 정수로 이루어진 수열이 주어진다.
 * 수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다.
 */
public class Algorithm1912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] list = new int[n];
        int[] d = new int[n];

        for (int i = 0 ; i < n ; i++) {
            list[i] = sc.nextInt();
        }

        for (int i = 0 ; i < n ; i++) {
            d[i] = list[i];
            if (i == 0) continue;
            /**
             * list[i] 값은 d[i]와 같거나 더 작아야 한다.
             * 연속된 값이 본인보다 작으면 차라리 본인값은 점화식에 대응시킨다.
             */
            if (d[i] < d[i-1] + list[i]) {
                d[i] = d[i-1] + list[i];
            }
        }

        // 초기화, 최소한 첫번째 숫자가 결과값이므로
        int result = d[0];
        for (int i = 0 ; i < n ; i++) {
            if (result < d[i]) {
                result = d[i];
            }
        }

        System.out.println(result);
    }
}
