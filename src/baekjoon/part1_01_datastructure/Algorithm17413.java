package baekjoon.part1_01_datastructure;

import java.io.*;
import java.util.Stack;

/**
 * 단어 뒤집기
 * 문제 : https://www.acmicpc.net/problem/17413
 * 풀이 : https://www.acmicpc.net/source/share/e20b24a34c18425ebccf8c59978c734e
 */
public class Algorithm17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean isTag = false;
        Stack<Character> stack = new Stack<>();

        for (char chr : text.toCharArray()) {
            if (chr == '<') {
                // '<' 앞의 텍스트 출력
                printText(writer, stack);
                isTag = true;
                writer.write(chr);
            } else if (chr == '>') {
                writer.write(chr);
                isTag = false;
            } else if (isTag) {
                // '<'와 '>' 사이의 텍스트 출력
                writer.write(chr);
            } else {
                if (chr == ' ') {
                    // 스택에 쌓인 텍스트 출력
                    printText(writer, stack);
                    writer.write(chr);
                } else {
                    stack.push(chr);
                }
            }
        }

        printText(writer, stack); // 태그 뒤에 텍스트가 남은 경우
        writer.write("\n");
        writer.flush();
    }

    static void printText(BufferedWriter writer, Stack<Character> stack) throws IOException {
        while (!stack.isEmpty()) {
            writer.write(stack.pop());
        }
    }
}
