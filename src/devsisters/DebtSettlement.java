package devsisters;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;

/**
 * @author Jongkook
 * @date : 23/06/2020
 */

public class DebtSettlement {

    public static HashMap<String, Integer> table;
    public static int sum = 0;
    public static int avg = 0;

    public static void main(String[] args) {
        table = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String[] arr = br.readLine().split(" ");
                Set<String> keys = table.keySet();

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
