package pr1hash;

/**
 * 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
 * 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를
 * 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
 * [119, 97674223, 1195524421]
 */
public class Solution42577 {
    public static void main(String[] args) {

        String[] book = {"119", "97674223", "1195524421"};

        System.out.println(solution(book));
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        for (int i = 0 ; i < phone_book.length ; i++) {
            for (int j = 0 ; j < phone_book.length ; j++) {
                if (phone_book[i] == phone_book[j]) continue;
                if (phone_book[i].length() >= phone_book[j].length()) continue;
                if (phone_book[i].equals(phone_book[j].substring(0,phone_book[i].length()))) {
                    return false;
                }
            }
        }

        return answer;
    }
}
