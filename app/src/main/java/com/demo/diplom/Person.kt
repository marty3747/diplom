package com.demo.diplom

import android.provider.ContactsContract
import java.io.Serializable

data class Person(
    val name: String,
    val surname: String,
    val age: Int,
    val phone: Int,
    val email:String,
    val descr: String):Serializable {
    operator fun compareTo(person: Person): Int {
        return this.age - person.age
    }
}