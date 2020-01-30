import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * (문제 이름)
 * 문제 : url
 * 풀이 : url
 */
public class Algorithm17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        int[] list = new int[size];
        int[] answer = new int[size];
        String[] temp = reader.readLine().split(" ");
        for (int i = 0; i < size; i++) {
            list[i] = Integer.parseInt(temp[i]);
        }

        Stack<Integer> position = new Stack<>();
        position.push(0);
        for (int i = 1; i < size; i++) {
            if (position.isEmpty()) {
                position.push(i);
            }

            while (!position.isEmpty() && list[position.peek()] < list[i]) {
                answer[position.pop()] = list[i];
            }

            position.push(i);
        }

        while (!position.empty()) {

        }
    }
}
