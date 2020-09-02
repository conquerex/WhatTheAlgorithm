package programmers.pr4dfsbfs;

public class Solution43163 {

    static boolean[] check;
    static String text;
    static int result = 0;

    static public int solution(String begin, String target, String[] words) {
        boolean pass = false;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                pass = true;
            }
        }

        if (!pass) {
            return 0;
        }

        int answer = 0;
        check = new boolean[words.length];
        text = begin;

        while (!text.equals(target)) {
            notBfs(target, words);
        }

        answer = result;
        return answer;
    }

    static public boolean compareWords(String word, String target) {
        int changeCount = 0;
        for (int i = 0; i < target.length(); i++) {
            if (word.charAt(i) != target.charAt(i)) {
                changeCount += 1;
            }
        }

        if (changeCount == 1) {
            return true;
        } else {
            return false;
        }
    }

    static public void notBfs(String target, String[] words) {
        if (compareWords(text, target)) {
            result += 1;
            text = target;
            return;
        }

        for (int m = 0; m < words.length; m++) {
            if (check[m] == false && compareWords(text, words[m])) {
                text = words[m];
                check[m] = true;
                result += 1;
                break;
            }
        }
    }

    public static void main(String[] args) {
        String words[] = {"hot", "dot", "dog", "lot", "log", "cog"};
        String begin = "hit";
        String target = "cog";
        System.out.println(solution(begin, target, words));
    }
}
