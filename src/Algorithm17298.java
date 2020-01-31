import java.io.*;
import java.util.Stack;

/**
 * 오큰수
 * 문제 : https://www.acmicpc.net/problem/17298
 * 풀이 : https://www.acmicpc.net/source/share/71cfbac1762c472da9d1bff4568a3611
 */
public class Algorithm17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        /**
         * 첫번째 입력
         */
        int size = Integer.parseInt(reader.readLine());
        int[] list = new int[size];     // 입력된 수열을 여기에 넣는다
        int[] answer = new int[size];   // 답 출력용
        /**
         * 두번째 입력
         */
        String[] temp = reader.readLine().split(" ");
        for (int i = 0; i < size; i++) {
            // 우선 수열을 만들고
            list[i] = Integer.parseInt(temp[i]);
        }

        Stack<Integer> position = new Stack<>(); // 수열 위치 입력용
        position.push(0); // 0번째 숫자를 먼저 확인한다.
        for (int i = 1; i < size; i++) { // 1번째 숫자부터 비교하면 되기때문에 i = 1
            if (position.isEmpty()) {
                position.push(i);
            }

            while (!position.isEmpty() && list[position.peek()] < list[i]) {
                // 1번째 숫자가 더 크면 0번째 정답리스트에 해당 숫자가 입력된다.
                answer[position.pop()] = list[i];
            }

            // 오큰수를 발견하지 못하면 스택에 다음 순번이 쌓인다.
            position.push(i);
        }

        while (!position.isEmpty()) {
            answer[position.pop()] = -1;
        }

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < size; i++) {
//            System.out.println("* * * * "+answer[i]);
            writer.write(answer[i] + " ");
//            writer.write(answer[i]); // BufferedWriter의 write (Writes a single character.)
        }
        writer.write("\n");
        writer.flush();
    }
}
