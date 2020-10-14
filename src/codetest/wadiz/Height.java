package codetest.wadiz;

import java.util.Arrays;

/**
 * Created by Jongkook on 2020/09/17.
 * 문제 출처 : n명의 사람이 일렬로 서있습니다.
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class Height {
    public static void main(String[] args) {
        int[] arr = {20, 8, 10, 1, 4, 15};
        System.out.println(solution(arr));
    }

    static int result;
    static int[] tArr;
    static boolean[] used;

    public static int solution(int[] v) {
        tArr = new int[v.length]; // 제공된 배열의 원소를 임시로 저장할 배열
        used = new boolean[v.length]; // 제공된 배열의 수를 사용했는지 확인하기 위함

        Arrays.sort(v);
        result = 0;
        solve(v, 0);

        return result;
    }

    private static void solve(int[] v, int count) {
        if (count == v.length) {
            int sum = 0;
            for (int i = 0; i < v.length - 1; i++) {
                // 차이들의 합 구하기
                sum += Math.abs(tArr[i] - tArr[i + 1]);
            }
            // 기존의 결과와 비교 후 큰 값만 저장
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < v.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            tArr[count] = v[i];
            solve(v, count + 1); // 재귀
            used[i] = false;
        }
    }
}
