package baekjoon.part2_03_permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 로또
 * 문제 : https://www.acmicpc.net/problem/6603
 * 풀이 : https://www.acmicpc.net/source/share/ad4f81f0566c443895c02be939d0b09d
 * 독일 로또는 {1, 2, ..., 49}에서 수 6개를 고른다.
 * 로또 번호를 선택하는데 사용되는 가장 유명한 전략은 49가지 수 중 k(k>6)개의 수를 골라
 * 집합 S를 만든 다음 그 수만 가지고 번호를 선택하는 것이다.
 * <p>
 * n개 수는 집합 S에 포함되는 수이다. S의 원소는 오름차순으로 주어진다.
 * 입력의 마지막 줄에는 0이 하나 주어진다.
 */
public class Algorithm6603 {

    static boolean nextPermutation(int[] p) {
        int i = p.length - 1; // 마지막 위치 찾기 위함

        while (i > 0 && p[i] <= p[i - 1]) {
            i -= 1;
        }

        if (i <= 0) {
            // 현시점이 마지막 숫자
            return false;
        }

        int j = p.length - 1; // 마지막 위치 찾기 위함

        // 순열의 마지막 수에서 끝나는 가장 긴 감소수열을 찾아야 한다
        // p[i - 1] == p[2] == 3
        while (p[j] <= p[i - 1]) {
            j -= 1;
        }

        int temp = p[j];
        p[j] = p[i - 1];
        p[i - 1] = temp; // 7 2 4 6 5 3 1

        j = p.length - 1; // 마지막 위치 찾기 위함, j == 6

        // 한 단위의 마지막 순열을 첫번째 순열로 변경
        // 6 5 3 1 --> 1 3 5 6
        while (i < j) {
            temp = p[i];
            p[i] = p[j];
            p[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == 0) break; // 입력의 마지막 줄에는 0이 하나 주어진다.

            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                // 집합 S의 원소
                p[i] = sc.nextInt();
            }

            int[] d = new int[n];
            // 6개만 숫자 1이 선택됨
            for (int i = 0; i < n; i++) {
                if (i < n - 6) d[i] = 0;
                else d[i] = 1;
            }

            ArrayList<ArrayList<Integer>> result = new ArrayList<>();

            do {
                ArrayList<Integer> cur = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if (d[i] == 1) cur.add(p[i]);
                }
                result.add(cur);
            } while (nextPermutation(d));

            System.out.println("* * * * ***");
            // result의 모든 항목을 서로 비교 후 오름차순으로 정렬하기 위한 코드
            Collections.sort(result, new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> integers, ArrayList<Integer> t1) {
                    int n = integers.size();
                    int m = t1.size();
                    int i = 0;

                    System.out.println("* * * n " + n);
                    System.out.println("* * * m " + m);

                    while (i < n && i < m) {
                        int h1 = integers.get(i);
                        int h2 = t1.get(i);
                        if (h1 < h2) return -1;
                        System.out.println("* * * * i " + i);
                        i += 1;
                    }

                    if (i == n && i != m) return -1;
                    else if (i != n && i == m) return 1;
                    return 0;
                }
            });

            for (ArrayList<Integer> list : result) {
                for (int x : list) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
