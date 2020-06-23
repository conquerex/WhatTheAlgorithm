package devsisters;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;

/**
 * @author Jongkook
 * @date : 23/06/2020
 *
 * [입력 방법]
 * api 1 : 사람과 금액 입력
 * ex) 1 정우 6000
 * api 2 : 현재 리스트 조회
 * ex) 2
 * api 3 : 해당 사람이 보내야 할 금액
 * ex) 3 정우
 * api 4 : 전체 사람이 보내야 할 금액
 * ex) 4
 */

public class DebtSettlement {

    // 데이터를 HashMap에 저장
    public static HashMap<String, Integer> table;
    public static int sum = 0;
    public static int avg = 0;

    public static void main(String[] args) {
        table = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String[] arr = br.readLine().split(" ");
                Set<String> keys = table.keySet();

                // api 구분하는 부분
                switch (Integer.parseInt(arr[0])) {
                    case 1:
                        if (table.containsKey(arr[1])) {
                            sum -= table.get(arr[1]);
                        }
                        table.put(arr[1], Integer.parseInt(arr[2]));
                        sum += Integer.parseInt(arr[2]);
                        avg = sum / table.size();
                        break;
                    case 2:
                        for (String key : keys) {
                            System.out.println(key + " / " + table.get(key) + "원");
                        }
                        break;
                    case 3:
                        if (!table.containsKey(arr[1])) break;
                        int send = avg - table.get(arr[1]);
                        if (send > 0) {
                            for (String key : keys) {
                                if (table.get(key) > avg) {
                                    int get = table.get(key) - avg;
                                    System.out.println(key + "에게 " + minValue(send, get) + "원을 보내세요.");
                                }
                            }
                        } else {
                            System.out.println("보내야 할 돈이 없습니다.");
                        }
                        break;
                    case 4:
                        /**
                         * 아쉬운 부분 : 이중for문이 아닌 형태로 출력이 가능할지 고민이 필요
                         * 입력하면서 보내야 할 금액을 정산할 수 있는지.
                         */
                        for (String k : keys) {
                            int send2 = avg - table.get(k);
                            if (send2 > 0) {
                                for (String key : keys) {
                                    if (table.get(key) > avg) {
                                        int get = table.get(key) - avg;
                                        System.out.println(k + " -> "+ key + " / " + minValue(send2, get) + "원");
                                    }
                                }
                            }
                        }
                        break;
                }

                if (Integer.parseInt(arr[0]) < 1 || Integer.parseInt(arr[0]) > 4) {
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int minValue(int a, int b) {
        return a < b ? a : b;
    }
}
