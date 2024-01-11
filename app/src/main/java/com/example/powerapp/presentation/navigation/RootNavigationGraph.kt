package com.example.powerapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.powerapp.presentation.navigation.routes.MyGraph
import com.example.powerapp.presentation.navigation.routes.RootScreens
import com.example.powerapp.presentation.screens.WelcomeScreen

@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = MyGraph.ROOT,
      //  startDestination = RootScreens.WelcomeScreen.route
        startDestination = RootScreens.HomeScreen.route

    ) {

        composable(route = RootScreens.WelcomeScreen.route) {
            WelcomeScreen() {
                navController.popBackStack()
                navController.navigate(RootScreens.HomeScreen.route)
            }
        }
        composable(route = RootScreens.HomeScreen.route) {
            HomeScreen()
        }

    }
}

