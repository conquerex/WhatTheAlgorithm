package part2nm;

import java.util.Scanner;

/**
 * N과 M (4)
 * 문제 : https://www.acmicpc.net/problem/15652
 * 풀이 : https://www.acmicpc.net/source/share/78990bb707f640d9881fed5e9181acee
 * <p>
 *
 * 1부터 N까지 자연수 중에서 M개를 고른 수열을 모두 구하는 문제
 * (중복 선택 가능,비내림차순 == 오름차순)
 */
public class Algorithm15652 {

    static int[] result = new int[10];
    static boolean[] selected = new boolean[10];

    // index : 재귀함수를 쓰기 위해 인덱스를 받는다. 갯수별 배열을 만들기 위함
    // n : 1 ~ n
    // m : 위 숫자의 갯
    static StringBuilder move(int index, int n, int m) {
        // 4 2 --> m == 2
        if (index == m) {
            // 한 줄의 리스트
            // 4 2 --> 두번째 숫자 출력 후 개행
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < m; i++) {
                builder.append(result[i]);
                if (i != m-1) builder.append(" ");
            }
            builder.append("\n");
            return builder;
        }

        StringBuilder builder2 = new StringBuilder();

        // 4 2 --> 4번 반복
        for (int i = 1; i <= n ; i++) {
            // 중복을 없애고 싶다면 아래 주석을 풀면 된다.
//            if (selected[i]) continue;
            selected[i] = true;
            result[index] = i;
            // 재귀 구간
            builder2.append(move(index+1, n, m));
            selected[i] = false;
        }

        return builder2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.print(move(0, n, m));
    }
}
