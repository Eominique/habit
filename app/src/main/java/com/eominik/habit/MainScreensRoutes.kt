package com.eominik.habit

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.habitsNavRoute(){
    composable(
    route = MainScreens.HabitNavGraph.route,
        content = { HabitsNavGraph()}
    )
}