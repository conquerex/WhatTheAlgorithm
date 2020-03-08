import java.util.Scanner;

/**
 * 가장 큰 증가하는 부분 수열
 * 문제 : https://www.acmicpc.net/problem/11055
 * 풀이 : https://www.acmicpc.net/source/share/75bc0900d3b04002bd47b37d68ea5972
 *
 * 수열 A가 주어졌을 때, 그 수열의 증가 부분 수열 중에서 합이 가장 큰 것을 구하는 프로그램을 작성하시오.
 * [sample]
 * 10
 * 1 100 2 50 60 3 5 6 7 8
 * Answer : 113
 */
public class Algorithm11055 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] list = new int[n];
        int[] d = new int[n];

        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            d[i] = list[i];
            for (int j = 0; j < i; j++) {
                if (list[j] < list[i] && d[i] < d[j] + list[i]) {
                    // list[j] < list[i]의 조건에 해당되는 d[j]와
                    // 본인인 list(i)를 합해야 한다.
                    d[i] = d[j] + list[i];
                }
            }
        }

        int result = d[0];
        for (int i = 1; i < n; i++) {
            if (result < d[i]) {
                result = d[i];
            }
        }

        System.out.println(result);
    }
}
