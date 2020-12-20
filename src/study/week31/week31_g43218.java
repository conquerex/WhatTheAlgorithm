package study.week31;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            Boolean isStatus = false;

            int count = 0;
            String temp = "";
            Boolean isPop = false;
            int ppCount = 0; // push & pop count 값
            String[] stdInArr = new String[count];
            int totalCount = Integer.parseInt(br.readLine());

            while (!isStatus) {
                String input = br.readLine();
                if (count > 10) {
                    System.out.print("overflow");
                    break;
                }

                if (count % 2 == 0) {
                    // >>>>> push & pop 입력 <<<<<
                    temp = input;

                    if (input.equals("1")) {
                        // case : POP
                        isPop = true;

                        if (ppCount == 0) {
                            //무조건 첫번째면 underflow
                            System.out.println("underflow");
                        } else {
                            ppCount--;
                            if (stdInArr[ppCount] == null) {
                                System.out.println("underflow");
                            } else {
                                stdInArr[ppCount] = null;
                            }
                        }
                        break; // 푸시인 경우에만 자료의 내용을 다음 줄에 입력합니다.
                    }
                } else {
                    // >>>>> push & pop 실행 <<<<<
                    if (temp.equals("0")) { // push
                        stdInArr[ppCount] = input;
                        ppCount++;
                    } else if (temp.equals("1")) { // pop
                        //
                    } else {
                        return; //0 or 1이 아닌 다른값이면 시스템 종료
                    }

                    temp = ""; //초기화
                }

                count++;

                if (count == totalCount * 2) {
                    isStatus = true;
                }
            }

            String str = "";
            if (!isPop) {
                //
            } else {
                //
            }

            System.out.print(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
