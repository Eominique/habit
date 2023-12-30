package com.eominik.habit

sealed class Screen(val route: String) {
    object Habits: Screen("habits")
    object HabitAdd: Screen("add_habit")
}