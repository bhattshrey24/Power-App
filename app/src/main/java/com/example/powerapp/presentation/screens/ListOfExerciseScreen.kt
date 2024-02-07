package com.example.powerapp.presentation.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.powerapp.domain.models.Exercise
import com.example.powerapp.presentation.common_compose.ButtonSecondary
import com.example.powerapp.presentation.common_compose.ExerciseTile
import com.example.powerapp.presentation.common_compose.TextFieldPrimary
import com.example.powerapp.presentation.screens.dummy.dummyListOfExercises
import com.example.powerapp.ui.theme.ThemeConst


@Preview
@Composable
fun ListOfExerciseScreenPreview() {
    val list = convertListToGroups(dummyListOfExercises)
    ListOfExerciseScreen(onCreateNew = {}, onAdd = {}, list = list)
}

@Composable
fun ListOfExerciseScreen(
    onCreateNew: () -> Unit,
    onAdd: (List<Exercise>) -> Unit,
    list: List<Pair<String, List<Exercise>>>
) {
    var searchTxt by rememberSaveable { mutableStateOf("") }
    val selectedExercises = mutableListOf<Exercise>()

    Surface(
        color = ThemeConst.MyColors.Background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 20.dp,
                        end = 20.dp,
                        top = 60.dp,
                        //bottom = 20.dp
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "List Of Exercises",
                    color = ThemeConst.MyColors.TextPri,
                    style = TextStyle(fontSize = ThemeConst.FontSize.headingLarge),
                    textAlign = TextAlign.Start
                )
                ButtonSecondary(
                    modifierTxt = Modifier
                        .padding(
                            top = 4.dp,
                            bottom = 4.dp,
                            start = 8.dp,
                            end = 8.dp
                        ),
                    buttonText = "Add"
                ) {
                    onAdd(selectedExercises.toList())
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
            ) {
                Text(
                    text = "Create New",
                    color = ThemeConst.MyColors.TextSec,
                    modifier = Modifier.clickable { onCreateNew() }
                )
                Icon(
                    imageVector = Icons.Outlined.Menu,
                    tint = Color.White,
                    contentDescription = "Filter icon"
                )
            }
            TextFieldPrimary(
                text = searchTxt,
                onTextChange = { searchTxt = it },
                label = "Search",
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Search,
                        contentDescription = "Search button",
                        tint = Color.White
                    )
                },
                modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
                keyboardActions = KeyboardActions(
                    onNext = { }
                )
            )
            LazyColumn {
                items(list) { pair ->
                    Text(
                        text = pair.first,
                        color = ThemeConst.MyColors.TextPri,
                        style = TextStyle(fontSize = ThemeConst.FontSize.titleMedium),
                        modifier = Modifier
                            .padding(
                                start = 20.dp,
                                top = 10.dp
                            )
                            .fillMaxWidth()
                    )
                    for (exercise in pair.second) {
                        ExerciseTile(
                            exerciseName = exercise.exerciseName,
                            category = exercise.primaryMuscleGroup.toString()
                        ) {
                            if (selectedExercises.contains(exercise)) {
                                selectedExercises.remove(exercise)
                            } else {
                                selectedExercises.add(exercise)
                            }
                            Log.d("Debuggggggg", selectedExercises.toString())
                        }
                    }
                }
            }
        }
    }
}

fun convertListToGroups(list: List<Exercise>): List<Pair<String, List<Exercise>>> {
    val listOfPair = list.groupBy {
        it.primaryMuscleGroup.toString()
    }.toList()

    // Sort the list based on keys
    val sortedPairs = listOfPair.sortedBy { it.first }

    // Sort the values associated with each key
    val sortedPairsWithSortedValues = sortedPairs.map { (key, values) ->
        key to values.sortedBy { it.exerciseName }
    }
    return sortedPairsWithSortedValues
}