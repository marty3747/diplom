package com.demo.diplom.persons

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.demo.diplom.Person
import com.demo.diplom.R
import com.demo.diplom.persons.presentation.PersonsPresenter
import com.demo.diplom.persons.presentation.PersonsView
import com.demo.diplom.ui.AddUpdateFragment
import com.demo.diplom.ui.PersonDetails
import kotlinx.android.synthetic.main.fragment_persons.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PersonsFragment : MvpAppCompatFragment(R.layout.fragment_persons), PersonsView {

    private val presenter: PersonsPresenter by moxyPresenter {
        PersonsPresenter()
    }

    private var personsAdapter: PersonsAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(rvPersons) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = PersonsAdapter(onPersonClick = { person ->
                presenter.onPersonClick(person)
            }).also {
                personsAdapter = it
            }
        }

        addRecordBtn.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .replace(R.id.container, AddUpdateFragment(presenter))
                .addToBackStack("AddUpdateFragment")
                .commit()
        }

        /*arguments?.let {
            val person = it.getParcelable<Person>(PERSON)

            tv2.text = "Имя человека: ${person?.name}"
        }*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        personsAdapter = null
    }

    override fun setPersons(persons: List<Person>) {
        personsAdapter?.setData(persons)
    }

    override fun openPersonDetail(person: Person) {
        requireFragmentManager().beginTransaction()
            .replace(R.id.container, PersonDetails.newInstance(person))
            .addToBackStack("PersonDetails")
            .commit()
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
