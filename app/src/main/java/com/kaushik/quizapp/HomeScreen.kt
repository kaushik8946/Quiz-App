package com.kaushik.quizapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen() {
    var topicExpanded by rememberSaveable { mutableStateOf(false) }
    var diffExpanded by rememberSaveable { mutableStateOf(false) }
    val difficulties = listOf("Easy", "Medium", "Hard")
    val topics = listOf(
        "Animals", "General Knowledge", "Geography", "History", "Vehicles"
    )
    var topicChoice by rememberSaveable {
        mutableStateOf(topics[0])
    }
    var difficulty by rememberSaveable {
        mutableStateOf(difficulties[0])
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Select your preference:", fontSize = 20.sp)
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = """
                Select
                topic:
            """.trimIndent(),
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 20.dp),
                fontSize = 17.sp
            )
            ExposedDropdownMenuBox(
                expanded = topicExpanded,
                onExpandedChange = {
                    topicExpanded = !topicExpanded
                },
                modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                OutlinedTextField(
                    readOnly = true,
                    value = topicChoice,
                    onValueChange = { },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(
                            expanded = topicExpanded
                        )
                    },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(),
                    modifier = Modifier.padding(10.dp)
                )
                ExposedDropdownMenu(
                    expanded = topicExpanded,
                    onDismissRequest = {
                        topicExpanded = false
                    }
                ) {
                    topics.forEach { selectionOption ->
                        DropdownMenuItem(
                            onClick = {
                                topicChoice = selectionOption
                                topicExpanded = false
                            }
                        ) {
                            Text(text = selectionOption)
                        }
                    }
                }
            }
        } // topic drop down
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = """
                Select
                Difficulty:
            """.trimIndent(),
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 16.dp),
                fontSize = 17.sp
            )
            ExposedDropdownMenuBox(
                expanded = diffExpanded,
                onExpandedChange = {
                    diffExpanded = !diffExpanded
                },
                modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                OutlinedTextField(
                    readOnly = true,
                    value = difficulty,
                    onValueChange = { },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(
                            expanded = diffExpanded
                        )
                    },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(),
                    modifier = Modifier.padding(10.dp)
                )
                ExposedDropdownMenu(
                    expanded = diffExpanded,
                    onDismissRequest = {
                        diffExpanded = false
                    }
                ) {
                    difficulties.forEach { selectionOption ->
                        DropdownMenuItem(
                            onClick = {
                                difficulty = selectionOption
                                diffExpanded = false
                            }
                        ) {
                            Text(text = selectionOption)
                        }
                    }
                }
            }
        } // difficulty drop down
    }
}
