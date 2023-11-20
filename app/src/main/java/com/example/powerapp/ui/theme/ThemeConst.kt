package com.example.powerapp.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.powerapp.R

object ThemeConst{
    object MyColors {
        val Background  = Color(0xFF000000)
        val SurfaceColor = Color(0xFF2C2C2C)
        val PrimaryColor = Color(0xFF4642FF)
        val TextColorPrimary = Color(0xFFFFFFFF)
        val TextColorSecondary = Color(0xFF706F6F)
        val TertiaryColor  = Color(0xFFD86321)
        val FourthColor  = Color(0xFFFFE924)
    }
    object CornerRadius{
        val extraSmall = 6.dp
        val small = 8.dp
        val medium = 10.dp
        val large = 12.dp
        val extraLarge = 14.dp
    }
    object Padding{
        val extraSmall = 4.dp
        val small = 6.dp
        val medium = 8.dp
        val large = 10.dp
        val extraLarge = 12.dp
    }
    object FontSize{
        val headingLarge = 24.sp
        val headingMedium= 18.sp
        val headingSmall= 14.sp
        val titleLarge = 24.sp
        val titleMedium= 18.sp
        val titleSmall= 14.sp
        val bodySmall = 16.sp
        val bodyMedium = 16.sp
        val displayLarge = 14.sp
        val displayMedium = 12.sp
        val displaySmall = 10.sp
        val labelLarge = 12.sp
        val labelMedium= 10.sp
        val labelSmall = 8.sp
        val btnTxtSmall = 8.sp
        val btnTxtMedium = 10.sp
    }

    val myFontFamily = FontFamily(
        Font(R.font.inter_extra_light, weight = FontWeight.ExtraLight),
        Font(R.font.inter_light,weight = FontWeight.Light),
        Font(R.font.inter_thin,weight = FontWeight.Thin),
        Font(R.font.inter_regular,weight = FontWeight.Normal),
        Font(R.font.inter_medium,weight = FontWeight.Medium),
        Font(R.font.inter_semi_bold,weight = FontWeight.SemiBold),
        Font(R.font.inter_bold,weight = FontWeight.Bold),
        Font(R.font.inter_extra_bold,weight = FontWeight.ExtraBold),
    )

}