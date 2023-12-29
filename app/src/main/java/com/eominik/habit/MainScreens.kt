package com.eominik.habit

sealed class MainScreens(val route: String) {
data object HabitNavGraph: MainScreens("habits_nav_graph")

}