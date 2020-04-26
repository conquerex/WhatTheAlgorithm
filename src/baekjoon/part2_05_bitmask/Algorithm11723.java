package baekjoon.part2_05_bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 집합
 * 문제 : https://www.acmicpc.net/problem/11723
 * 풀이 : https://www.acmicpc.net/source/share/6e1c2ed60f20464bb32ad0b98e53f031
 */
public class Algorithm11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = 20;
        int m = Integer.valueOf(reader.readLine());
        int s = 0;
        StringBuilder builder = new StringBuilder();

        while (m-- > 0) {
            String[] line = reader.readLine().split(" ");
            if (line[0].equals("add")) {
                int x = Integer.valueOf(line[1]) - 1;
                s = x | (1 << x);
            } else if (line[0].equals("remove")) {
                int x = Integer.valueOf(line[1]) - 1;
                s = x & ~(1 << x);
            } else if (line[0].equals("check")) {
                int x = Integer.valueOf(line[1]) - 1;
                int res = s & 1 << x;
                if (res == 0) {
                    builder.append("0\n");
                } else {
                    builder.append("1\n");
                }
            } else if (line[0].equals("toggle")) {
                int x = Integer.valueOf(line[1]) - 1;
                s = s ^ (1 << x);
            } else if (line[0].equals("all")) {
                s = (1 << n) - 1;
            } else if (line[0].equals("empty")) {
                s = 0;
            }
        }

        System.out.println(builder);
    }
}
