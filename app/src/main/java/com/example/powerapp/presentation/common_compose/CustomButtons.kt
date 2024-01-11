package com.example.powerapp.presentation.common_compose


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.powerapp.ui.theme.ThemeConst

@Preview
@Composable
fun ButtonPrimaryPreview() {
    ButtonPrimary(onClick = {}, buttonText = "Submit")
}

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
fun ButtonSecondaryPreview() {
    ButtonSecondary(
        modifierTxt = Modifier.padding(all = 10.dp),
        buttonText = "Add"
    ) {

    }
}

@Composable
fun ButtonSecondary(
    modifierBtn: Modifier = Modifier.padding(all = 2.dp),
    modifierTxt: Modifier,
    buttonText: String,
    roundedCorner: Dp = ThemeConst.CornerRadius.small,
    backgroundColor: Color = ThemeConst.MyColors.SurfacePri,
    textColor: Color = ThemeConst.MyColors.TextPri,
    fontSize: TextUnit = ThemeConst.FontSize.displayMedium,
    fontWeight: FontWeight = FontWeight.Bold,
    onClick: () -> Unit
) {
    Surface(
        color = backgroundColor,
        shape = RoundedCornerShape(roundedCorner),
        modifier = modifierBtn.clickable {
            onClick()
        }
    ) {
        Text(
            text = buttonText,
            modifier = modifierTxt,
            color = textColor,
            style = TextStyle(
                fontSize = fontSize,
                fontWeight = fontWeight
            ),
            textAlign = TextAlign.Center
        )
    }
}