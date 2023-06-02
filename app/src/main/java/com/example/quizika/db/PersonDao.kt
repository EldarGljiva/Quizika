package com.example.quizika.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


import kotlinx.coroutines.flow.Flow



@Dao
interface PersonDao {
    @Query("SELECT username,score FROM person")
    fun getAll(): Flow<List<Person>>

    //added new
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(person: Person)
}