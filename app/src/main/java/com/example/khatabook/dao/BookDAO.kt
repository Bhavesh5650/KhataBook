package com.example.khatabook.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.khatabook.model.BookEntity
import com.example.khatabook.model.ProductEntity

@Dao
interface BookDAO {

    @Insert
    fun userInsert(model:BookEntity)

    @Update
    fun userUpdate(model: BookEntity)

    @Delete
    fun userDelete(model: BookEntity)

    @Query("SELECT * FROM User")
    fun userRead() : MutableList<BookEntity>


    @Insert
    fun productInsert(model:ProductEntity)

    @Update
    fun productUpdate(model: ProductEntity)

    @Delete
    fun productDelete(model: ProductEntity)

    @Query("SELECT * From Product")
    fun productRead() : MutableList<ProductEntity>
}