package com.demo.diplom

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEnd

@AddToEnd
interface PersonView: MvpView {
    fun showAgeError()
    fun showPhoneError()
}