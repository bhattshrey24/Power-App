package com.example.powerapp.presentation.screens.tabs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.powerapp.ui.theme.ThemeConst


@Preview
@Composable
fun ProfileTabScreenPreview() {
    ProfileTabScreen(onClick1 = {}, onClick2 = {}, onClick3 = {})
}

@Composable
fun ProfileTabScreen(
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

        }
    }
}


