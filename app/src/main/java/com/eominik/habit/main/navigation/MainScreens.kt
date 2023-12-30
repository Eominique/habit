package com.eominik.habit.main.navigation

sealed class MainScreens(val route: String) {
data object HabitNavGraph: MainScreens("habits_nav_graph")

}