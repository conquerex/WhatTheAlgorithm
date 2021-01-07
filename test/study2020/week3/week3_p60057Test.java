package study2020.week3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jongkook on 11/06/2020.
 * 문제 출처 :
 * <p>
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

public class week3_p60057Test {

    private week3_p60057 instance =  new week3_p60057();

    @Test
    public void solution() {
        // given
        String text = "ababcdcdababcdcd";

        // when
        int expected = 9;
        int actual = instance.solution(text);

        // then
        assertEquals(expected, actual);
    }
}