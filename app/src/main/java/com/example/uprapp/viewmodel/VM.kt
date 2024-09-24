package com.example.uprapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.uprapp.DB.UDB
import com.example.uprapp.model.UP
import com.example.uprapp.rep.UPR
import com.example.uprapp.views.updateprofile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VM(application: Application): AndroidViewModel(application){
    private val repository:UPR
    init {
        val userPdao= UDB.getdb(application).updao()
        repository = UPR (userPdao)
    }

   fun getUserProfiles(): LiveData<List<UP>> {
       return repository.getUP()
   }

        fun insertUserProfile(up: UP){
            viewModelScope.launch (Dispatchers.IO){
                repository.insert(up)
            }
        }
    fun updateUserProfile(up: UP){
        viewModelScope.launch (Dispatchers.IO){
            repository.update(up)
        }
    }
    fun deletetUserProfile(up: UP){
        viewModelScope.launch (Dispatchers.IO){
            repository.delete(up)
        }
    }
}