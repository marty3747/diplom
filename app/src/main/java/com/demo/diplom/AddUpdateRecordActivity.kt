package com.demo.diplom

import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.theartofdev.edmodo.cropper.CropImage
import com.theartofdev.edmodo.cropper.CropImageView
import java.util.jar.Manifest

/*class AddUpdateRecordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_update_record)
        saveBtn.setOnClickListener {
            val name = nameEt.text.toString()
            val surname = surnameEt.text.toString()
            val age = ageEt.text.toString().toInt()
            val phone = phoneEt.text.toString().toInt()
            val email = emailEt.text.toString()
            val descr = bioEt.text.toString()
            val person = Person(name, surname, age, phone, email, descr)
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("person1", person)
            startActivity(intent)
        }
    }
}*/



