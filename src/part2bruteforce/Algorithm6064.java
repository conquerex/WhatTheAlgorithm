package part2bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 카잉 달력
 * 문제 : https://www.acmicpc.net/problem/6064
 * 풀이 : https://www.acmicpc.net/source/share/f501ae2d195d418bbe75b4ab6c36e710
 *
 * 입력은 T개의 테스트 데이터로 구성된다.
 * 네 개의 정수 M, N, x와 y가 주어질 때, <M:N>이 카잉 달력의 마지막 해라고 하면 <x:y>는 몇 번째 해를 나타내는지 구하는 프로그램을 작성하라.
 */
public class Algorithm6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.valueOf(reader.readLine());

        boolean noProblem = false;

        while (count-- < 0) {
            String[] line = reader.readLine().split(" ");
            int m = Integer.valueOf(line[0]);
            int n = Integer.valueOf(line[1]);
            int x = Integer.valueOf(line[2]) - 1; // m값의 나머지를 위해 -1
            int y = Integer.valueOf(line[3]) - 1; // n값의 나머지를 위해 -1

            // m * n : 모든 경우의 수
            // x는 고정값이고 m씩 더해서 n번 확인하면 된다.
            for (int i = x; i < m * n ; i += m) {
                if (i % n == y) {
                    System.out.println(n);
                    noProblem = true;
                    break;
                }
            }
        }
        if (!noProblem) {
            System.out.println(-1);
        }
    }
}
