package com.example.powerapp.presentation.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.powerapp.presentation.navigation.routes.TabScreen


@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen()
}
@Composable
fun HomeScreen(navController: NavHostController = rememberNavController()) {
    Column(modifier = Modifier.fillMaxSize()) {
        BottomNavGraph(
            navController = navController, modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        )
        BottomBar(navController = navController, modifier = Modifier.height(70.dp))
    }
}
@Composable
fun BottomBar(navController: NavHostController, modifier: Modifier = Modifier) {
    val screens = listOf(
        TabScreen.Home,
        TabScreen.Running,
        TabScreen.Profile,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomBarDestination = screens.any { it.route == currentDestination?.route }
    if (bottomBarDestination) { // this will make hide the bottom bar if current screen is not a tab screen
        NavigationBar(modifier = modifier) {
            screens.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}
@Composable
fun RowScope.AddItem(
    screen: TabScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    NavigationBarItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation Icon"
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}