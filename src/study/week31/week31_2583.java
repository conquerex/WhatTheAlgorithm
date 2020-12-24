package study.week31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Jongkook on 2020/12/24.
 * 문제 출처 :https://www.acmicpc.net/problem/2583
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class week31_2583 {

    public static boolean[][] visited;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 세로 길이
            int n = Integer.parseInt(st.nextToken()); // 가로 길이
            int k = Integer.parseInt(st.nextToken()); // 사각형 개수

            visited = new boolean[m][n];


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // lb : left bottom
    // rt : right top
    public static void checkSqure(int lbX, int lbY, int rtX, int rtY) {
        //
    }
}
