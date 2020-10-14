package codetest.wadiz;

import java.util.Arrays;

/**
 * Created by Jongkook on 2020/09/17.
 * n명의 사람이 일렬로 서있습니다. 이때, 사람들이 서 있는 순서를 바꾸려고 합니다.
 * 맨 앞부터 1번째, 2번째, ... n번째 사람의 키가 주어지면,
 * |1번째 사람의 키 - 2번째 사람의 키| + |2번째 사람의 키 - 3번째 사람의 키| + ... + |n-1번째 사람의 키 - n번째 사람의 키| 의 값이 최대가 되도록 바꾸면 됩니다.
 * (|k|는 절댓값을 나타냅니다)
 * 사람들의 키가 들어있는 배열 v가 매개변수로 주어질 때, 위의 식을 만족하는 최댓값을 return 하도록 solution 함수를 완성해 주세요.
 *
 * [입출력 예]
 * v	answer
 * [20,8,10,1,4,15]	62
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
