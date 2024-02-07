package com.example.powerapp.presentation.common_compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Lock
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
import com.example.powerapp.domain.models.Set
import com.example.powerapp.domain.models.Template
import com.example.powerapp.presentation.screens.dummy.dummyListOfExercises
import com.example.powerapp.presentation.screens.dummy.dummyTemplateList
import com.example.powerapp.ui.theme.ThemeConst
import java.time.DayOfWeek

@Preview
@Composable
fun ExploreRoutineTilePreview() {
    ExploreRoutineTile(dummyTemplateList[0])
}

@Composable
fun ExploreRoutineTile(template: Template) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            color = ThemeConst.MyColors.SurfacePri,
            shape = RoundedCornerShape(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        all = 10.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = template.name,
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = ThemeConst.MyColors.TextPri,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = "${template.numOfDays} Days",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = ThemeConst.MyColors.TextPri
                    )
                )
                Icon(
                    imageVector = Icons.Outlined.Add,
                    contentDescription = "Add",
                    tint = Color.White,
                    modifier = Modifier
                        .height(18.dp)
                        .width(18.dp)
                )

            }

        }
        Spacer(modifier = Modifier.height(20.dp))
        LazyRow(
            modifier = Modifier.padding(start = 10.dp)
        ) {
            val list = template.days.sortedBy {it.day}
            items(list) { templateDay ->
                ExploreRoutineDayTile(templateDay.day, templateDay.name)
                Spacer(modifier = Modifier.width(20.dp))
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
    }
}

@Preview
@Composable
fun PreviewExploreTemplateDayTile() {
    ExploreRoutineDayTile(
        DayOfWeek.MONDAY,
        "Pull"
    )
}

@Composable
fun ExploreRoutineDayTile(
    day: DayOfWeek,
    name: String
) {
    Surface(
        color = ThemeConst.MyColors.SurfacePri,
        modifier = Modifier
            .height(100.dp)
            .width(150.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 8.dp,
                        end = 8.dp,
                        top = 8.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = day.name,
                    style = TextStyle(
                        fontSize = 8.sp,
                        color = ThemeConst.MyColors.TextPri
                    )
                )
                Icon(
                    imageVector = Icons.Outlined.Add,
                    contentDescription = "Add",
                    tint = Color.White,
                    modifier = Modifier
                        .height(10.dp)
                        .width(10.dp)
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = name,
                style = TextStyle(
                    color = ThemeConst.MyColors.TextPri,
                    fontSize = 28.sp
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


@Preview
@Composable
fun TemplateDayTilePreview() {
    val list = listOf(
        dummyListOfExercises[0] to listOf<Set>(
            Set(weight = 10, reps = 10),
            Set(weight = 20, reps = 12),
            Set(weight = 30, reps = 15)
        ),
        dummyListOfExercises[1] to listOf<Set>(
            Set(weight = 12, reps = 20),
            Set(weight = 22, reps = 22),
            Set(weight = 32, reps = 25)
        )
    )
    TemplateDayTile(
        day = DayOfWeek.MONDAY,
        name = "Chest",
        listOfExercise = list
    ){}

}

@Composable
fun TemplateDayTile(
    day: DayOfWeek,
    name: String,
    listOfExercise: List<Pair<Exercise, List<Set>>>,
    onClick: () -> Unit
) {
    Surface(
        color = ThemeConst.MyColors.SurfacePri,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
            .clickable { onClick() }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = name, style = TextStyle(
                        color = ThemeConst.MyColors.TextPri,
                        fontSize = 26.sp
                    )
                )
                Surface(
                    color = ThemeConst.MyColors.Background,
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Text(
                        text = day.toString(), style = TextStyle(
                            fontSize = 7.sp, color = ThemeConst.MyColors.TextPri
                        ),
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp, bottom = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    for (entry in listOfExercise) {
                        val number = entry.second.size
                        val exerciseName = entry.first.exerciseName
                        Text(
                            text = "$number   X   $exerciseName",
                            modifier = Modifier.padding(bottom = 4.dp),
                            style = TextStyle(
                                color = ThemeConst.MyColors.TextPri,
                                fontSize = 10.sp
                            )
                        )
                    }
                }
                Icon(
                    imageVector = Icons.Outlined.Delete,
                    contentDescription = "Delete Icon",
                    tint = Color.White,
                    modifier = Modifier
                        .height(28.dp)
                        .width(28.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Preview
@Composable
fun CreateExerciseTilePreview() {
    CreateExerciseTile(
        headText = "Primary Muscle Group",
        subHeadText = "Back"
    )
}

@Composable
fun CreateExerciseTile(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(
            start = 10.dp,
            end = 10.dp
        ),
    headText: String,
    subHeadText: String
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = headText,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                ),
                color = ThemeConst.MyColors.TextPri,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Text(
                text = subHeadText,
                style = TextStyle(fontSize = 14.sp),
                color = ThemeConst.MyColors.TextPriVariant,
            )
        }
        Icon(
            imageVector = Icons.Outlined.KeyboardArrowRight,
            tint = Color.White,
            contentDescription = ""
        )
    }
}


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
                        text = exercise.exerciseName,
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
                buttonText = "Add Set"
            ) {

            }
        }
    }
}

@Composable
fun SetTile(
    setNumber: String,
    previous: String,
    weight: String,
    reps: String,
    isHeader: Boolean,
    isTemplate: Boolean = false
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
                    imageVector = if (!isTemplate) Icons.Outlined.Check else Icons.Outlined.Lock,
                    tint = Color.White,
                    contentDescription = "Placeholder Icon",
                    modifier = Modifier.padding(all = 2.dp)
                )
            }
        } else {
            Surface(
                color = if (!isTemplate) ThemeConst.MyColors.SurfacePri else Color.Transparent,
                shape = RoundedCornerShape(ThemeConst.CornerRadius.small)
            ) {
                Icon(
                    imageVector = if (!isTemplate) Icons.Outlined.Check else Icons.Outlined.Lock,
                    tint = Color.White,
                    contentDescription = "My Icon 2",
                    modifier = Modifier.padding(all = 2.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun TemplateExerciseTilePreview() {
    val templateDay = dummyTemplateList[0].days[0].listOfExercises[0]
    TemplateExerciseTile(
        exercise = templateDay
    )
}

@Composable
fun TemplateExerciseTile(
    exercise: Pair<Exercise, List<Set>>
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
                        text = exercise.first.exerciseName,
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

            TemplateSetTile(
                setNumber = "Sets",
                weight = "Kg",
                reps = "Reps",
                isHeader = true
            )
            var count = counter
            for (sets in exercise.second) {
                TemplateSetTile(
                    setNumber = count.toString(),
                    weight = sets.weight.toString(),
                    reps = sets.reps.toString(),
                    isHeader = false
                )
                count++
            }
//            ButtonSecondary(
//                modifierBtn = Modifier
//                    .fillMaxWidth()
//                    .padding(top = 10.dp, bottom = 10.dp)
//                    .clickable {
//                        counter++
//                    },
//                modifierTxt = Modifier
//                    .fillMaxWidth()
//                    .padding(top = 2.dp, bottom = 2.dp),
//                buttonText = "Add Set"
//            ) {
//
//            }
        }
    }
}

@Composable
fun TemplateSetTile(
    setNumber: String,
    weight: String,
    reps: String,
    isHeader: Boolean,
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
    }
}
