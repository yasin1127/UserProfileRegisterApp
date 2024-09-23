package com.example.uprapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.uprapp.DB.UDB
import com.example.uprapp.dao.UPDao
import com.example.uprapp.model.UP
import com.example.uprapp.rep.UPR
import com.example.uprapp.views.updateprofile

class VM(application: Application): AndroidViewModel(application){
    private val repository:UPR
    init {
        val userPdao= UDB.getdb(application).updao()
        repository = UPR(uPD)
    }

   fun getUserProfiles():LiveData<List<updateprofile>>{
       return repository.getUP()
   }

        fun insertUserProfile(up: UP){
            viewModelScope
        }
}