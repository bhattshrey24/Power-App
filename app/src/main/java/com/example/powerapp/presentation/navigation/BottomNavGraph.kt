package com.example.powerapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.powerapp.domain.models.Exercise
import com.example.powerapp.other.Converters
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
import com.example.powerapp.presentation.screens.MyTemplatesScreen
import com.example.powerapp.presentation.screens.RunningFinishedScreen
import com.example.powerapp.presentation.screens.RunningScreen
import com.example.powerapp.presentation.screens.StartWorkoutScreen
import com.example.powerapp.presentation.screens.TemplateDetailScreen
import com.example.powerapp.presentation.screens.TemplateScreen
import com.example.powerapp.presentation.screens.WorkoutHistoryScreen
import com.example.powerapp.presentation.screens.convertListToGroups
import com.example.powerapp.presentation.screens.dummy.dummyListOfExercises
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
            HomeTabScreen(onClickStartWorkout = {
                navController.navigate(MyGraph.HOMEGRAPH)
            }, onClickMyTemplates = {
                navController.navigate(HomeGraphScreens.MyTemplateScreen.route)
            }, onClickExploreTemplate = {
                navController.navigate(HomeGraphScreens.ExploreTemplateScreen.route)
            })
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
        startDestination = "${HomeGraphScreens.StartWorkoutScreen.route}/{}",
        //startDestination = HomeGraphScreens.ListOfExerciseScreen.route
    ) {
        composable(
            route = "${HomeGraphScreens.StartWorkoutScreen.route}/{my_param}",
            arguments = listOf(
                navArgument("my_param") { type = NavType.StringType }
            )
        ) {
            val param = it.arguments?.getString("my_param") ?: ""
            var list = emptyList<Exercise>()

            if (param.isNotEmpty()) {
                list = Converters.convertJsonToListOfExercise(
                    param.removePrefix("{").removeSuffix("}") // this remove pre and suffix
                    // because when we convert our json to parameter then somehow android is adding extra {}
                    // so we are removing it so that gson can convert it back to List<Exercise>
                )
            }
            StartWorkoutScreen(
                list = list,
                onFinish = {},
                onClickCancel = {

                }, onClickAddExercise = {
                    navController.navigate(HomeGraphScreens.ListOfExerciseScreen.route)
                })
        }

        composable(route = HomeGraphScreens.ListOfExerciseScreen.route) {
            ListOfExerciseScreen(
                onCreateNew = {
                    navController.navigate(HomeGraphScreens.CreateExerciseScreen.route)
                },
                onAdd = {
                    val json = Converters.convertListOfExerciseToJson(it)
                    navController.navigate("${HomeGraphScreens.StartWorkoutScreen.route}/{$json}") {
                        popUpTo(HomeGraphScreens.ListOfExerciseScreen.route) {
                            inclusive = true
                        }
                    }
                },
                list = convertListToGroups(
                    dummyListOfExercises
                )
            )
        }

        composable(route = HomeGraphScreens.MyTemplateScreen.route) {
            MyTemplatesScreen(onClickTemplate = {
                navController.navigate(HomeGraphScreens.TemplateScreen.route)
            })
        }

        composable(route = HomeGraphScreens.ExploreTemplateScreen.route) {
            ExploreTemplateScreen(onClick1 = {}, onClick2 = {}, onClick3 = {})
        }

        composable(route = HomeGraphScreens.TemplateScreen.route) {
            TemplateScreen(onClickTemplateDay = {
                navController.navigate(HomeGraphScreens.TemplateDetailScreen.route)
             }
            )
        }

        composable(route = HomeGraphScreens.TemplateDetailScreen.route) {
            TemplateDetailScreen(onClick1 = {}, onClick2 = {}, onClick3 = {})
        }

        composable(route = HomeGraphScreens.CreateExerciseScreen.route) {
            CreateExerciseScreen(onClickSave = {})
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


