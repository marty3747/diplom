package com.demo.diplom

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    val test = Person("Andrey", "Mironov", 23, 55523, "sdfk@mail.ru", "Very old")
    val test1 = Person("Tony", "Stark", 25, 55123, "adf@mail.ru", "Very small")
    val test2 = Person("Vito", "Scaletta", 27, 54523, "agb@mail.ru", "Very smile")
    val collection = mutableListOf(test1,test,test2);


    @Test
    fun addition_isCorrect() {
        print(collection.sort())
    }

    fun MutableList<Person>.sort():MutableList<Person> {
        var swap = true
        var tmp: Person
        while(swap) {
            swap = false
            for (i in 0 until size - 2) {
                if (this[i] > this[i+1]) {
                    tmp = this[i]
                    this[i] = this[i+1]
                    this[i+1] = tmp;
                    swap = true
                }
            }
        }
        return this
    }
}
