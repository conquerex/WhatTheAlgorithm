package study.week29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by Jongkook on 2020/12/09.
 * 문제 출처 :
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class week29_07568 {

    static class Human {
        int index;
        int height, weight;
        int rank;

        public Human(int index, int weight, int height) {
            this.index = index;
            this.weight = weight;
            this.height = height;
        }

        public int getHeight() {
            return height;
        }

        public int getWeight() {
            return weight;
        }

        public int getIndex() {
            return index;
        }
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(br.readLine());
            ArrayList<Human> list = new ArrayList<>();

            for (int i = 0; i < count; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int weight = Integer.parseInt(st.nextToken());
                int height = Integer.parseInt(st.nextToken());
                list.add(new Human(i + 1, weight, height));
            }

            list.sort(Comparator.comparing(Human::getWeight).thenComparing(Human::getHeight).reversed());

//            System.out.println(">>>> " + 0);
//            System.out.println(list.get(0).weight);
//            System.out.println(list.get(0).height);
            list.get(0).rank = 1;
            for (int i = 1; i < count; i++) {
//                System.out.println(">>>> " + i);
//                System.out.println(list.get(i).weight);
//                System.out.println(list.get(i).height);
                if (list.get(i - 1).height > list.get(i).height) {
                    list.get(i).rank = i + 1;
                } else if (list.get(i - 1).height == list.get(i).height) {
                    if (list.get(i - 1).weight > list.get(i).weight) {
                        list.get(i).rank = i + 1;
                    } else {
                        list.get(i).rank = list.get(i - 1).rank; // 두 값이 같은 경우
                    }
                } else {
                    list.get(i).rank = list.get(i - 1).rank;
                }
            }

            list.sort(Comparator.comparing(Human::getIndex));
            for (int i = 0; i < count; i++) {
                System.out.print(list.get(i).rank + "");
                if (i != count - 1) {
                    System.out.print(" ");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
