package com.example.powerapp.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
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
import com.example.powerapp.domain.models.Template
import com.example.powerapp.presentation.common_compose.HomeTabButton
import com.example.powerapp.presentation.common_compose.TextFieldPrimary
import com.example.powerapp.presentation.screens.dummy.dummyTemplateList
import com.example.powerapp.ui.theme.ThemeConst


@Preview
@Composable
fun MyTemplatesScreenPreview() {
    MyTemplatesScreen(onClickTemplate = {
    })
}

@Composable
fun MyTemplatesScreen(
    onClickTemplate: (Template) -> Unit,
) {
    var searchTxt by rememberSaveable { mutableStateOf("") }
    // val listOfMyTemplates = emptyList<Template>()
    val listOfMyTemplates = dummyTemplateList

    Surface(
        color = ThemeConst.MyColors.Background,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = "My Templates",
                color = ThemeConst.MyColors.TextPri,
                style = TextStyle(fontSize = ThemeConst.FontSize.headingLarge),
                modifier = Modifier.padding(
                    top = 40.dp,
                    start = 20.dp,
                    bottom = 10.dp
                )
            )
            Text(
                text = "New Folder",
                color = ThemeConst.MyColors.TextPri,
                style = TextStyle(
                    fontSize = 14.sp,
                    color = ThemeConst.MyColors.TextSec
                ),
                modifier = Modifier
                    .padding(
                        end = 20.dp,
                    )
                    .align(Alignment.End)
                    .clickable {
                        // Open a dialogue box or something
                    },
            )
            Spacer(modifier = Modifier.height(10.dp))
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
            Spacer(modifier = Modifier.height(20.dp))
            if (listOfMyTemplates.isEmpty()) {
                Text(
                    text = "No Template",
                    style = TextStyle(
                        fontSize = 36.sp,
                        color = ThemeConst.MyColors.TextPriVariant
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 60.dp)
                )
            } else {
                for (template in listOfMyTemplates) {
                    HomeTabButton(text = template.name, icon = Icons.Outlined.DateRange) {
                        // Pass template object to onClick so that we can pass it to next screen
                        onClickTemplate(template)
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                }
            }
        }
    }
}