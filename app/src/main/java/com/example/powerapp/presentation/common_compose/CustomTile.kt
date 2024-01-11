package com.example.powerapp.presentation.common_compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.powerapp.R
import com.example.powerapp.domain.models.Exercise
import com.example.powerapp.presentation.screens.dummy.dummyListOfExercises
import com.example.powerapp.ui.theme.ThemeConst

@Preview
@Composable
fun ExerciseTilePreview() {
    ExerciseTile(
        exerciseName = "Bench Press",
        category = "Chest",
        isSelected = true
    ) {

    }
}

@Composable
fun ExerciseTile(
    exerciseName: String,
    category: String,
    painterResource: Int = R.drawable.splash_logo_1,
    isSelected: Boolean = false,
    onClick: () -> Unit,
) {

    var selected by rememberSaveable { mutableStateOf(isSelected) }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 20.dp,
                end = 20.dp,
                top = 10.dp,
            )
            .clickable {
                selected = !selected // simple toggle
                onClick()
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Surface(
                shape = CircleShape,
                color = Color.Transparent,
                border = BorderStroke(1.dp, Color.White)
            ) {
                Image(
                    painter = painterResource(id = painterResource),
                    contentDescription = "Excercise",
                    modifier = Modifier
                        .height(70.dp)
                        .width(70.dp)
                )
            }
            Column {
                Text(
                    text = exerciseName,
                    fontSize = 20.sp,
                    color = ThemeConst.MyColors.TextPri,
                    modifier = Modifier.padding(start = 20.dp)
                )
                Text(
                    text = category,
                    fontSize = 10.sp,
                    color = ThemeConst.MyColors.TextPriVariant,
                    modifier = Modifier.padding(start = 20.dp)
                )
            }
        }
        Surface(
            color = if (selected) ThemeConst.MyColors.SelectedColor else ThemeConst.MyColors.SurfacePri,
            shape = RoundedCornerShape(ThemeConst.CornerRadius.small)
        ) {
            Icon(
                imageVector = Icons.Outlined.Check,
                tint = Color.White,
                contentDescription = "My Icon 2",
                modifier = Modifier.padding(all = 3.dp)
            )
        }

    }
}


@Preview
@Composable
fun HomeTabButtonPreview() {
    HomeTabButton(
        text = "My Template",
        icon = Icons.Outlined.DateRange,
    ) {}
}

@Composable
fun HomeTabButton(
    text: String,
    icon: ImageVector,
    onClick: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 20.dp,
                end = 20.dp
            )
            .clickable { onClick() }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Surface(
                color = ThemeConst.MyColors.SurfacePri,
                shape = RoundedCornerShape(ThemeConst.CornerRadius.small)
            ) {
                Icon(
                    imageVector = icon,
                    tint = Color.White,
                    contentDescription = "My Icon",
                    modifier = Modifier
                        .height(60.dp)
                        .width(60.dp)
                        .padding(
                            all = 12.dp
                        )
                )
            }
            Text(
                text = text,
                fontSize = 20.sp,
                color = ThemeConst.MyColors.TextPri,
                modifier = Modifier.padding(start = 20.dp)
                //, modifier = Modifier.align(Alignment.CenterVertically)
            )
        }

        Icon(
            imageVector = Icons.Outlined.KeyboardArrowRight,
            tint = Color.White,
            contentDescription = "My Icon 2",
        )
    }

}

@Preview
@Composable
fun WorkoutExerciseTilePreview() {
    val exercise = dummyListOfExercises[0]
    WorkoutExerciseTile(exercise)
}

@Composable
fun WorkoutExerciseTile(
    exercise: Exercise
) {
    var counter by rememberSaveable { mutableIntStateOf(1) }
    Surface(
        modifier = Modifier.padding(
            start = 20.dp,
            end = 20.dp,
            top = 10.dp,
            bottom = 10.dp
        ),
        color = Color.Transparent
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Surface(
                color = ThemeConst.MyColors.SurfacePri,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(ThemeConst.CornerRadius.small)
            ) {
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(
                        text = exercise.exerciseDetails.exerciseName,
                        color = ThemeConst.MyColors.TextPri,
                        modifier = Modifier.padding(start = 20.dp, top = 4.dp, bottom = 4.dp),
                        style = TextStyle(
                            fontSize = ThemeConst.FontSize.bodyMedium,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Icon(
                        imageVector = Icons.Outlined.Delete,
                        contentDescription = "Delete Icon",
                        tint = Color.White,
                        modifier = Modifier.padding(end = 10.dp, top = 2.dp, bottom = 2.dp)
                    )
                }
            }

            SetTile(
                setNumber = "Sets",
                previous = "Previous",
                weight = "Kg",
                reps = "Reps",
                isHeader = true
            )

            for (i in 1..counter) {
                SetTile(
                    setNumber = "1",
                    previous = "50Kg x 10",
                    weight = "40",
                    reps = "10",
                    isHeader = false
                )
            }
            ButtonSecondary(
                modifierBtn = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp)
                    .clickable {
                        counter++
                    },
                modifierTxt = Modifier
                    .fillMaxWidth()
                    .padding(top = 2.dp, bottom = 2.dp),
                buttonText ="Add Set"
            ) {

            }
//            Surface(
//                color = ThemeConst.MyColors.SurfacePri,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(top = 10.dp, bottom = 10.dp)
//                    .clickable {
//                        counter++
//                    },
//            ) {
//                Text(
//                    text = "Add Set",
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(top = 2.dp, bottom = 2.dp),
//                    color = ThemeConst.MyColors.TextPri,
//                    style = TextStyle(fontSize = ThemeConst.FontSize.displayLarge),
//                    textAlign = TextAlign.Center
//                )
//            }
        }
    }
}

@Composable
fun SetTile(
    setNumber: String,
    previous: String,
    weight: String,
    reps: String,
    isHeader: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 4.dp,
                bottom = 4.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = setNumber,
            color = ThemeConst.MyColors.TextPri,
            style = TextStyle(
                fontSize = ThemeConst.FontSize.displayMedium,
                fontWeight = if (isHeader) FontWeight.Bold else FontWeight.Normal
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = previous,
            color = ThemeConst.MyColors.TextPri,
            style = TextStyle(
                fontSize = ThemeConst.FontSize.displayMedium,
                fontWeight = if (isHeader) FontWeight.Bold else FontWeight.Normal
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(2f)
        )
        Text(
            text = weight,
            color = ThemeConst.MyColors.TextPri,
            style = TextStyle(
                fontSize = ThemeConst.FontSize.displayMedium,
                fontWeight = if (isHeader) FontWeight.Bold else FontWeight.Normal
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = reps,
            color = ThemeConst.MyColors.TextPri,
            style = TextStyle(
                fontSize = ThemeConst.FontSize.displayMedium,
                fontWeight = if (isHeader) FontWeight.Bold else FontWeight.Normal
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f)
        )
        if (isHeader) {
            Surface(
                color = Color.Transparent,
                shape = RoundedCornerShape(ThemeConst.CornerRadius.small)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Check,
                    tint = Color.Transparent,
                    contentDescription = "Placeholder Icon",
                    modifier = Modifier.padding(all = 2.dp)
                )
            }
        } else {
            Surface(
                color = ThemeConst.MyColors.SurfacePri,
                shape = RoundedCornerShape(ThemeConst.CornerRadius.small)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Check,
                    tint = Color.White,
                    contentDescription = "My Icon 2",
                    modifier = Modifier.padding(all = 2.dp)
                )
            }
        }
    }
}