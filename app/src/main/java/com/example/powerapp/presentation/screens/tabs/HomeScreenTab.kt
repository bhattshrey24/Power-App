package com.example.powerapp.presentation.screens.tabs


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.powerapp.ui.theme.ThemeConst
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.powerapp.presentation.common_compose.HomeTabButton


@Preview
@Composable
fun HomeTabScreenPreview() {
    HomeTabScreen(
        onClickStartWorkout = {},
        onClickMyTemplates = {},
        onClickExploreTemplate = {}
    )
}

@Composable
fun HomeTabScreen(
    onClickStartWorkout: () -> Unit,
    onClickMyTemplates: () -> Unit,
    onClickExploreTemplate: () -> Unit
) {
    Surface(color = ThemeConst.MyColors.Background) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            Text(
                text = "Quick Start",
                color = ThemeConst.MyColors.TextPri,
                style = TextStyle(fontSize = ThemeConst.FontSize.headingLarge),
                modifier = Modifier
                    .padding(
                        top = 60.dp,
                        start = 20.dp,
                        bottom = 40.dp
                    )
                    .fillMaxWidth(),
                textAlign = TextAlign.Start
            )

            Button(
                onClick = onClickStartWorkout,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = ThemeConst.MyColors.TextPri,
                    containerColor = ThemeConst.MyColors.SurfaceSec,
                ), shape = RoundedCornerShape(ThemeConst.CornerRadius.medium)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Add,
                    tint = Color.White,
                    contentDescription = "Navigation Icon",
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    fontWeight = FontWeight.Normal,
                    text = "Start Empty Workout",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(8.dp),
                )
            }

            Text(
                text = "Workouts",
                color = ThemeConst.MyColors.TextPri,
                style = TextStyle(fontSize = ThemeConst.FontSize.headingMedium),
                modifier = Modifier
                    .padding(
                        top = 100.dp,
                        start = 20.dp,
                        bottom = 40.dp
                    )
                    .fillMaxWidth(),
                textAlign = TextAlign.Start
            )

            HomeTabButton(text = "My Templates", icon = Icons.Outlined.DateRange) {
                onClickMyTemplates() // Pass template
            }
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp, vertical = 30.dp),
                color = Color.White
            )
            HomeTabButton(text = "Explore Templates", icon = Icons.Outlined.DateRange) {
                onClickExploreTemplate()
            }

        }
    }
}

