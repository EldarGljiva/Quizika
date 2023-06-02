package com.example.quizika.data

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

object Score {
    var value by mutableStateOf(0)
}