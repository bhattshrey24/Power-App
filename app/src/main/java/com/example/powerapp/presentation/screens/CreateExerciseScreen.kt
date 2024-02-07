package com.example.powerapp.presentation.screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.powerapp.R
import com.example.powerapp.presentation.common_compose.ButtonPrimary
import com.example.powerapp.presentation.common_compose.CreateExerciseTile
import com.example.powerapp.presentation.common_compose.CustomTextFieldWithError
import com.example.powerapp.ui.theme.ThemeConst


@Preview
@Composable
fun CreateExerciseScreenPreview() {
    CreateExerciseScreen(
        onClickSave = {}
    )
}

@Composable
fun CreateExerciseScreen(
    onClickSave: () -> Unit
) {
    var name by rememberSaveable { mutableStateOf("") }
    var isNameValidated by rememberSaveable { mutableStateOf(true) }
    val nameIsEmptyErrorMsg = "Name cannot be empty"

    Surface(color = ThemeConst.MyColors.Background) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 10.dp,
                    end = 10.dp
                )
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "Create Exercise",
                color = ThemeConst.MyColors.TextPri,
                style = TextStyle(fontSize = ThemeConst.FontSize.headingLarge),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(20.dp))
            Surface(
                shape = CircleShape,
                color = Color.Transparent,
                border = BorderStroke(4.dp, Color.White),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.splash_logo_1),
                    contentDescription = "Exercise",
                    modifier = Modifier
                        .height(120.dp)
                        .width(120.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Add an Image",
                style = TextStyle(
                    fontSize = 18.sp
                ),
                color = ThemeConst.MyColors.TextPri,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "Exercise Name", style = TextStyle(
                    fontSize = 18.sp
                ), color = ThemeConst.MyColors.TextPri, modifier = Modifier.padding(start = 10.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            CustomTextFieldWithError(
                text = name,
                onTextChange = { name = it },
                label = "Name",
                keyboardActions = KeyboardActions(onNext = {}),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(
                        start = 5.dp, end = 5.dp
                    ),
                isError = !isNameValidated,
                errorMessage = nameIsEmptyErrorMsg
            )
            Spacer(modifier = Modifier.height(10.dp))
            CreateExerciseTile(
                headText = "Primary Muscle Group", subHeadText = "Back"
            )
            Spacer(modifier = Modifier.height(20.dp))
            CreateExerciseTile(
                headText = "Other Muscle Groups", subHeadText = "Core"
            )
            Spacer(modifier = Modifier.height(20.dp))
            CreateExerciseTile(
                headText = "Exercise Type", subHeadText = "Body Weight"
            )
            Spacer(modifier = Modifier.height(60.dp))
            ButtonPrimary(
                onClick = {
                    isNameValidated = validateName(name)
                    if (isNameValidated) {
                        Log.d("Debug!!", "Data validated")
                        onClickSave()
                    } else {
                        Log.d("Debug!!", "Data not validated")
                    }
                }, buttonText = "Save"
            )

        }
    }
}