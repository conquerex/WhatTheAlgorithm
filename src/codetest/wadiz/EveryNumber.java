package codetest.wadiz;

import java.util.Arrays;

/**
 * Created by Jongkook on 2020/09/17.
 * 문제 출처 : 길이가 n인 배열에 1부터 n까지 숫자가 중복 없이 한 번씩 들어 있는지를 확인하려고 합니다.
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class EveryNumber {

    public static void main(String[] args) {
        int[] array = {4, 1, 3, 2};
        System.out.println(solution(array));
    }

    public static boolean solution(int[] arr) {
        boolean answer = true;

        Arrays.sort(arr); // 숫자를 오름차순으로
        for (int i = 0; i < arr.length; i++) {
            // 나열된 숫자가 인덱스 + 1과 같은지 비교
            if (arr[i] == i + 1) {
                continue;
            } else {
                answer = false;
                break;
            }
        }

        return answer;
    }
}
