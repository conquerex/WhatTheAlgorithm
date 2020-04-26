package baekjoon.part2_01_bruteforce;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 일곱 난쟁이
 * 문제 : https://www.acmicpc.net/problem/2309
 * 풀이 : https://www.acmicpc.net/source/share/4d5ea4a198e0451cb6c6432825a24b34
 */
public class Algorithm2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 9; // 총 난쟁이 숫자
        int[] height = new int[count]; // 키 세팅
        int sum = 0;

        for (int i = 0; i < count; i++) {
            height[i] = sc.nextInt();
            sum += height[i]; // 모든 난쟁이의 키를 더한 값
        }

        Arrays.sort(height);

        for (int i = 0; i < count; i++) {
            for (int j = i+1; j < count; j++) {
                if (sum - height[i] - height[j] <= 100) {
                    for (int k = 0; k < count; k++) {
                        if (k == i || k == j) continue; // 해당 조건은 제외된다.
                        System.out.println(height[k]);
                    }
                    System.exit(0);
                }
            }
        }
    }
}
