package codetest.klc;

/**
 * @author Jongkook
 * @date : 2020/09/07
 */

public class Village {
    public static void main(String[] args) {
        int n = 5;
        int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
        int k = 3;
        System.out.println(solution(n, road, k));
    }

    public static int solution(int N, int[][] road, int K) {
        int answer = 0;

        // 마을간 최단 거리
        int[][] map = new int[N][N];
        final int MAX = 500001;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                // i == j, 같은 마을이므로 거리가 0
                if (i == j) {
                    map[i][j] = 0;
                    continue;
                }
                map[i][j] = MAX; // 최단거리를 구하는 것이므로 최대값을 입력
            }
        }

        // 주어진 road 값으로 map 완성하기
        for (int i = 0; i < road.length; i++) {
            // 이미 map에 들어간 값이 더 작은 경우 continue
            if (map[road[i][0] - 1][road[i][1] - 1] < road[i][2]) continue;
            map[road[i][0] - 1][road[i][1] - 1] = road[i][2];
            map[road[i][1] - 1][road[i][0] - 1] = road[i][2];
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (j == k) continue;
                    // j에서 k 사이에 i가 있는 경우
                    if (map[j][k] > map[j][i] + map[i][k]) {
                        map[j][k] = map[j][i] + map[i][k]; // 더한 값이 더 작으면, 갱신
                    }
                }
            }
        }

        // map[0][i] : 1번 마
        for (int i = 0; i < map[0].length; i++) {
            if (map[0][i] <= K)
                answer++;
        }

        return answer;
    }
}
