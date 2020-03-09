package part1;

import java.util.Scanner;

/**
 * 연속합 2
 * 문제 : https://www.acmicpc.net/problem/13398
 * 풀이 : https://www.acmicpc.net/source/share/2b8d4fb11a5b4d4193ea76a51550e4cd
 * n개의 정수로 이루어진 임의의 수열이 주어진다.
 * 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다.
 * 단, 수는 한 개 이상 선택해야 한다. 또, 수열에서 수를 하나 제거할 수 있다. (제거하지 않아도 된다)
 *
 * [sample]
 * 10
 * 10 -4 3 1 5 6 -35 12 21 -1
 * answer : 54
 */
public class Algorithm13398 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] list = new int[n];
        int[] dLeft = new int[n];
        int[] dRight = new int[n];

        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }

        /**
         * "가장 긴 바이토닉 부분 수열"의 확장 버전
         * 이 문제에서 개별 숫자 크기 순서는 관계 없음
         */

        // 왼쪽에서 연속합 구하기
        for (int i = 0; i < n; i++) {
            dLeft[i] = list[i];
            if (i > 0 && dLeft[i] < dLeft[i-1] + list[i]) {
                dLeft[i] = dLeft[i-1] + list[i];
            }
        }

        // 오른쪽에서 연속합 구하기
        for (int i = n-1; i >= 0; i--) {
            dRight[i] = list[i];
            if (i < n-1 && dRight[i] < dRight[i+1] + list[i]) {
                dRight[i] = dRight[i+1] + list[i];
            }
        }

        int result = dLeft[0];
        for (int i = 1; i < n; i++) {
            if (result < dLeft[i]) {
                result = dLeft[i];
            }
        }

        // 양끝이 제외되는 경우는 수열 가운데에 숫자가 제외되지 않는 경우이다.
        for (int i = 1; i < n-1; i++) {
            if (result < dLeft[i-1] + dRight[i+1]) {
                result = dLeft[i-1] + dRight[i+1];
            }
        }

        System.out.println(result);
    }
}
