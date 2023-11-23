package com.kaushik.quizapp

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kaushik.quizapp.questions.Question
import com.kaushik.quizapp.questions.questionsMap

@Composable
fun QuestionScreen(navController: NavHostController) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("data", Context.MODE_PRIVATE)
    val difficulty = sharedPreferences.getString("difficulty", "").toString()
    val topic = sharedPreferences.getString("topic", "").toString()
    val questionsList: List<Question> = questionsMap[topic]?.get(difficulty)!!
    val options = mutableListOf<List<String>>()
    questionsList.forEach { questionItem ->
        val optionsList = questionItem.incorrectAnswers.toMutableList()
        optionsList.add(questionItem.correctAnswer)
        options.add(optionsList)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.96f)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            for (i in questionsList.indices) {
                val question = questionsList[i].question
                Card(
                    elevation = 10.dp,
                    modifier = Modifier
                        .padding(vertical = 10.dp)
                        .fillMaxWidth()
                        .height(70.dp),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Text(
                            text = """
                            Q ${i + 1}
                            $question
                            """.trimIndent(),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
                var selectedOption by remember {
                    mutableStateOf("")
                }
                val optionsList = options[i]
                optionsList.forEach { option ->
                    val textColor =
                        if (selectedOption == option)
                            Color(0xff004643)
                        else
                            Color(0xff000000)
                    val rowColor =
                        if (selectedOption == option)
                            Color(0xffABD1C6)
                        else
                            Color(0xffffffff)
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(vertical = 5.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .fillMaxWidth()
                            .background(rowColor)
                    ) {
                        RadioButton(
                            selected = selectedOption == option,
                            onClick = {
                                selectedOption = option
                                sharedPreferences.edit().putString(i.toString(), option).commit()
                            },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color(0xff004643),
                                unselectedColor = Color(0xff000000)
                            )
                        )
                        Text(
                            text = option,
                            color = textColor
                        )
                    }
                }
            }
        }
        Button(
            onClick = {
                var score = 0
                for (i in 0 until 10) {
                    val response = sharedPreferences.getString("$i", "")
                    if (response == questionsList[i].correctAnswer) {
                        score++
                    }
                }
                sharedPreferences.edit().putInt("score", score).commit()
                navController.navigate("results")
            }
        ) {
            Text(text = "Submit")
        }
    }
}
