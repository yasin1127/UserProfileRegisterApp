package com.example.uprapp.views

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.uprapp.R
import com.example.uprapp.model.UP
import com.example.uprapp.viewmodel.VM

class updateprofile : AppCompatActivity() {
    private lateinit var profileViewModel:VM
    private lateinit var userProfile: UP

    private lateinit var nameEt: EditText
    private lateinit var emailEt: EditText
    private lateinit var dobEt: EditText
    private lateinit var districtEt: EditText
    private lateinit var mobileEt: EditText
    private lateinit var updateBtn: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_updateprofile)

        profileViewModel=ViewModelProvider(this).get(VM::class.java)
        userProfile=intent.getSerializableExtra("User_Profile") as UP

        nameEt=findViewById(R.id.net)
        emailEt=findViewById(R.id.eet)
        dobEt=findViewById(R.id.det)
        districtEt=findViewById(R.id.diet)
        mobileEt=findViewById(R.id.met)

        updateBtn=findViewById(R.id.upbtn)

        populatedFields()

        updateBtn.setOnClickListener{
            updateUserProfile()
        }
    }

    private fun updateUserProfile() {
        val name=nameEt.text.toString().trim()
        val email=emailEt.text.toString().trim()
        val dob=dobEt.text.toString().trim()
        val district=districtEt.text.toString().trim()
        val mobile=mobileEt.text.toString().trim()

        val userProfile= UP(id =userProfile.id, name = name, email = email, dob=dob, dist=district, mobile= mobile)
        profileViewModel.updateUserProfile(userProfile)
        finish()
    }

    private fun populatedFields() {
        nameEt.setText(userProfile.name)
        emailEt.setText(userProfile.email)
        dobEt.setText(userProfile.dob)
        districtEt.setText(userProfile.dist)
        mobileEt.setText(userProfile.mobile)
}}