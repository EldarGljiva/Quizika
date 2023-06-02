package com.example.quizika

import android.app.Application
import com.example.quizika.db.PersonDatabase

class PersonApplication: Application() {
    val database: PersonDatabase by lazy{ PersonDatabase.getDatabase(this)}
}