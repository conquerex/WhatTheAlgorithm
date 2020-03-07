package part1;

import java.util.Scanner;

/**
 * 가장 긴 증가하는 부분 수열 4
 * 문제 : https://www.acmicpc.net/problem/14002
 * 풀이 : https://www.acmicpc.net/source/share/e3f0eae9697a47f8833d39150a08cc66
 *
 * 수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.
 * 예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.
 * 첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.
 * 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)
 * 첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.
 * 둘째 줄에는 가장 긴 증가하는 부분 수열을 출력한다.
 */
public class Algorithm14002 {
    static int[] list;
    static int[] d;
    static int[] results;

    static void printResults(int r) {
        if (r == -1) return;
        printResults(results[r]);
        System.out.println(list[r] + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        list = new int[n];
        d = new int[n];
        results = new int[n];

        for (int i = 0; i < n ; i++) {
            list[i] = sc.nextInt();
        }

        for (int i = 0; i < n ; i++) {
            // 초기값 세팅
            d[i] = 1;
            results[i] = -1;
            for (int j = 0; j < n ; j++) {
                /**
                 * list[j] < list[i] : 왼쪽 숫자가 오른쪽 숫자보다 작아야 한다.
                 * d[i] < d[j] + 1   : 경우의 수가 최대인 값만 저장할 필요가 있으므로
                 */
                if (list[i] > list[j] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                    results[i] = j;
                }
            }
        }

        int result = 0;
        int maxPosition = 0;
        for (int i = 0; i < n ; i++) {
            if (d[i] > result) {
                result = d[i];
                maxPosition = i;
            }
        }
        System.out.println(result);
        printResults(maxPosition);
    }
}
