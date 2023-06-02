package com.example.quizika.data

data class Question(
    val questionText: String,
    val possibleAnswers: List<String>,
    val correctAnswerIndex: Int,
    val questionNumber:String
)