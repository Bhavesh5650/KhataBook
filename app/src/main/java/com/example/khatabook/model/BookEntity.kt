package com.example.khatabook.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity("User")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val userId:Int=0,
    @ColumnInfo
    val userName:String,
    @ColumnInfo
    val userMobile:String,
    @ColumnInfo
    val userFlat:String,
    @ColumnInfo
    val userArea:String,
    @ColumnInfo
    val userPin:String,
    @ColumnInfo
    val userCity:String,
    @ColumnInfo
    val userState:String
)

@Entity("Product",foreignKeys = [ForeignKey(
    entity = UserEntity::class,
    parentColumns = arrayOf("userId"),
    childColumns = arrayOf("selectUserId"),
    onDelete = ForeignKey.CASCADE
)])
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    val proId:Int=0,
    @ColumnInfo
    val selectUserId:Int,
    @ColumnInfo
    val proName:String,
    @ColumnInfo
    val proQuantity:String,
    @ColumnInfo
    val proPrice:String,
    @ColumnInfo
    val proTotalAmount:String,
    @ColumnInfo
    val payStatus:Int,
    @ColumnInfo
    val collectionDate:String,
    @ColumnInfo
    val entryDate:String
)

@Entity
data class DetailEntity(
    @ColumnInfo
    val userId:Int=0,
    @ColumnInfo
    val userName:String,
    @ColumnInfo
    val userMobile:String,
    @ColumnInfo
    val userFlat:String,
    @ColumnInfo
    val userArea:String,
    @ColumnInfo
    val userPin:String,
    @ColumnInfo
    val userCity:String,
    @ColumnInfo
    val userState:String,

    @ColumnInfo
    val proId:Int=0,
    @ColumnInfo
    val selectUserId:Int,
    @ColumnInfo
    val proName:String,
    @ColumnInfo
    val proQuantity:String,
    @ColumnInfo
    val proPrice:String,
    @ColumnInfo
    val proTotalAmount:String,
    @ColumnInfo
    val payStatus:Int,
    @ColumnInfo
    val collectionDate:String,
    @ColumnInfo
    val entryDate:String

)