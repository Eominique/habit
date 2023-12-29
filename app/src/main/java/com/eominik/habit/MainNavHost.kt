package com.eominik.habit

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost


@Composable
fun MainNavHost(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = MainScreens.HabitNavGraph.route
    ) {
        habitsNavRoute()
    }
}