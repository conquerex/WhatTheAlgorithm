package challenges;

/**
 * @author Jongkook
 * @date : 06/06/2020
 */

public class Challenges1 {
    public static void main(String[] args) {
//        String[] moves = {"U", "U", "R", "D", "L", "L", "L", "U", "R", "D", "D", "D", "L", "U", "R", "R", "R", "D", "L", "U"};
        String[] moves = {"U", "R", "D", "L"};
        System.out.println(solution(moves));
    }

    public static int solution(String[] moves) {
        int answer = 0;
        final int[] dy = {1, -1, 0, 0};
        final int[] dx = {0, 0, 1, -1};
        final int mapMin = 0;

        int x = 1000; // center
        int y = 1000; // center
        int[][] map = new int[2001][2001];
        map[x][y] = 1;

        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (moves[i].equals("U")) {
                    x += 1;
                } else if (moves[i].equals("D")) {
                    x -= 1;
                } else if (moves[i].equals("L")) {
                    y -= 1;
                } else {
                    y += 1;
                }
                map[x][y] = 1;
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[j][i] == 0) {
                    boolean check = true;
                    for (int k = 0; k < dx.length; k++) {
                        int mx = i + dx[k];
                        int my = j + dy[k];

                        if (mx < mapMin || my < mapMin || mx >= map.length || my >= map.length) {
                            check = false;
                            break;
                        }

                        if (map[my][mx] != 1) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

}
