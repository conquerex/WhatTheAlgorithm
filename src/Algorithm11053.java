import java.util.Scanner;

/**
 * 가장 긴 증가하는 부분 수열
 * 문제 : https://www.acmicpc.net/problem/11053
 * 풀이 : url
 *
 * 수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.
 * 예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.
 * 첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.
 * 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)
 * 첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.
 */
public class Algorithm11053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] list = new int[n];
        int[] d = new int[n];
        int answer = 0;

        for (int i = 0 ; i < n ; i++) {
            list[i] = sc.nextInt();
        }

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < i ; j++) {
                /**
                 * list[j] < list[i] : 왼쪽 숫자가 오른쪽 숫자보다 작아야 한다.
                 * d[i] < d[j] + 1   : 경우의 수가 최대인 값만 저장할 필요가 있으므로
                 */
                if (list[j] < list[i] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                }
            }
        }

        for(int i = 0 ; i < n ; i++) {
            if (answer < d[i]) {
                answer = d[i];
            }
        }

        System.out.println(answer);
    }
}
