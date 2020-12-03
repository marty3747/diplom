package com.demo.diplom

data class Person(val name: String, val surname: String, val age: Int) {
    operator fun compareTo(person: Person): Int {
        return this.age - person.age
    }
}