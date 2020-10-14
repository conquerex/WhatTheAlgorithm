package codetest.wadiz;

import java.util.StringTokenizer;

/**
 * @author Jongkook
 * @date : 2020/09/17
 */

public class RankingPage2 {
    public static void main(String[] args) {
        String[] arr = {"alex111 100", "cheries2 200", "coco 150", "luna 100", "alex111 120", "coco 300", "cheries2 110"};
        System.out.println(">>>>>> " + solution(3, arr));
    }

    static class User {
        String name;
        int score;

        User(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public static int solution(int K, String[] user_scores) {
        int answer = 0;
        User[] top = new User[K];

        for (int i = 0; i < K; i++) {
            top[i] = new User("", 0);
        }

        for (String user_score : user_scores) {
            StringTokenizer st = new StringTokenizer(user_score);
            User user = new User(st.nextToken(), Integer.parseInt(st.nextToken()));

            for (int j = 0; j < K; j++) {
                if (top[j].score < user.score) {
                    if (!top[j].name.equals(user.name)) {
                        for (int z = K - 1; z > j; z--) {
                            top[z] = top[z - 1];
                        }
                        answer++;
                    }
                    top[j] = user;
                    break;
                } else if (top[j].name.equals(user.name)) {
                    break;
                }
            }
        }
        return answer;
    }
}
