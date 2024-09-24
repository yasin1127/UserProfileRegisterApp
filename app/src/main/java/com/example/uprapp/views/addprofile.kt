package com.example.uprapp.views

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.uprapp.R
import com.example.uprapp.model.UP
import com.example.uprapp.viewmodel.VM

class addprofile : AppCompatActivity() {
    private lateinit var profileViewModel:ViewModel

    private lateinit var nameTxt:EditText
    private lateinit var emailTxt:EditText
    private lateinit var dobTxt:EditText
    private lateinit var districtTxt:EditText
    private lateinit var mobileTxt:EditText
    private lateinit var save:Button
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addprofile)

        profileViewModel= ViewModelProvider(this).get(VM::class.java)

        nameTxt=findViewById(R.id.net)
        emailTxt=findViewById(R.id.eet)
        dobTxt=findViewById(R.id.det)
        districtTxt=findViewById(R.id.diet)
        mobileTxt=findViewById(R.id.met)


        save=findViewById(R.id.addbtn)

        save.setOnClickListener {
            val name=nameTxt.text.toString().trim()
            val email=emailTxt.text.toString().trim()
            val dob=dobTxt.text.toString().trim()
            val district=districtTxt.text.toString().trim()
            val mobile=mobileTxt.text.toString().trim()

           val userProfile= UP(name = name, email = email, dob=dob, dist=district, mobile= mobile)
            (profileViewModel as VM).insertUserProfile(userProfile)
            finish()

        }

    }
}