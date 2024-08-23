package com.example.khatabook.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.khatabook.model.ProductEntity
import com.example.khatabook.model.UserEntity

@Dao
interface BookDAO {

    @Insert
    fun userInsert(model:UserEntity)

    @Update
    fun userUpdate(model: UserEntity)

    @Delete
    fun userDelete(model: UserEntity)

    @Query("SELECT * FROM User")
    fun userRead() : MutableList<UserEntity>


    @Insert
    fun productInsert(model:ProductEntity)

    @Update
    fun productUpdate(model: ProductEntity)

    @Delete
    fun productDelete(model: ProductEntity)

    @Query("SELECT * From Product")
    fun productRead() : MutableList<ProductEntity>
}