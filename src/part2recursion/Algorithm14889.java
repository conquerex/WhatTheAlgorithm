package part2recursion;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 스타트와 링크
 * 문제 : https://www.acmicpc.net/problem/14889
 * 풀이 : https://www.acmicpc.net/source/share/556157a8419d424a86d3e14e2273600b
 * 추가 풀이 : https://www.acmicpc.net/source/share/556157a8419d424a86d3e14e2273600b
 * 스타트 팀의 능력치와 링크 팀의 능력치의 차이를 최소로 하려고 한다.
 */
public class Algorithm14889 {

    static int[][] s;
    static int n;

    static int cal(int index, ArrayList<Integer> first, ArrayList<Integer> second) {
        // 정답을 찾은 경우
        if (index == n) {
            if (first.size() == 0) return -1;
            if (second.size() == 0) return -1;

            int team1 = 0;
            int team2 = 0;

            for (int i = 0; i < first.size(); i++) {
                for (int j = 0; j < first.size(); j++) {
                    team1 += s[first.get(i)][first.get(j)];
                }
            }

            for (int i = 0; i < second.size(); i++) {
                for (int j = 0; j < second.size(); j++) {
                    team2 += s[second.get(i)][second.get(j)];
                }
            }

            return Math.abs(team1 - team2);
        }

        // 양 팀의 팀원이 같아야 한다는 룰에 어긋나므로
        if (first.size() > n/2) return -1;
        if (second.size() > n/2) return -1;

        int result = -1;

        first.add(index);
        int team1 = cal(index + 1, first, second);
        if (result == -1 || (team1 != -1 && team1 < result)) {
            result = team1;
        }
        first.remove(first.size() - 1);

        second.add(index);
        int team2 = cal(index + 1, first, second);
        if (result == -1 || (team2 != -1 && team2 < result)) {
            result = team2;
        }
        second.remove(second.size() - 1);

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s[i][j] = sc.nextInt();
            }
        }

        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        System.out.println(cal(0, first, second));
    }
}
