package com.example.quizika

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.quizika.db.Person
import com.example.quizika.db.PersonDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf


class PersonViewModel(personDao: PersonDao) : ViewModel() {

    //example
    fun getFullSchedule(): Flow<List<Person>> = flowOf(
        listOf(
            Person(
                1,
                "Eldar",
                7
            )
        )
    )


    companion object {
        val factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as PersonApplication)
                PersonViewModel(application.database.personDao())
            }
        }
    }

}
