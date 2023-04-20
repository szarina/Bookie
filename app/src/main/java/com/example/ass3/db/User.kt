package com.example.ass3.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="users")
data class User (
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,

    @ColumnInfo(name = "username")
    var username:String,

    @ColumnInfo(name="password")
    var password : String,

    @ColumnInfo(name="isAdmin")
    var isAdmin:Boolean,




    )