package study2021.week17

import study2021.Sample2
import study2021.test

/**
 * Created by Jongkook on 2021/05/02.
 * 문제 출처 :
 *
 * Time Complexity :
 * Used Algorithm :
 * Used Data structure :
 */

fun main(args: Array<String>) {
    val sample = Sample2()
    sample.test()
    val leet = week17_leet1704()
    println(leet.halvesAreAlike("book"))
    println(leet.halvesAreAlike("textboo"))
    println(leet.halvesAreAlike("textbook"))
    println(leet.halvesAreAlike("MerryChristmas"))
    println(leet.halvesAreAlike("AbCdEfGh"))
}

class week17_leet1704 {
    fun halvesAreAlike(s: String): Boolean {
        val moumList = listOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        var cntLeft = 0
        var cntRight = 0

        if (s.length % 2 == 1) return false

        val charList = mutableListOf<Char>()
        for (i in s.indices) {
            charList.add(s.elementAt(i))
        }

        for (i in 0 until charList.size / 2) {
            if (moumList.contains(charList[i])) cntLeft++
        }

        for (i in charList.size / 2 until charList.size) {
            if (moumList.contains(charList[i])) cntRight++
        }

        return cntLeft == cntRight
    }
}