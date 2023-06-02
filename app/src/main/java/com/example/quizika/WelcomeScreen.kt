package com.example.quizika

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.compose.ui.graphics.Color


@Composable
fun WelcomeScreen(onNextButtonClicked: () ->Unit,
                  modifier: Modifier = Modifier) {




    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFDFE2DC)),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Image(
            painter = painterResource(id = R.drawable.logotextsmall
            ),
            contentDescription = "background image"

        )

        Spacer(modifier = Modifier.height(100.dp))

        //example from google, function is below
        CustomTextField()
        Spacer(modifier = Modifier.height(15.dp))

        //TEXT FIELD HERE

        Button(
            onClick = { onNextButtonClicked() }

        ) {
            Text(text = "Continue")
        }


    }

}