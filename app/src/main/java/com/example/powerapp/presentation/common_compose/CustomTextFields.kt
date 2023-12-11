package com.example.powerapp.presentation.common_compose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.powerapp.ui.theme.ThemeConst
import com.maxkeppeker.sheets.core.models.base.rememberSheetState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import java.time.LocalDate
import java.time.format.DateTimeFormatter



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldPrimary(
    isError: Boolean = false,
    errorMessage: String = "",
    modifier: Modifier = Modifier,
    containerColor: Color = Color.Transparent,
    borderColor: Color = Color.White,
    valueTextColor: Color = Color.White,
    labelTextColor: Color = ThemeConst.MyColors.TextPri,
    readOnly: Boolean = false,
    enabled: Boolean = true,
    text: String,
    label: String,
    cornerRadius: Dp = ThemeConst.CornerRadius.medium,
    borderRadius: Dp = 2.dp,
    onTextChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    trailingIcon: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    keyboardActions: KeyboardActions,
) = TextField(
    label = if (label.isEmpty()) {
        null
    } else {
        { Text(text = label, color = labelTextColor) }
    },
    value = text,
    leadingIcon = leadingIcon,
    modifier = if (!isError) {
        Modifier
            .fillMaxWidth()
            .border(
                width = borderRadius,
                color = borderColor,
                shape = RoundedCornerShape(cornerRadius)
            )
    } else {
        Modifier
            .fillMaxWidth()
            .border(
                width = borderRadius,
                color = ThemeConst.MyColors.ErrorCol,
                shape = RoundedCornerShape(cornerRadius)
            )
    },
    readOnly = readOnly,
    enabled = enabled,
    trailingIcon = trailingIcon,
    keyboardOptions = keyboardOptions,
    onValueChange = onTextChange,
    keyboardActions = keyboardActions,
    singleLine = true,
    colors = TextFieldDefaults.textFieldColors(
        textColor = valueTextColor,
        containerColor = containerColor,
        cursorColor = Color.White,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent,
        focusedLabelColor = Color.White,
        unfocusedLabelColor = Color.White
    ),
    textStyle = TextStyle(color = valueTextColor)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextFieldWithError(
    isError: Boolean = false,
    errorMessage: String = "",
    modifier: Modifier = Modifier,
    valueTextColor: Color = Color.White,
    readOnly: Boolean = false,
    enabled: Boolean = true,
    text: String,
    label: String,
    onTextChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    trailingIcon: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    keyboardActions: KeyboardActions,
) {
    Column(modifier = modifier) {
        TextFieldPrimary(
            label = label,
            text = text,
            leadingIcon = leadingIcon,
            modifier = modifier,
            readOnly = readOnly,
            enabled = enabled,
            trailingIcon = trailingIcon,
            keyboardOptions = keyboardOptions,
            onTextChange = onTextChange,
            keyboardActions = keyboardActions,
            valueTextColor = valueTextColor,
            isError = isError
        )
        if (isError) {
            Text(text = errorMessage, color = ThemeConst.MyColors.ErrorCol)
        } else {
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}


@Preview
@Composable
fun MyEditCompose() {

//        var textState = remember { mutableStateOf("") }
//        TextFieldA(
//            text = textState.value,
//            onTextChange = { textState.value = it },
//            label = "Name",
//            onSubmit = {Log.d("Debug!", "Pressed done")}
//        )

    // 3)
//        MyBasicTextField(
//            text = textState.value,
//            label = "Name",
//            onTextChange = { textState.value = it },
//            onSubmit = {})

    // 4)
//        val listOfItems = listOf("KG", "Lbs")
//        val expanded = remember { mutableStateOf(false) }
//        val selectedText = remember { mutableStateOf(listOfItems[0]) }
//
//        DropDownMenu2(
//            listOfItems = listOfItems,
//            onExpandedChange = { expanded.value = !expanded.value },
//            onDismiss = {
//                expanded.value = false
//            },
//            onSelect = { text ->
//                selectedText.value = text
//                expanded.value = false
//            },
//            selectedText = selectedText.value,
//            isExpanded = expanded.value
//        )

    //  TextFieldWithDropDown(text = "", onTextChange = {})

//        val pickedDate = remember {
//            mutableStateOf(LocalDate.now())
//        }
//        TextFieldWithCalender(
//            pickedDate = LocalDate.now(),
//            onDateSelect =
//            CalendarSelection.Date { date ->
//                pickedDate.value = date
//            }
//        )


}

@Composable
fun TextFieldWithDropDown(
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    errorMessage: String = "",
    text: String,
    onTextChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
    keyboardActions: KeyboardActions
) {
    val listOfItems = listOf("Kg", "Lbs")
    val expanded = remember { mutableStateOf(false) }
    val selectedText = remember { mutableStateOf(listOfItems[0]) }
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CustomTextFieldWithError(
            modifier = Modifier.weight(2f),
            text = text,
            keyboardActions = keyboardActions,
            onTextChange = onTextChange,
            label = "Weight",
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Face,
                    contentDescription = "",
                    tint = Color.White
                )
            },
            keyboardOptions = keyboardOptions,
            isError = isError,
            errorMessage = errorMessage
        )
        Spacer(modifier = Modifier.width(12.dp))
        DropDownMenu(
            modifier = Modifier.weight(1f),
            listOfItems = listOfItems,
            onExpandedChange = { expanded.value = !expanded.value },
            onDismiss = {
                expanded.value = false
            },
            onSelect = { text ->
                selectedText.value = text
                expanded.value = false
            },
            selectedText = selectedText.value,
            isExpanded = expanded.value
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownMenu(
    modifier: Modifier = Modifier,
    listOfItems: List<String>,
    onExpandedChange: (Boolean) -> Unit,
    onDismiss: () -> Unit,
    onSelect: (String) -> Unit,
    isExpanded: Boolean,
    selectedText: String,
    keyboardActions: KeyboardActions = KeyboardActions {}
) {
    Box(
        modifier = modifier
            .width(200.dp)
        // .padding(16.dp)
    ) {
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = onExpandedChange
        ) {

            TextFieldPrimary(
                text = selectedText,
                onTextChange = {},
                label = "",
                readOnly = true,
                modifier = Modifier.menuAnchor(),
                keyboardActions = keyboardActions,
                trailingIcon = {
                    if (!isExpanded) {
                        Icon(
                            Icons.Default.KeyboardArrowDown,
                            contentDescription = "Localized description",
                            tint = Color.White
                        )
                    } else {
                        Icon(
                            Icons.Default.KeyboardArrowUp,
                            contentDescription = "Localized description",
                            tint = Color.White
                        )
                    }
                }
            )

            ExposedDropdownMenu(
                modifier = Modifier
                    .background(ThemeConst.MyColors.Background)
                    .border(
                        width = 2.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(ThemeConst.CornerRadius.medium)
                    ),
                expanded = isExpanded,
                onDismissRequest = onDismiss
            ) {
                for (i in listOfItems.indices) {
                    DropdownMenuItem(
                        modifier = Modifier.background(ThemeConst.MyColors.Background),
                        text = { Text(text = listOfItems[i], color = ThemeConst.MyColors.TextPri) },
                        onClick = {
                            onSelect(listOfItems[i])
                        }
                    )
                    if (i != listOfItems.size - 1) {
                        Divider(thickness = 2.dp, color = Color.White)
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldWithCalender(
    textFieldModifier: Modifier = Modifier,
    pickedDate: LocalDate,
    onDateSelect: CalendarSelection,
    isError: Boolean = false,
    errorMessage: String = "",
    keyboardActions: KeyboardActions = KeyboardActions { }
) {
    val calenderState = rememberSheetState()

    val formattedDate = remember {
        derivedStateOf {
            DateTimeFormatter.ofPattern("MM dd yyyy").format(pickedDate)
        }
    }

    CalendarDialog(
        state = calenderState,
        config = CalendarConfig(
            monthSelection = true,
            yearSelection = true,
        ),
        selection = onDateSelect
    )
    CustomTextFieldWithError(
        valueTextColor = Color.White,
        text = if (pickedDate == LocalDate.now()) {
            ""
        } else {
            "$pickedDate"
        },
        onTextChange = {},
        label = "Date of birth",
        enabled = false,
        modifier = textFieldModifier
            .clickable { calenderState.show() },
        readOnly = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.DateRange,
                contentDescription = "",
                tint = Color.White
            )
        },
        isError = isError,
        errorMessage = errorMessage,
        keyboardActions = keyboardActions
    )
}

