package part2bruteforce;

import java.util.Scanner;

/**
 * 리모컨
 * 문제 : https://www.acmicpc.net/problem/1107
 * 풀이 :
 * 리모컨에는 버튼이 0부터 9까지 숫자, +와 -가 있다.
 * +를 누르면 현재 보고있는 채널에서 +1된 채널로 이동하고, -를 누르면 -1된 채널로 이동한다.
 * 채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 있다.
 * 수빈이가 지금 이동하려고 하는 채널은 N이다.
 * 어떤 버튼이 고장났는지 주어졌을 때, 채널 N으로 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지 구하는 프로그램을 작성하시오.
 * 수빈이가 지금 보고 있는 채널은 100번이다.
 * 첫째 줄에 수빈이가 이동하려고 하는 채널 N (0 ≤ N ≤ 500,000)
 * 둘째 줄에는 고장난 버튼의 개수 M (0 ≤ M ≤ 10)
 * 고장난 버튼이 있는 경우에는 셋째 줄에는 고장난 버튼
 * <p>
 * [sample]
 * 5457
 * 3
 * 6 7 8
 * answer : 6
 */
public class Algorithm1107 {

    static boolean[] broken = new boolean[10]; // 10개 버튼, 고장난 것은 true

    // 이동할 채널에 부서진 버튼이 있는지 확인
    // 0이 반환되는 경우는 해당 채널로 이동이 불가능한 경우
    // 부서진게 없으면 버튼 누르는 횟수 반환
    static int possible(int ch) {
        if (ch == 0) {
            if (broken[0]) {
                return 0;
            } else {
                return 1;
            }
        }

        int len = 0;
        while (ch > 0) {
            if (broken[ch % 10]) {
                // 가장 낮은 자리수의 broken을 찾는다.
                return 0;
            }
            len += 1;
            ch /= 10; // 1자리수부터 10자리, 100자리...
        }
        return len;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int chWant = sc.nextInt();
        int brokenCount = sc.nextInt();

        for (int i = 0; i < brokenCount; i++) {
            int brokenNum = sc.nextInt();
            broken[brokenNum] = true;
        }

        // 초기 100에서 숫자버튼 없이 +-버튼을 누르는 것이 나은 경우를 위해
        int result = chWant - 100;
        if (result < 0) {
            result = -result;
        }

        // 정답의 최대값 500000 - 100(지금 보고 있는 채널)
        // 이동하려는 채널 최대값(풀이의 N) + 위 최대값 = 거의 100만 (도달 전 이동해야하는 채널의 최대값)
        for (int i = 0; i < 500000 * 2; i++) {
            int ch = i; // 이동할 채널
            int len = possible(ch);
            if (len > 0) {
                int press = ch - chWant;
                if (press < 0) {
                    press = -press;
                }

                if (result > press + len) {
                    result = press + len;
                }
            }
        }

        System.out.println(result);
    }
}
