package com.itgonca.greatmovies.features.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.itgonca.greatmovies.features.components.bottombar.BottomBarScreens
import com.itgonca.greatmovies.features.home.ui.compose.HomeScreen

@Composable
fun BottomBarNavGraph(navController: NavHostController, innerPaddingValues: PaddingValues) {
    NavHost(navController = navController, startDestination = BottomBarScreens.Home.route) {
        composable(route = BottomBarScreens.Home.route) {
            HomeScreen()
        }
        composable(route = BottomBarScreens.Event.route) {

        }
        composable(route = BottomBarScreens.Notification.route) {

        }
        composable(route = BottomBarScreens.Profile.route) {

        }
    }
}