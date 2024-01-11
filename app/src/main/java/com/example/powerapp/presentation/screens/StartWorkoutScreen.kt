package com.example.powerapp.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.powerapp.domain.models.Exercise
import com.example.powerapp.presentation.common_compose.ButtonPrimary
import com.example.powerapp.presentation.common_compose.ButtonSecondary
import com.example.powerapp.presentation.common_compose.WorkoutExerciseTile
import com.example.powerapp.ui.theme.ThemeConst

@Preview
@Composable
fun StartWorkoutScreenPreview() {
    StartWorkoutScreen(
        list = emptyList(),
        onFinish = {},
        onClickCancel = {},
        onClickAddExercise = {}
    )
}


@Composable
fun StartWorkoutScreen(
    list: List<Exercise>,
    onFinish: () -> Unit,
    onClickCancel: () -> Unit,
    onClickAddExercise: () -> Unit
) {
    var listOfExercise = emptyList<Exercise>()
    if (list.isNotEmpty()) {
        listOfExercise = list
    }

    Surface(
        color = ThemeConst.MyColors.Background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        end = 20.dp,
                        top = 60.dp,
                        start = 20.dp,
                        bottom = 20.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Push Day",
                    color = ThemeConst.MyColors.TextPri,
                    style = TextStyle(fontSize = ThemeConst.FontSize.headingLarge),
                )
                ButtonSecondary(
                    modifierBtn = Modifier.padding(top = 10.dp),
                    modifierTxt = Modifier
                        .padding(
                            start = 20.dp,
                            end = 20.dp,
                            top = 10.dp,
                            bottom = 10.dp
                        ),
                    buttonText = "Finish"
                ) {
                    onFinish()
                }
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .width(100.dp)
            ) {
                Column {
                    Text(
                        text = "Duration", color = ThemeConst.MyColors.TextPri,
                        style = TextStyle(fontSize = ThemeConst.FontSize.labelMedium)
                    )
                    Text(
                        text = "1:15:15", color = ThemeConst.MyColors.TextPri,
                        style = TextStyle(fontSize = ThemeConst.FontSize.labelSmall)
                    )
                }
                Column {
                    Text(
                        text = "Volume", color = ThemeConst.MyColors.TextPri,
                        style = TextStyle(fontSize = ThemeConst.FontSize.labelMedium)
                    )
                    Text(
                        text = "1100 Kg", color = ThemeConst.MyColors.TextPri,
                        style = TextStyle(fontSize = ThemeConst.FontSize.labelSmall)
                    )
                }
            }

            if (listOfExercise.isEmpty()) {
                Text(
                    text = "Add New Exercise",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 50.dp, bottom = 30.dp),
                    textAlign = TextAlign.Center,
                    color = ThemeConst.MyColors.SurfacePri,
                    style = TextStyle(fontSize = ThemeConst.FontSize.titleLarge)
                )
                ButtonPrimary(
                    modifier = Modifier.padding(
                        top = 20.dp,
                        start = 15.dp,
                        end = 15.dp
                    ),
                    onClick = { onClickAddExercise() },
                    buttonText = "Add Exercise"
                )
                Text(
                    text = "Cancel Workout",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp)
                        .height(40.dp)
                        .clickable {
                            onClickCancel()
                        },
                    textAlign = TextAlign.Center,
                    color = ThemeConst.MyColors.TextTer,
                    style = TextStyle(fontSize = ThemeConst.FontSize.displayLarge)
                )
            } else {
                // Show lazy column
                Spacer(modifier = Modifier.height(20.dp))
                LazyColumn() {
                    items(listOfExercise) { exercise ->
                        WorkoutExerciseTile(exercise = exercise)
                    }
                    item {
                        ButtonPrimary(
                            modifier = Modifier.padding(
                                top = 20.dp,
                                start = 15.dp,
                                end = 15.dp
                            ),
                            onClick = { onClickAddExercise() },
                            buttonText = "Add Exercise"
                        )
                    }
                    item {
                        Text(
                            text = "Cancel Workout",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 15.dp)
                                .height(40.dp)
                                .clickable {
                                    onClickCancel()
                                },
                            textAlign = TextAlign.Center,
                            color = ThemeConst.MyColors.TextTer,
                            style = TextStyle(fontSize = ThemeConst.FontSize.displayLarge)
                        )
                    }
                }
            }

        }
    }
}

