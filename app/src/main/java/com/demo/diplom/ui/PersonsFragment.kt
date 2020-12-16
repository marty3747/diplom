package com.demo.diplom.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.demo.diplom.Person
import com.demo.diplom.R
import kotlinx.android.synthetic.main.fragment_persons.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PersonsFragment : Fragment(R.layout.fragment_persons) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addRecordBtn.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .replace(R.id.container, AddUpdateFragment())
                .addToBackStack("AddUpdateFragment")
                .commit()
        }

        arguments?.let {
            val person = it.getParcelable<Person>(PERSON)

            tv2.text = "Имя человека: ${person?.name}"
        }
    }

    companion object {

        private const val PERSON = "PERSON"

        fun newInstance(person: Person) =
            PersonsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(PERSON, person)
                }
            }
        }


    }
