package com.demo.diplom.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.demo.diplom.Person
import com.demo.diplom.PersonPresenter
import com.demo.diplom.PersonView

import com.demo.diplom.R
import kotlinx.android.synthetic.main.fragment_add_update.*

class AddUpdateFragment : Fragment(R.layout.fragment_add_update), PersonView {

    private val presenter = PersonPresenter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.attachView(this)

        initListeners()
        val person = Person ("fgfd", "dfgfdg", 34, 3434, "fdgfdg", "fdgfdg")
        saveBtn.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .replace(R.id.container, PersonsFragment.newInstance(person))
                .commit()
        }

        checkBtn.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .replace(R.id.container, AddUpdateFragment())
                .addToBackStack("AddUpdateFragment")
                .commit()
            }
    }
    private fun initListeners() {
        saveBtn.setOnClickListener {
            presenter.validate(
                nameEt.text.toString(),
                surnameEt.text.toString(),
                ageEt.text.toString(),
                phoneEt.text.toString(),
                emailEt.text.toString(),
                bioEt.text.toString()
            )
        }
    }

    override fun showAgeError() {
        showError("Возраст")
    }

    override fun showPhoneError() {
        showError("Телефон")
    }

    private fun showError(name: String) {
        Toast.makeText(requireContext(), "Ошибка в поле $name", Toast.LENGTH_SHORT).show()
    }

}