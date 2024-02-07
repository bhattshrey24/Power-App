package com.example.powerapp.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Delete
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.powerapp.domain.models.TemplateDay
import com.example.powerapp.presentation.common_compose.TemplateDayTile
import com.example.powerapp.presentation.common_compose.TextFieldPrimary
import com.example.powerapp.presentation.screens.dummy.dummyTemplateList
import com.example.powerapp.ui.theme.ThemeConst


@Preview
@Composable
fun TemplateScreenPreview() {
    TemplateScreen(onClickTemplateDay = {})
}

@Composable
fun TemplateScreen(
    onClickTemplateDay: (TemplateDay) -> Unit,
) {
    var searchTxt by rememberSaveable { mutableStateOf("") }
    val templateDayList = dummyTemplateList[0].days

    Surface(color = ThemeConst.MyColors.Background) {
        Column(
            modifier = Modifier.fillMaxSize(),
            // horizontalAlignment = Alignment.End
        ) {
            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 20.dp,
                        end = 20.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "PPL",
                    style = TextStyle(
                        fontSize = 24.sp,
                        color = ThemeConst.MyColors.TextPri
                    )
                )
                Icon(
                    imageVector = Icons.Outlined.Delete,
                    contentDescription = "Delete Icon",
                    tint = Color.White,
                    modifier = Modifier
                        .height(28.dp)
                        .width(28.dp)
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
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
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                contentAlignment = Alignment.BottomEnd
            ) {
                Icon(
                    imageVector = Icons.Outlined.Add,
                    contentDescription = "Add Icon",
                    tint = Color.White,
                    modifier = Modifier
                        .height(20.dp)
                        .width(20.dp)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
//            for (map in templateDayList) {
//                for(entry in map){
//                    TemplateDayTile(
//                        day = entry.key,
//                        name = entry.value.name,
//                        listOfExercise = entry.value.listOfExercises
//                    )
//                    Spacer(modifier = Modifier.height(20.dp))
//                }
//            }
            for (templateDay in templateDayList) {
                TemplateDayTile(
                    day = templateDay.day,
                    name = templateDay.name,
                    listOfExercise = templateDay.listOfExercises
                ) {
                    onClickTemplateDay(templateDay)
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}