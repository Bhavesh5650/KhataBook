package com.example.khatabook.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("User")
data class BookEntity(
    @PrimaryKey(autoGenerate = true)
    val userId:Int=0,
    @ColumnInfo
    val userName:String,
    @ColumnInfo
    val userMobile:String
)

@Entity("Product")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    val proId:Int=0,
    @ColumnInfo
    val proName:String,
    @ColumnInfo
    val proQuantity:String,
    @ColumnInfo
    val proPrice:String,
    @ColumnInfo
    val proTotalAmount:String
)