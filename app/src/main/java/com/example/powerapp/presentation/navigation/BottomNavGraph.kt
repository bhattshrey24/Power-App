package com.example.powerapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.powerapp.presentation.navigation.routes.HomeGraphScreens
import com.example.powerapp.presentation.navigation.routes.MyGraph
import com.example.powerapp.presentation.navigation.routes.ProfileGraphScreens
import com.example.powerapp.presentation.navigation.routes.RunningGraphScreens
import com.example.powerapp.presentation.navigation.routes.TabScreen
import com.example.powerapp.presentation.screens.AddOrEditTemplateScreen
import com.example.powerapp.presentation.screens.BodyMeasurementScreen
import com.example.powerapp.presentation.screens.CalorieHistoryScreen
import com.example.powerapp.presentation.screens.CreateExerciseScreen
import com.example.powerapp.presentation.screens.ExploreTemplateScreen
import com.example.powerapp.presentation.screens.ListOfExerciseScreen
import com.example.powerapp.presentation.screens.MyTemplateScreen
import com.example.powerapp.presentation.screens.RunningFinishedScreen
import com.example.powerapp.presentation.screens.RunningScreen
import com.example.powerapp.presentation.screens.StartWorkoutScreen
import com.example.powerapp.presentation.screens.TemplateDetailScreen
import com.example.powerapp.presentation.screens.TemplateScreen
import com.example.powerapp.presentation.screens.WorkoutHistoryScreen
import com.example.powerapp.presentation.screens.tabs.HomeTabScreen
import com.example.powerapp.presentation.screens.tabs.ProfileTabScreen
import com.example.powerapp.presentation.screens.tabs.RunningTabScreen

@Composable
fun BottomNavGraph(navController: NavHostController, modifier: Modifier) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = TabScreen.Home.route
    ) {
        composable(route = TabScreen.Home.route) {
            HomeTabScreen(onClick1 = {
                navController.navigate(MyGraph.HOMEGRAPH)
            }, onClick2 = {}, onClick3 = {})
        }
        composable(route = TabScreen.Running.route) {
            RunningTabScreen(onClick1 = {
                navController.navigate(MyGraph.RUNNINGGRAPH)
            }, onClick2 = {}, onClick3 = {})
        }
        composable(route = TabScreen.Profile.route) {
            ProfileTabScreen(onClick1 = {
                navController.navigate(MyGraph.PROFILEGRAPH)
            }, onClick2 = {}, onClick3 = {})
        }
        homeNavGraph(navController = navController)
        runningNavGraph(navController = navController)
        profileNavGraph(navController = navController)
    }
}

fun NavGraphBuilder.homeNavGraph(navController: NavHostController) {
    navigation(
        route = MyGraph.HOMEGRAPH,
        startDestination = HomeGraphScreens.StartWorkoutScreen.route
    ) {
        composable(route = HomeGraphScreens.StartWorkoutScreen.route) {
            StartWorkoutScreen(onClick1 = {}, onClick2 = {}, onClick3 = {})
        }
        composable(route = HomeGraphScreens.MyTemplateScreen.route) {
            MyTemplateScreen(onClick1 = {}, onClick2 = {}, onClick3 = {})
        }
        composable(route = HomeGraphScreens.ExploreTemplateScreen.route) {
            ExploreTemplateScreen(onClick1 = {}, onClick2 = {}, onClick3 = {})
        }
        composable(route = HomeGraphScreens.TemplateScreen.route) {
            TemplateScreen(onClick1 = {}, onClick2 = {}, onClick3 = {})
        }
        composable(route = HomeGraphScreens.TemplateDetailScreen.route) {
            TemplateDetailScreen(onClick1 = {}, onClick2 = {}, onClick3 = {})
        }
        composable(route = HomeGraphScreens.ListOfExerciseScreen.route) {
            ListOfExerciseScreen(onClick1 = {}, onClick2 = {}, onClick3 = {})
        }
        composable(route = HomeGraphScreens.CreateExerciseScreen.route) {
            CreateExerciseScreen(onClick1 = {}, onClick2 = {}, onClick3 = {})
        }
        composable(route = HomeGraphScreens.AddOrEditTemplateScreen.route) {
            AddOrEditTemplateScreen(onClick1 = {}, onClick2 = {}, onClick3 = {})
        }
    }
}

fun NavGraphBuilder.runningNavGraph(navController: NavHostController) {
    navigation(
        route = MyGraph.RUNNINGGRAPH,
        startDestination = RunningGraphScreens.RunningScreen.route
    ) {
        composable(route = RunningGraphScreens.RunningScreen.route) {
            RunningScreen(onClick1 = {}, onClick2 = {}, onClick3 = {})
        }
        composable(route = RunningGraphScreens.RunFinishedScreen.route) {
            RunningFinishedScreen(onClick1 = {}, onClick2 = {}, onClick3 = {})
        }
    }
}

fun NavGraphBuilder.profileNavGraph(navController: NavHostController) {
    navigation(
        route = MyGraph.PROFILEGRAPH,
        startDestination = ProfileGraphScreens.WorkoutHistoryScreen.route
    ) {
        composable(route = ProfileGraphScreens.WorkoutHistoryScreen.route) {
            WorkoutHistoryScreen(onClick1 = {}, onClick2 = {}, onClick3 = {})
        }
        composable(route = ProfileGraphScreens.CalorieHistoryScreen.route) {
            CalorieHistoryScreen(onClick1 = {}, onClick2 = {}, onClick3 = {})
        }
        composable(route = ProfileGraphScreens.BodyMeasurementScreen.route) {
            BodyMeasurementScreen(onClick1 = {}, onClick2 = {}, onClick3 = {})
        }
        composable(route = ProfileGraphScreens.BodyPartScreen.route) {
            //StartWorkoutScreen(onClick1 = {}, onClick2 = {}, onClick3 = {})
        }
    }
}


