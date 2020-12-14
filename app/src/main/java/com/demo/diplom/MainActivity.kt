package com.demo.diplom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.ActionBar
import com.demo.diplom.ui.PersonsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = "TestActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager

        fragmentManager.beginTransaction()
            .add(R.id.container, PersonsFragment())
            .commit()


       /* addRecordBtn.setOnClickListener {
            val intent = Intent(this, AddUpdateRecordActivity::class.java)
            startActivity(intent)
        }
        val person1 = intent.extras?.getSerializable("person1") as Person
        val person2 = intent.extras?.getSerializable("person1")
        if (person1 != null) {
            tv1.text = "Имя человека1: ${person1.name}"

        }*/
    }
}
