package com.demo.diplom.persons.presentation

import com.demo.diplom.Person
import moxy.MvpPresenter
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

class PersonsPresenter: MvpPresenter<PersonsView>() {
    private val persons: List<Person> = listOf<Person>(
        Person("Nikita", "Filippov", 22, 222222, "@gmail.com", "Very hot guy"),
        Person("Danilya", "Radchenko", 22, 111111, "@gmail.com", "Very guy"),
        Person("Dmitriy", "Shinkarevskiy", 25, 111111, "@gmail.com", "Very"),
    )

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setPersons(persons)
    }
}

interface PersonsView:MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setPersons(persons: List<Person>)

}