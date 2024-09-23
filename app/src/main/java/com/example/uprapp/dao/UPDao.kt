package com.example.uprapp.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.uprapp.model.UP
import com.example.uprapp.views.updateprofile

@Dao
interface UPDao {
    @Insert
    suspend fun  insert(up: UP)

    @Update
    suspend fun  update(up: UP)

    @Delete
    suspend fun  delete(up: UP)

    @Query("SELECT * FROM userProfile")
    fun getallprofile():LiveData<List<updateprofile>>



}