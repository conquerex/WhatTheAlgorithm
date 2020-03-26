package part2bruteforce;

import java.util.Scanner;

/**
 * 날짜 계산
 * 문제 : https://www.acmicpc.net/problem/1476
 * 풀이 : https://www.acmicpc.net/source/share/151e08d2bcaa46a8a28f61b063550578
 * 지구를 나타내는 수를 E, 태양을 나타내는 수를 S, 달을 나타내는 수를 M이라고 했을 때, 이 세 수는 서로 다른 범위를 가진다.
 * (1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19)
 * E S M이 우리가 알고 있는 연도로 몇 년인지 구하는 프로그램을 작성하시오.
 * [sample]
 * 1 16 16 --> 16
 * 1 2 3 --> 5266
 * 15 28 19 --> 7980
 */
public class Algorithm1476 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt() - 1; // 최대수에서 나머지를 구할 때 0이 나오지 않게 하기 위함
        int s = sc.nextInt() - 1;
        int m = sc.nextInt() - 1;

        int i = 0;
        while (i > -1) {
            if (i > 10000 * 10000) {
                break;
            }
            if (i % 15 == e && i % 28 == s && i % 19 == m) {
                System.out.println(i+1);
                break;
            }
            i++;
        }
    }
}
