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
import com.kaushik.quizapp.questions.animalQuestionHard
import com.kaushik.quizapp.questions.animalQuestionMedium
import com.kaushik.quizapp.questions.difficulties
import com.kaushik.quizapp.questions.generalKnowledgeEasy
import com.kaushik.quizapp.questions.generalKnowledgeHard
import com.kaushik.quizapp.questions.generalKnowledgeMedium
import com.kaushik.quizapp.questions.geographyEasy
import com.kaushik.quizapp.questions.geographyHard
import com.kaushik.quizapp.questions.geographyMedium
import com.kaushik.quizapp.questions.historyEasy
import com.kaushik.quizapp.questions.historyHard
import com.kaushik.quizapp.questions.historyMedium
import com.kaushik.quizapp.questions.questionsMap
import com.kaushik.quizapp.questions.vehiclesEasy
import com.kaushik.quizapp.questions.vehiclesHard
import com.kaushik.quizapp.questions.vehiclesMedium

class MainActivity : ComponentActivity() {
    init {
        questionsMap["Animals"] = mutableMapOf()
        questionsMap["Animals"]?.set("Medium", animalQuestionMedium)
        questionsMap["Animals"]?.set("Hard", animalQuestionHard)
        difficulties["Animals"] = listOf("Medium", "Hard")

        questionsMap["GeneralKnowledge"] = mutableMapOf()
        questionsMap["GeneralKnowledge"]?.set("Easy", generalKnowledgeEasy)
        questionsMap["GeneralKnowledge"]?.set("Medium", generalKnowledgeMedium)
        questionsMap["GeneralKnowledge"]?.set("Hard", generalKnowledgeHard)
        difficulties["GeneralKnowledge"] = listOf("Easy", "Medium", "Hard")

        questionsMap["Geography"] = mutableMapOf()
        questionsMap["Geography"]?.set("Easy", geographyEasy)
        questionsMap["Geography"]?.set("Medium", geographyMedium)
        questionsMap["Geography"]?.set("Hard", geographyHard)
        difficulties["Geography"] = listOf("Easy", "Medium", "Hard")

        questionsMap["History"] = mutableMapOf()
        questionsMap["History"]?.set("Easy", historyEasy)
        questionsMap["History"]?.set("Medium", historyMedium)
        questionsMap["History"]?.set("Hard", historyHard)
        difficulties["History"] = listOf("Easy", "Medium", "Hard")

        questionsMap["Vehicles"] = mutableMapOf()
        questionsMap["Vehicles"]?.set("Easy", vehiclesEasy)
        questionsMap["Vehicles"]?.set("Medium", vehiclesMedium)
        questionsMap["Vehicles"]?.set("Hard", vehiclesHard)
        difficulties["Vehicles"] = listOf("Easy", "Medium", "Hard")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                val a = applicationContext.filesDir.list()!!
                a.forEach {
                    Text(text = it.toString())
                }
                Text(text = a.size.toString())
            }
        }
    }
}
