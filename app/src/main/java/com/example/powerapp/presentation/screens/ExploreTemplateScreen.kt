package com.example.powerapp.presentation.screens


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.powerapp.presentation.common_compose.ExploreRoutineTile
import com.example.powerapp.presentation.screens.dummy.dummyTemplateList
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
    val list = dummyTemplateList
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = ThemeConst.MyColors.Background
    ) {
        LazyColumn() {
            item {
                Text(
                    text = "Famous Routines",
                    style = TextStyle(
                        fontSize = 36.sp,
                        color = ThemeConst.MyColors.TextPri
                    ),
                    modifier = Modifier
                        .padding(
                            start = 20.dp,
                            top = 20.dp,
                            bottom = 40.dp
                        )
                )
            }
            items(list) { template ->
                ExploreRoutineTile(template = template)
            }
        }
    }
}