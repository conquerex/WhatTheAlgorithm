import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 요세푸스 문제 (조세퍼스 문제)
 * 문제 : https://www.acmicpc.net/problem/1158
 * 풀이 : https://www.acmicpc.net/source/share/3c56720a0010405291c16011137b4e9c
 */
public class Algorithm1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Queue 사이즈
        int m = sc.nextInt(); // 간격
        StringBuilder builder = new StringBuilder();
        Queue<Integer> queue = new LinkedList();
        builder.append("<");
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                queue.offer(queue.poll());
            }
            builder.append(queue.poll() + ", ");
        }
        builder.append(queue.poll() + ">");
        System.out.println(builder);
    }
}
