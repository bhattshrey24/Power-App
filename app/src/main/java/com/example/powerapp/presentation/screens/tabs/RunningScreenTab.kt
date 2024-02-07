package com.example.powerapp.presentation.screens.tabs

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
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.powerapp.presentation.common_compose.ButtonTertiary
import com.example.powerapp.ui.theme.ThemeConst

@Preview
@Composable
fun RunningTabScreenPreview() {
    RunningTabScreen(onClick1 = {}, onClick2 = {}, onClick3 = {})
}

@Composable
fun RunningTabScreen(
    onClick1: () -> Unit,
    onClick2: () -> Unit,
    onClick3: () -> Unit
) {
    Surface(
        color = ThemeConst.MyColors.Background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = "Tracker",
                style = TextStyle(
                    fontSize = 32.sp,
                    color = ThemeConst.MyColors.TextPri
                ),
                modifier = Modifier.padding(start = 30.dp, top = 40.dp)
            )
            Spacer(modifier = Modifier.height(40.dp))
            Surface( // MAP
                modifier = Modifier
                    .height(320.dp)
                    .width(320.dp)
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(12.dp),
                color = ThemeConst.MyColors.SurfacePri
            ) {}
            Spacer(modifier = Modifier.height(50.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp)
            ) {
                ButtonTertiary(
                    buttonText = "Run",
                    icon = Icons.Outlined.Add
                ) {

                }
                ButtonTertiary(
                    buttonText = "History",
                    icon = Icons.Outlined.Refresh
                ) {

                }
            }
        }
    }
}