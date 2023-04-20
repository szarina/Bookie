package com.example.ass3.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="books")
data class Book (
    @PrimaryKey(autoGenerate = true)
     var id:Int? = null,

    @ColumnInfo(name = "title")
     var title:String,

    @ColumnInfo(name="description")
    var description : String,

    @ColumnInfo(name="cost")
    var cost:Int,




)