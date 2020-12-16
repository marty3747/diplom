package com.demo.diplom

import android.os.Parcelable
import android.provider.ContactsContract
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person(
    val name: String,
    val surname: String,
    val age: Int,
    val phone: Int,
    val email:String,
    val descr: String):Parcelable {


    operator fun compareTo(person: Person): Int {
        return this.age - person.age
    }
}