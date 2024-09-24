package com.example.uprapp.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uprapp.R
import com.example.uprapp.adapter.ProfileAdapter
import com.example.uprapp.model.UP
import com.example.uprapp.viewmodel.VM
import com.google.android.material.floatingactionbutton.FloatingActionButton

class profilelistActivity : AppCompatActivity() {
    private lateinit var profileViewModel: VM
    private lateinit var profileAdapter: ProfileAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profilelist)
        profileViewModel= ViewModelProvider(this).get(VM::class.java)

        val recyclerView= findViewById<RecyclerView>(R.id.recyclerView)
        profileAdapter= ProfileAdapter()

        recyclerView.adapter=profileAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        profileViewModel.getUserProfiles().observe(this, Observer{
            profileAdapter.submitList(it)
        })

        profileAdapter.setOnItemClickListener {
            val intent = Intent(this, singleProfile::class.java)
            intent.putExtra("UP_ID", it)
            startActivity(intent)
        }

        profileAdapter.setOnEditClickListener {
            val intent = Intent(this, singleProfile::class.java)
            intent.putExtra("UP_ID", it)
            startActivity(intent)
        }
        profileAdapter.setOnDeleteClickListener {
            profileViewModel.deletetUserProfile(it)
        }

        findViewById<FloatingActionButton>(R.id.addBtn).setOnClickListener{
            startActivity(Intent(this,addprofile::class.java))
        }

    }
}