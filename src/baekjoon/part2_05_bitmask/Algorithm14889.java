package baekjoon.part2_05_bitmask;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 스타트와 링크
 * 문제 : https://www.acmicpc.net/problem/14889
 * 풀이 : https://www.acmicpc.net/source/share/d58dfc29edac47ee81920cab06ec7ed1
 * 추가 풀이 : https://www.acmicpc.net/source/share/0016875c0b8848e9bf6a68a0048f7cff
 * 스타트 팀의 능력치와 링크 팀의 능력치의 차이를 최소로 하려고 한다.
 */
public class Algorithm14889 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] s = new int[n][n]; // 팀의 능력치는 팀에 속한 모든 쌍의 능력치 S
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s[i][j] = sc.nextInt();
            }
        }
        int result = -1;

        // 1, 10, 11 .... 까지 확인하기 : 모든 집합 확인
        for (int i = 0; i < (1 << n); i++) {

            int count = 0;
            for (int j = 0; j < n; j++) {
                // 집합에 어떤 수로 구성되어 있는지 확인
                if ((i & (1 << j)) == 0) {
                    count += 1;
                }
            }
            if (count != n/2) continue;

            ArrayList<Integer> first = new ArrayList<>();
            ArrayList<Integer> second = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                // 집합에 어떤 수로 구성되어 있는지 확인
                if ((i & (1 << j)) == 0) {
                    first.add(j);
                } else {
                    second.add(j);
                }
            }

            // 전원의 절반이 한팀에 들어가지 않을 경우
//            if (first.size() != n/2) continue;

            int team1 = 0;
            int team2 = 0;

            // 능력치 합산
            for (int a = 0; a < n/2 ; a++) {
                for (int b = 0; b < n/2 ; b++) {
                    team1 += s[first.get(a)][first.get(b)];
                    team2 += s[second.get(a)][second.get(b)];
                }
            }

            int diff = Math.abs(team1 - team2);
            if (result == -1 || result > diff) {
                result = diff;
            }
        }

        System.out.println(result);
    }
}
