package com.example.khatabook.helper

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.khatabook.dao.BookDAO
import com.example.khatabook.model.ProductEntity
import com.example.khatabook.model.UserEntity

@Database(entities = [UserEntity::class,ProductEntity::class] , version = 1)
abstract class BookHelper : RoomDatabase()
{

    abstract fun userDAO() : BookDAO

    companion object{

        private var db:BookHelper?=null

        fun initBookDB(context: Context) : BookHelper
        {
            if(db == null)
            {
                db = Room.databaseBuilder(context,BookHelper::class.java,"BookDataBase.db")
                    .allowMainThreadQueries().build()
            }
            return db!!
        }


    }
}