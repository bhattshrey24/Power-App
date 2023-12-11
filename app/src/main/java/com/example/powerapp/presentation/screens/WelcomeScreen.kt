package com.example.powerapp.presentation.screens

import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.powerapp.ui.theme.ThemeConst
import com.example.powerapp.R
import com.example.powerapp.presentation.common_compose.ButtonPrimary
import com.example.powerapp.presentation.common_compose.CustomTextFieldWithError
import com.example.powerapp.presentation.common_compose.TextFieldPrimary
import com.example.powerapp.presentation.common_compose.TextFieldWithCalender
import com.example.powerapp.presentation.common_compose.TextFieldWithDropDown
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import java.time.LocalDate
import java.time.Period
import java.time.temporal.ChronoUnit

@Preview
@Composable
fun welcomeScreenPreview() {
    //welcomeScreen()
    WelcomeScreen()
}


@Composable
fun WelcomeScreen() {

    val focusManager = LocalFocusManager.current

    val nameIsEmptyErrorMsg = "Name cannot be empty"
    val invalidWeightErrorMsg = "Weight is not valid"
    val invalidDateOfBirthErrorMsg = "Age cannot be less than 12 years or more than 100 years"

    var isNameValidated by rememberSaveable { mutableStateOf(true) }
    var isAgeValidated by rememberSaveable { mutableStateOf(true) }
    var isWeightValidated by rememberSaveable { mutableStateOf(true) }

    var name by rememberSaveable { mutableStateOf("") }
    var weight by rememberSaveable { mutableStateOf(0.0) }
    var pickedDate by rememberSaveable { mutableStateOf(LocalDate.now()) }

    Surface(
        color = ThemeConst.MyColors.Background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = stringResource(id = R.string.welcome_big),
                color = ThemeConst.MyColors.TextPri,
                style = TextStyle(fontSize = 44.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .padding(
                        bottom = 15.dp
                    )
                    .width((LocalConfiguration.current.screenWidthDp * 0.8).dp)
                    .align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center
            )

            Text(
                text = stringResource(id = R.string.welcome_small),
                color = ThemeConst.MyColors.TextPri,
                style = TextStyle(fontSize = ThemeConst.FontSize.titleSmall),
                modifier = Modifier
                    .padding(
                        bottom = 100.dp
                    )
                    .align(Alignment.CenterHorizontally)
            )

            CustomTextFieldWithError(
                text = name,
                onTextChange = { name = it },
                label = "Name",
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) }
                ),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width((LocalConfiguration.current.screenWidthDp * 0.85).dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Person,
                        contentDescription = "",
                        tint = Color.White
                    )
                },
                isError = !isNameValidated,
                errorMessage = nameIsEmptyErrorMsg
            )

            Spacer(modifier = Modifier.height(10.dp))

            TextFieldWithCalender(
                textFieldModifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width((LocalConfiguration.current.screenWidthDp * 0.85).dp),
                pickedDate = pickedDate,
                onDateSelect =
                CalendarSelection.Date { date ->
                    pickedDate = date
                },
                isError = !isAgeValidated,
                errorMessage = invalidDateOfBirthErrorMsg
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextFieldWithDropDown(
                text = if (weight == 0.0) {
                    ""
                } else {
                    "$weight"
                },
                onTextChange = { weight = it.toDouble() },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width((LocalConfiguration.current.screenWidthDp * 0.85).dp),
                isError = !isWeightValidated,
                errorMessage = invalidWeightErrorMsg,
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) }
                ),
            )
            Spacer(modifier = Modifier.height((LocalConfiguration.current.screenHeightDp * 0.22).dp))
            ButtonPrimary(
                onClick = {
                    // todo
                    //   add room and add user data in that and go to bottom
                    //     naviagtion after data is added to DB
                    isNameValidated = validateName(name)
                    isWeightValidated = validateWeight(weight)
                    isAgeValidated = validateAge(pickedDate)
                    if (isNameValidated&&isAgeValidated&&isWeightValidated) {
                        Log.d("Debug!!", "Data validated")
                    } else {
                        Log.d("Debug!!", "Data not validated")
                    }
                },
                buttonText = "Submit",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width((LocalConfiguration.current.screenWidthDp * 0.85).dp)
            )
        }
    }
}
fun validateName(name: String) = name.isNotBlank()
fun validateAge(pickedDate: LocalDate) = Period.between(
    pickedDate,
    LocalDate.now()
).years in 13..99
fun validateWeight(weight: Double) = weight > 35 && weight < 1000




