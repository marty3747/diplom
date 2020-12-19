package com.demo.diplom

import android.widget.EditText
import moxy.MvpPresenter

class PersonPresenter: MvpPresenter<PersonView>() {
    fun validate(name: String, surname: String, age: String, phone: String, email: String, bio: String) {
        when {
            !ageIsCorrect(age) -> viewState.showAgeError()
            !phoneIsCorrect(phone) -> viewState.showPhoneError()
        }
    }

    private fun ageIsCorrect(ageText: String): Boolean {
        if (ageText.isEmpty()) return false

       return try {
            val age = ageText.toInt()
            age in 6..100
        } catch (e: Exception) {
            false
        }
    }

    private fun phoneIsCorrect(phoneText: String): Boolean {
        if(phoneText.isEmpty()) return false

        return try {
            val phone = phoneText.toInt()
            phone in 100000..999999
        } catch (e: Exception) {
            false
        }
    }

    /*
    private fun phoneIsCorrect(nameText: String): Boolean {
        if(nameText.isEmpty()) return false
    }*/

}