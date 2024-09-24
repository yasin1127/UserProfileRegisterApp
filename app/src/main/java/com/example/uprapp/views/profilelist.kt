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

class profilelist : AppCompatActivity() {
    private lateinit var viewModel: VM
    private lateinit var adapter: ProfileAdapter
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profilelist)
        viewModel= ViewModelProvider(this).get(VM::class.java)

        val recyclerView= findViewById<RecyclerView>(R.id.recyclerView)
        adapter= ProfileAdapter()

        recyclerView.adapter=adapter
        recyclerView.layoutManager=LinearLayoutManager(this)

        viewModel.getUserProfiles().observe(this, Observer{
            adapter.submitList(it)
        })

        adapter.setOnItemClickListener {
            val intent = Intent(this, singleProfile::class.java)
            intent.putExtra("UP_ID", it)
            startActivity(intent)
            adapter.setOnEditClickListener {
                val intent = Intent(this, singleProfile::class.java)
                intent.putExtra("UP_ID",it)
                startActivity(intent)
            }
            adapter.setOnDeleteClickListener {
                viewModel.deletetUserProfile(it)
            }
            findViewById<FloatingActionButton>(R.id.addBtn).setOnClickListener {
                startActivity(Intent(this, addprofile::class.java))

            }
        }

    }
}