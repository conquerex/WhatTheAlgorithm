package baekjoon.part1_05_dynamic;

import java.util.Scanner;

/**
 * 1로 만들기
 * 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
 * 문제 : https://www.acmicpc.net/problem/1463
 * 풀이 : url
 */
public class Algorithm1463 {

    /**
     * i가 3으로 나누어 떨어졌을 때, 3으로 나누는 경우
     * D[i/3]+1
     *
     * 또한 D[2]와 D[3]은 둘 모두 1이라는 값을 가진다.
     * D[4]와 D[6], D[9]는 모두 2이라는 값을 가진다.
     *
     * d[n]에 횟수가 저장된다.
     */
    public static int[] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[n+1];
        System.out.println(go(n));
    }

    // Top-Down
    static int go(int n) {
        if (n == 1) {
            return 0;
        }

        // 메모이제이션
        if (d[n] > 0) {
            return d[n];
        }

        // case 1 : 1을 뺀다
        // case 2, 3에 해당이 안되면 case 1을 사용하게 된다.
        // n == 1일 때, go(0) == 0, d[1] == 1
        d[n] = go(n-1) + 1;

        // case 2 : X가 2로 나누어 떨어지면, 2로 나눈다
        if (n%2 == 0) {
            int temp = go(n/2) + 1;
            if (d[n] > temp) {
                d[n] = temp;
            }
        }

        // case 3 : X가 3으로 나누어 떨어지면, 3으로 나눈다
        if (n%3 == 0) {
            int temp = go(n/3) + 1;
            if (d[n] > temp) {
                d[n] = temp;
            }
        }

        return d[n];
    }
}
