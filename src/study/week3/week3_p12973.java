package study.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Jongkook on 04/06/2020.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12973
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class week3_p12973 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String text = br.readLine();
            System.out.println(solution(text));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static public int solution(String s) {
        ArrayList<Character> list = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }

        int start = s.length() - 2;
        int end = s.length() - 1;
        boolean flag = false;

        while (true) {
            if (start == 0) {
                if (list.size() == 0) {
                    break;
                }

                if (!flag) {
                    break;
                } else {
                    start = list.size() - 2;
                    end = list.size() - 1;
                    flag = false;
                }
            }

            if (list.get(start) == list.get(end)) {
                list.remove(end);
                list.remove(start);
                flag = true;
                if (start >= 2) {
                    start -= 2;
                    end -= 2;
                } else if (start == 1) {
                    start -= 1;
                    end -= 1;
                }
            } else {
                start -= 1;
                end -= 1;
            }
        }

        return list.size() > 0 ? 0 : 1;
    }
}
