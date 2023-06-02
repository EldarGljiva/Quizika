package com.example.quizika.data

object QuestionData {
    val questions = listOf(
        Question(
            questionText = "What is the capital of France?",
            possibleAnswers = listOf("London", "Paris", "Rome", "Madrid"),
            correctAnswerIndex = 1,
            questionNumber = "1"
        ),
        Question(
            questionText = "Which planet is known as the Red Planet?",
            possibleAnswers = listOf("Venus", "Mars", "Jupiter", "Mercury"),
            correctAnswerIndex = 3,
            questionNumber = "2"
        ),
        Question(
            questionText = "What is the largest ocean in the world?",
            possibleAnswers = listOf("Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean"),
            correctAnswerIndex = 3,
            questionNumber = "3"
        ),
        Question(
            questionText = "Who painted the Mona Lisa?",
            possibleAnswers = listOf("Pablo Picasso", "Leonardo da Vinci", "Vincent van Gogh", "Michelangelo"),
            correctAnswerIndex = 1,
            questionNumber = "4"
        ),
        Question(
            questionText = "Which country is home to the Great Barrier Reef?",
            possibleAnswers = listOf("Australia", "Brazil", "Canada", "China"),
            correctAnswerIndex = 0,
            questionNumber = "5"
        ),
        Question(
            questionText = "What is the tallest mountain in the world?",
            possibleAnswers = listOf("Mount Everest", "K2", "Kangchenjunga", "Makalu"),
            correctAnswerIndex = 0,
            questionNumber = "6"
        ),
        Question(
            questionText = "Who wrote the play Romeo and Juliet?",
            possibleAnswers = listOf("William Shakespeare", "Charles Dickens", "Jane Austen", "Mark Twain"),
            correctAnswerIndex = 0,
            questionNumber = "7"
        ),
        Question(
            questionText = "What is the chemical symbol for the element Gold?",
            possibleAnswers = listOf("Go", "Ag", "Au", "Gd"),
            correctAnswerIndex = 2,
            questionNumber = "8"
        ),
        Question(
            questionText = "Which artist painted the famous artwork 'The Starry Night'?",
            possibleAnswers = listOf("Vincent van Gogh", "Salvador Dalí", "Pablo Picasso", "Leonardo da Vinci"),
            correctAnswerIndex = 0,
            questionNumber = "9"
        ),
        Question(
            questionText = "What is the largest organ in the human body?",
            possibleAnswers = listOf("Liver", "Heart", "Brain", "Skin"),
            correctAnswerIndex = 3,
            questionNumber = "10"
        )
    )
}