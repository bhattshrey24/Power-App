package com.example.powerapp.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.powerapp.ui.theme.ThemeConst

@Preview
@Composable
fun ExploreTemplateScreenPreview() {
    ExploreTemplateScreen(onClick1 = {}, onClick2 = {}, onClick3 = {})
}

@Composable
fun ExploreTemplateScreen(
    onClick1: () -> Unit,
    onClick2: () -> Unit,
    onClick3: () -> Unit
) {
    Surface(color = Color.Cyan) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Button(onClick = onClick1) {
                Text(text = "Button 1")
            }
            Button(onClick = onClick2) {
                Text(text = "Button 1")
            }
            Button(onClick = onClick3) {
                Text(text = "Button 1")
            }
            Text(
                text = "ExploreTemplateScreen",
                color = ThemeConst.MyColors.Background,
                style = TextStyle(fontSize = ThemeConst.FontSize.titleLarge),
            )
        }
    }
}