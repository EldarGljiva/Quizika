package com.example.quizika.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person")
data class Person(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val username:String,
    val score:Int
)
