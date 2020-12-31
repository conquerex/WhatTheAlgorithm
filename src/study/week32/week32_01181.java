package study.week32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Jongkook on 2020/12/31.
 * 문제 출처 :
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class week32_01181 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            String[] list = new String[n];
            for (int i = 0; i < n; i++) {
                list[i] = br.readLine();
            }

            Comparator<String> comparator = (p1, p2) -> {
                if (p1.length() == p2.length()) {
                    return p1.compareTo(p2);
                } else {
                    return Integer.compare(p1.length(), p2.length());
                }
            };
            Arrays.stream(list)
                    .sorted(comparator)
                    .distinct()
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
