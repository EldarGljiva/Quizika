package com.example.quizika

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

import com.example.quizika.data.QuestionData
import com.example.quizika.data.Score

@Composable
fun GameScreen(
    navController: NavController,
) {
    var currentQuestionIndex by remember { mutableStateOf(0) }

    val questions = QuestionData.questions

    var selectedButtonIndex by remember { mutableStateOf<Int?>(null) }



    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        if (currentQuestionIndex < questions.size) {
            val currentQuestion = questions[currentQuestionIndex]
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = currentQuestion.questionNumber + " /10")
            Spacer(modifier = Modifier.height(135.dp))
            // Display the question
            Text(text = currentQuestion.questionText)

            Spacer(modifier = Modifier.height(150.dp))

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFd9e8cb))
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                // Display the possible answers as buttons
                currentQuestion.possibleAnswers.forEachIndexed { index, answer ->
                    Button(
                        shape = RectangleShape,
                        onClick = {
                            if (index == currentQuestion.correctAnswerIndex) {
                                // Increase the score if the answer is correct
                                Score.value++
                            }
                            selectedButtonIndex = index

                            // Reset the selected button index after a delay
                            Handler(Looper.getMainLooper()).postDelayed({
                                selectedButtonIndex = null
                            }, 500)

                            // Delay the navigation to the next question
                            Handler(Looper.getMainLooper()).postDelayed({
                                if (currentQuestionIndex < questions.size - 1) {
                                    // Navigate to the next question
                                    currentQuestionIndex++
                                } else {
                                    // User has answered all questions, navigate to the Finish screen
                                    navController.navigate(Screens.Finish.name)
                                }
                            }, 1000)
                        },
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                            .background(
                                when {
                                    selectedButtonIndex == index -> {
                                        if (index == currentQuestion.correctAnswerIndex) {
                                            Color.Green
                                        } else {
                                            Color.Red
                                        }
                                    }
                                    else -> Color(0xFFF2F2F2) //default is some type of white
                                }
                            )
                    ) {
                        Text(text = answer)
                    }
                }
            }
        }
    }
}