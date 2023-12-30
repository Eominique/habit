package com.eominik.habit

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.eominik.habit.ui.habit.habitsRoute

@Composable
fun HabitsNavGraph() {
val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Habits.route){
        habitsRoute(navController = navController)
    }

}