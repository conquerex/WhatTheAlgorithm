package study2020.week31;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Jongkook on 2020/12/20.
 * 문제 출처 :https://level.goorm.io/exam/43218/%EC%8A%A4%ED%83%9D-stack/quiz/1#
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class week31_g43218 {
    public static void main(String[] args) throws Exception {
        final String OVERFLOW = "overflow";
        final String UNDERFLOW = "underflow";
        final int MAX_SIZE = 10;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            ArrayList<Integer> stack = new ArrayList<>();

            // 입력횟수
            int maxCount = Integer.parseInt(br.readLine());

            for (int i = 0; i < maxCount; i++) {
                int operation = Integer.parseInt(br.readLine());
                if (operation == 0) {
                    // PUSH
                    int added = Integer.parseInt(br.readLine());
                    if (stack.size() >= MAX_SIZE) System.out.println(OVERFLOW);
                    else stack.add(added);
                } else if (operation == 1) {
                    // POP
                    if (stack.isEmpty()) System.out.println(UNDERFLOW);
                    else stack.remove(stack.size() - 1);
                } else {
                    break;
                }
            }

            for (int i : stack) {
                // 결과 출력
                System.out.print(i + " ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
