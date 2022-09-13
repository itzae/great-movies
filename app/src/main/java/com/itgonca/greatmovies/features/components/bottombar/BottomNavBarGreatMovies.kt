package com.itgonca.greatmovies.features.components.bottombar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.itgonca.greatmovies.ui.theme.Blue500
import com.itgonca.greatmovies.ui.theme.WhiteAlpha30

@Composable
fun BottomNavBarGreatMovies(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreens.Home,
        BottomBarScreens.Event,
        BottomBarScreens.Notification,
        BottomBarScreens.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    BottomAppBar(elevation = 8.dp, backgroundColor = MaterialTheme.colors.background) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreens,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val isSelected = currentDestination?.hierarchy?.any {
        it.route == screen.route
    } == true

    BottomNavigationItem(
        selected = isSelected,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },
        icon = {
            Icon(painter = painterResource(id = screen.icon), contentDescription = screen.title)
        },
        unselectedContentColor = WhiteAlpha30,
        selectedContentColor = Blue500
    )
}