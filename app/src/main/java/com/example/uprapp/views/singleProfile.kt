package com.example.uprapp.views

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.uprapp.R
import com.example.uprapp.model.UP
import com.example.uprapp.viewmodel.VM

class singleProfile : AppCompatActivity() {
    private lateinit var userProfile:UP
    private lateinit var nameTxt:TextView
    private lateinit var emailTxt:TextView
    private lateinit var dobTxt:TextView
    private lateinit var districtTxt:TextView
    private lateinit var mobileTxt:TextView
    private lateinit var updateBtn:ImageButton
    private lateinit var deleteBtn:ImageButton

    private lateinit var profileViewModel:VM


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_profile)

profileViewModel=ViewModelProvider(this).get(VM::class.java)

        userProfile= intent.getSerializableExtra("User_Profile") as UP

        nameTxt=findViewById(R.id.name)
        emailTxt=findViewById(R.id.email)
        dobTxt=findViewById(R.id.dob)
        districtTxt=findViewById(R.id.dis)
        mobileTxt=findViewById(R.id.mob)
        updateBtn=findViewById(R.id.ebtn)
        deleteBtn=findViewById(R.id.dbtn)

        updateBtn.setOnClickListener {
            val intent= (Intent(this,updateprofile::class.java).apply {
                putExtra("User_Profile",userProfile)
                startActivity(intent)
            })
        }

        deleteBtn.setOnClickListener {
            profileViewModel.deletetUserProfile(userProfile)
            finish()
        }
        populatedFields()

    }

    private fun populatedFields() {
        nameTxt.text=userProfile.name
        emailTxt.text=userProfile.email
        dobTxt.text=userProfile.dob
        districtTxt.text=userProfile.dist
        mobileTxt.text=userProfile.mobile
    }
}