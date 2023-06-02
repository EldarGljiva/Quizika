package com.example.quizika

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizika.data.Score
import com.example.quizika.data.userInput


@Composable
fun Finish(

    onCancelButton: () -> Unit
){



    val image: Painter = painterResource(id = R.drawable.trophy)

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Congratulations ${userInput.value}", fontSize = 35.sp)
        Spacer(modifier = Modifier.height(35.dp))
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)

        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Your score is: ${Score.value} / 10 ",
            fontSize = 25.sp)
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            onClick = {
                onCancelButton()
                Score.value=0 }
        ) {
            Text(text = "Play again")
        }
    }
}