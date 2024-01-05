package com.example.powerapp.presentation.common_compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

@Preview
@Composable
fun HomeTabButtonPreview() {
    HomeTabButton(
        text = "My Template",
        icon = Icons.Outlined.DateRange,
    ) {}
}

@Composable
fun HomeTabButton(
    text: String,
    icon: ImageVector,
    onClick: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 20.dp,
                end = 20.dp
            )
            .clickable { onClick() }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Surface(
                color = ThemeConst.MyColors.SurfacePri,
                shape = RoundedCornerShape(ThemeConst.CornerRadius.small)
            ) {
                Icon(
                    imageVector = icon,
                    tint = Color.White,
                    contentDescription = "My Icon",
                    modifier = Modifier
                        .height(60.dp)
                        .width(60.dp)
                        .padding(
                            all = 12.dp
                        )
                )
            }
            Text(
                text = text,
                fontSize = 20.sp,
                color = ThemeConst.MyColors.TextPri,
                modifier = Modifier.padding(start = 20.dp)
                //, modifier = Modifier.align(Alignment.CenterVertically)
            )
        }

        Icon(
            imageVector = Icons.Outlined.KeyboardArrowRight,
            tint = Color.White,
            contentDescription = "My Icon 2",
        )
    }

}