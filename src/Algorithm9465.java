import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 스티커
 * 문제 : https://www.acmicpc.net/problem/9465
 * 풀이 : https://www.acmicpc.net/source/share/67eeb5961a20490db92bee8b569af74d
 * <p>
 * 2n개의 스티커 중에서 점수의 합이 최대가 되면서 서로 변을 공유 하지 않는 스티커 집합을 구해야 한다.
 */
public class Algorithm9465 {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // 스티커 세트 갯수
        int count = Integer.valueOf(reader.readLine());

        while (count-- > 0) {
            // 스티커 세트 : 2n개
            int n = Integer.valueOf(reader.readLine());
            int[][] sticker = new int[n+1][2];

            String[] firstLine = reader.readLine().split(" ");
            for (int i = 1; i <= n; i++) {
                sticker[i][0] = Integer.valueOf(firstLine[i-1]);
            }

            String[] secondLine = reader.readLine().split(" ");
            for (int i = 1; i <= n; i++) {
                sticker[i][1] = Integer.valueOf(secondLine[i-1]);
            }

            int[][] d = new int[n+1][3];
            for (int i = 1; i <= n; i++) {
                // 뜯지 않음
                d[i][0] = Math.max(d[i-1][0], Math.max(d[i-1][1], d[i-1][2]));
                // 위의 스티커, sticker[i][0]
                d[i][1] = Math.max(d[i-1][0], d[i-1][2]) + sticker[i][0];
                // 아래의 스티커, sticker[i][1]
                d[i][2] = Math.max(d[i-1][0], d[i-1][1]) + sticker[i][1];
            }

            int result = 0;
            result = Math.max(d[n][0], Math.max(d[n][1], d[n][2]));
            System.out.println(result);
        }
    }
}
