package com.example.uprapp.rep

import androidx.lifecycle.LiveData
import com.example.uprapp.dao.UPDao
import com.example.uprapp.model.UP
import com.example.uprapp.views.profilelist
import com.example.uprapp.views.updateprofile

class UPR (private val uPD:UPDao){
    fun getUP():LiveData<List<updateprofile>>{
        return uPD.getallprofile()
    }
    suspend fun insert(up: UP){
        return uPD.insert(up)
    }

    suspend fun update(up: UP){
        return uPD.update(up)
    }

    suspend fun delete(up: UP){
        return uPD.delete(up)
    }
}