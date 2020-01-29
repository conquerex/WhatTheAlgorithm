import java.util.Scanner;

/**
 * 문제 : https://www.acmicpc.net/problem/1874
 * 소스 : http://codeplus.codes/4799b36eb5dd488ea4c291751e381da8
 */
public class Algorithm1874 {

    public static String isValid(String s) {
        return "";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n > 0) {
            System.out.println("* * *" + n);
            System.out.println(isValid(sc.next()));
            n -= 1;
        }
    }
}
