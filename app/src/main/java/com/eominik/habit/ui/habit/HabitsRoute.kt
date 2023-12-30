package com.eominik.habit.ui.habit

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.eominik.habit.Screen

fun NavGraphBuilder.habitsRoute(navController: NavController) {
    composable(
        route = Screen.Habits.route,
        content = {
            HabitScreen(
                navController = navController)
        }
    )
}