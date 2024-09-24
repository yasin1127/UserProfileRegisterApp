package com.example.uprapp.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.uprapp.dao.UPDao
import com.example.uprapp.model.UP

@Database(entities = [UP::class], version = 1)
abstract class UDB:RoomDatabase() {
    abstract fun updao():UPDao

    companion object{

        @Volatile
        private var INSTENSE:UDB?=null

        fun getdb(context:Context):UDB{
            return INSTENSE?: synchronized(this){
                val ins= Room.databaseBuilder(
                    context.applicationContext,
                    UDB::class.java,
                    "UserProfileDB"
                ).build()
                INSTENSE=ins
                ins
            }
        }
    }
}