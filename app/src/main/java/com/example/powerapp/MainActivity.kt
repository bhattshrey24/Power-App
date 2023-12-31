package com.example.powerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.powerapp.presentation.navigation.RootNavigationGraph
import com.example.powerapp.ui.theme.PowerAppTheme
import com.example.powerapp.ui.theme.ThemeConst


// todo
//  Try getting state of CalenderDisplay compose out of it
//  Give names to components in Figma and use same names for composables
//  Change Date in domain models to LocalDateTime
//  Make UI of Details screen
//  Add room and hilt and finish details screen
//  Decide about theme like use the given MaterialsTheme or use own for each composable?
//  Note : In domain model use localDateTime and in DTO model use timeStamp
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            PowerAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = ThemeConst.MyColors.Background
                ) {
                    RootNavigationGraph(navController = rememberNavController())
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PowerAppTheme {}
}