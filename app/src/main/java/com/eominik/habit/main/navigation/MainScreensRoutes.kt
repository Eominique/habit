package com.eominik.habit.main.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.eominik.habit.HabitsNavGraph

fun NavGraphBuilder.habitsNavRoute(){
    composable(
    route = MainScreens.HabitNavGraph.route,
        content = {
            HabitsNavGraph() }
    )
}