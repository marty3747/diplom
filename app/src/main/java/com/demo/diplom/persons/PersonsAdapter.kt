package com.demo.diplom.persons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demo.diplom.Person
import com.demo.diplom.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.persons_item.*

class PersonsAdapter: RecyclerView.Adapter<PersonsAdapter.ViewHolder>() {

    private var persons: MutableList<Person> = mutableListOf()

    fun setData(persons: List<Person>) {
        this.persons.clear()
        this.persons.addAll(persons)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.persons_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = persons[position]
        holder.nameOfPerson.text = item.name
        holder.surnameOfPerson.text = item.surname
    }

    override fun getItemCount(): Int = persons.size

    class ViewHolder(override val containerView: View):RecyclerView.ViewHolder(containerView), LayoutContainer

}