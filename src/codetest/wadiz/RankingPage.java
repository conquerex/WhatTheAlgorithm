package codetest.wadiz;

import java.util.PriorityQueue;

/**
 * Created by Jongkook on 2020/09/17.
 * 문제 출처 : 유저가 달성한 점수(score)에 따라 실시간 랭킹을 보여주는 랭킹 페이지가 있습니다.
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class RankingPage {
    public static void main(String[] args) {
        String[] arr = {"alex111 100", "cheries2 200", "coco 150", "luna 100", "alex111 120", "coco 300", "cheries2 110"};
        System.out.println(">>>>>> " + solution(3, arr));
    }

    public static int solution(int K, String[] user_scores) {
        int answer = 0;

        PriorityQueue<Info> infos = new PriorityQueue<>();
        PriorityQueue<Info> temps = new PriorityQueue<>();

        for (int i = 0; i < user_scores.length; i++) {
            String[] user = user_scores[i].split(" ");
            if (infos.size() == K) {
                if (infos.peek().score < Integer.parseInt(user[1])) {
                    temps.poll();
                    temps.offer(new Info(user[0], Integer.parseInt(user[1])));
                    for (int j = 0; j < temps.size(); j++) {

                    }

                    infos.poll();
                    infos.offer(new Info(user[0], Integer.parseInt(user[1])));
                    answer++;
                } else {
                    System.out.println(">>>> " + infos.peek().score);
                    System.out.println(">>>> " + user[0]);
                }
            } else {
                infos.offer(new Info(user[0], Integer.parseInt(user[1])));
                temps.offer(new Info(user[0], Integer.parseInt(user[1])));
                answer++;
            }
        }



        return answer;
    }

    static class Info implements Comparable<Info> {

        String name;
        int score;

        public Info(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Info info) {
            return this.score <= info.score ? -1 : 1;
        }
    }
}
