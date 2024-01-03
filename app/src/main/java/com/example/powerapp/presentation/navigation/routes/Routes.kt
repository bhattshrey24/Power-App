package com.example.powerapp.presentation.navigation.routes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector


object MyGraph { // these are names of graphs
    const val ROOT = "root_graph"
    const val HOMEGRAPH = "home_graph"
    const val PROFILEGRAPH = "profile_graph"
    const val RUNNINGGRAPH = "running_graph"
}
sealed class RootScreens(val route: String) {
    object WelcomeScreen : RootScreens("welcome_screen")
    object HomeScreen : RootScreens("home_screen")
}
sealed class TabScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : TabScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Running : TabScreen(
        route = "running",
        title = "Running",
        icon = Icons.Default.Favorite
    )

    object Profile : TabScreen(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )
}

sealed class HomeGraphScreens(val route: String) {
    object StartWorkoutScreen : HomeGraphScreens("start_workout_screen")
    object MyTemplateScreen : HomeGraphScreens("my_template_screen")
    object ExploreTemplateScreen : HomeGraphScreens("explore_template_screen")
    object TemplateScreen : HomeGraphScreens("template_screen")
    object TemplateDetailScreen : HomeGraphScreens("template_detail_screen")
    object ListOfExerciseScreen : HomeGraphScreens("list_of_exercise_screen")
    object CreateExerciseScreen : HomeGraphScreens("create_exercise_screen")
    object AddOrEditTemplateScreen : HomeGraphScreens("add_or_edit_template_screen")


}
sealed class RunningGraphScreens(val route: String) {
    object RunningScreen : RunningGraphScreens("running_screen")
    object RunFinishedScreen : RunningGraphScreens("run_finished_screen")
}
sealed class ProfileGraphScreens(val route: String) {
    object WorkoutHistoryScreen : ProfileGraphScreens("workout_history_screen")
    object CalorieHistoryScreen : ProfileGraphScreens("calorie_history_screen")
    object BodyMeasurementScreen : ProfileGraphScreens("body_measurement_screen")
    object BodyPartScreen : ProfileGraphScreens("body_part_screen")

}