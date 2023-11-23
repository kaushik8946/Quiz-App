package com.kaushik.quizapp

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ResultScreen(navController: NavHostController) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("data", Context.MODE_PRIVATE)
    val scoreInt = sharedPreferences.getInt("score", 0)
    val scoreFloat: Float = scoreInt.toFloat() / 10
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(
            progress = scoreFloat,
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.Center),
            strokeCap = StrokeCap.Round,
            strokeWidth = 30.dp,
            color = Color.Green
        )
        Text(
            text = """
            Score is
            ${String.format("%.2f", scoreFloat)}
        """.trimIndent()
        )
    }

}