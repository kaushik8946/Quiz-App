package com.kaushik.quizapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kaushik.quizapp.questions.Question
import com.kaushik.quizapp.questions.animalQuestionHard
import com.kaushik.quizapp.questions.animalQuestionMedium
import com.kaushik.quizapp.questions.questionsMap

class MainActivity : ComponentActivity() {
    init {
        questionsMap["Animal"]= mutableMapOf()
        questionsMap["Animal"]?.set("Medium", animalQuestionMedium)
        questionsMap["Animal"]?.set("Hard", animalQuestionHard)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                val a=applicationContext.filesDir.list()!!
                a.forEach {
                    Text(text = it.toString())
                }
                Text(text = a.size.toString())
            }
        }
    }
}
