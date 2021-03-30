package com.demo.diplom.persons.presentation

import com.demo.diplom.Person
import moxy.MvpPresenter
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

class PersonsPresenter: MvpPresenter<PersonsView>() {
    val persons: MutableList<Person> = mutableListOf<Person>(
        Person("Nikita", "Filippov", 22, 222222, "@gmail.com", "Very hot guy"),
        Person("Danilya", "Radchenko", 22, 111111, "@gmail.com", "Very guy"),
        Person("Dmitriy", "Shinkarevskiy", 25, 111111, "@gmail.com", "Very"),
    )

    fun viewPersons(
        name: String,
        surname: String,
        age: Int,
        phone: Int,
        email:String,
        descr: String) {
        this.persons.add(Person(name, surname, age, phone, email, descr))
        viewState.setPersons(persons)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setPersons(persons)
    }

    fun onPersonClick(person: Person) {
        viewState.openPersonDetail(person)
    }
}

interface PersonsView:MvpView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setPersons(persons: List<Person>)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun openPersonDetail(person: Person) {

    }
}