package com.example.kotlinfrequencyanalyzer

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private fun frequency_analyzer(str: String) : HashMap<String, Int> {
        val words = str.split(" ");
        val hashMap : HashMap<String, Int>  = HashMap<String, Int> ();
        for (word in words) {
            if (hashMap.containsKey(word)) {
                hashMap[word] = hashMap.getValue(word) + 1;
            } else {
                hashMap[word] = 1;
            }
        }
        return hashMap;
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, frequency_analyzer("bik bik typo typology bichon"));
    }
}