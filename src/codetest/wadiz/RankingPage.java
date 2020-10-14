package codetest.wadiz;

import java.util.PriorityQueue;

/**
 * Created by Jongkook on 2020/09/17.
 * 유저가 달성한 점수(score)에 따라 실시간 랭킹을 보여주는 랭킹 페이지가 있습니다. 랭킹 페이지는 한 페이지에 K명씩 닉네임을 보여주며, 랭킹이 산정되는 규칙은 다음과 같습니다.
 *
 * 점수가 높은 유저의 랭킹이 더 높습니다.
 * 점수가 같다면 해당 점수를 먼저 달성한 유저의 랭킹이 높습니다.
 * 어떤 유저가 이전 기록보다 더 높은 점수를 달성하면, 이전 기록은 사라지고 새로운 기록이 랭킹에 반영됩니다.
 * 어떤 유저가 이전 기록보다 더 낮거나 같은 점수를 달성했다면 이 기록은 무시합니다.
 * 시즌이 바뀌면서 랭킹이 초기화되어 랭킹 페이지가 비어있는 상태가 됐습니다. 이때, 각 유저의 닉네임과 점수가 해당 점수를 달성한 순서대로 주어지면, 1페이지는 몇 번 바뀌는지 알아보려 합니다. 단, 랭킹 페이지에는 유저 닉네임만 표시되므로 점수 변화가 있더라도 랭킹에 변화가 없다면 랭킹 페이지는 바뀌지 않습니다.
 *
 * 한 페이지에 표시되는 닉네임 수 K, 유저의 닉네임과 점수가 달성 순서대로 들어있는 배열 user_scores가 매개변수로 주어질 때, 랭킹 1페이지는 몇 번 바뀌는지 return 하도록 solution 함수를 완성해주세요.
 *
 * [입출력 예]
 * K	user_scores	result
 * 3	["alex111 100", "cheries2 200", "coco 150", "luna 100", "alex111 120", "coco 300", "cheries2 110"]	4
 * 3	["alex111 100", "cheries2 200", "alex111 200", "cheries2 150", "coco 50", "coco 200"]	3
 * 2	["cheries2 200", "alex111 100", "coco 150", "puyo 120"]	3
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
