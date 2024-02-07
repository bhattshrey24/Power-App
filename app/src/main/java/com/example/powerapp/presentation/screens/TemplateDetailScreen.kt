package com.example.powerapp.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.powerapp.presentation.common_compose.ButtonSecondary
import com.example.powerapp.presentation.common_compose.TemplateExerciseTile
import com.example.powerapp.presentation.screens.dummy.dummyTemplateList
import com.example.powerapp.ui.theme.ThemeConst
import java.time.DayOfWeek


@Preview
@Composable
fun TemplateDetailScreenPreview() {
    TemplateDetailScreen(onClick1 = {}, onClick2 = {}, onClick3 = {})
}

@Composable
fun TemplateDetailScreen(
    onClick1: () -> Unit,
    onClick2: () -> Unit,
    onClick3: () -> Unit
) {

    var templateDay = dummyTemplateList[0].days[0]

    Surface(color = ThemeConst.MyColors.Background) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = templateDay.name,
                    style = TextStyle(
                        fontSize = 36.sp,
                        color = ThemeConst.MyColors.TextPri
                    )
                )
                ButtonSecondary(
                    modifierTxt = Modifier.padding(
                        start = 10.dp,
                        end = 10.dp,
                        top = 4.dp,
                        bottom = 4.dp
                    ),
                    buttonText = "Start Workout",
                    fontWeight = FontWeight.Normal,
                    roundedCorner = 4.dp
                ) {
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "Asigned Day : ${templateDay.day}",
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = ThemeConst.MyColors.TextPriVariant
                    )
                )
                Icon(
                    imageVector = Icons.Outlined.Edit,
                    contentDescription = "Delete Icon",
                    tint = Color.White,
                    modifier = Modifier
                        .height(20.dp)
                        .width(20.dp)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                color = ThemeConst.MyColors.SurfacePri,
                shape = RoundedCornerShape(10.dp)
            ) {
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Volume",
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = ThemeConst.MyColors.TextPri,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(
                            text = "${templateDay.volume.toString()} Kg",
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = ThemeConst.MyColors.TextPri
                            )
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Calories",
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = ThemeConst.MyColors.TextPri,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(
                            text = "${templateDay.calories.toString()} Kcal",
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = ThemeConst.MyColors.TextPri
                            )
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Exercises",
                style = TextStyle(
                    fontSize = 24.sp,
                    color = ThemeConst.MyColors.TextPri
                ),
                modifier = Modifier.padding(start = 20.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            for (exercise in templateDay.listOfExercises) {
                TemplateExerciseTile(exercise = exercise)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}