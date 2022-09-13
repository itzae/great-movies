package com.itgonca.greatmovies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.navigation.compose.rememberNavController
import com.itgonca.greatmovies.features.components.bottombar.BottomNavBarGreatMovies
import com.itgonca.greatmovies.features.navigation.BottomBarNavGraph
import com.itgonca.greatmovies.ui.theme.GreatMoviesTheme

class MainActivityCompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreatMoviesTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                Scaffold(bottomBar = { BottomNavBarGreatMovies(navController = navController) }) { paddingValues ->
                    BottomBarNavGraph(
                        navController = navController,
                        innerPaddingValues = paddingValues
                    )
                }

            }
        }
    }
}