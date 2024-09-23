package com.example.uprapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "userProfile")
data class UP(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val name:String="",
    val email:String="",
    val dob:String="",
    val dist:String="",
    val mobile:String="",
):Serializable
