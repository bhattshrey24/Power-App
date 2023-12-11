package com.example.powerapp.presentation.common_compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.powerapp.ui.theme.ThemeConst

@Composable
fun ButtonPrimary(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    buttonText: String,
    cornerRadius: Dp = ThemeConst.CornerRadius.small,
    buttonTextColor: Color = ThemeConst.MyColors.TextPri,
    backgroundColor: Color = ThemeConst.MyColors.SurfaceSec
) = Button(
    onClick = onClick,
    modifier = modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp),
    colors = ButtonDefaults.buttonColors(
        contentColor = buttonTextColor,
        containerColor = backgroundColor,
    ), shape = RoundedCornerShape(cornerRadius)
) {
    Text(text = buttonText)
}