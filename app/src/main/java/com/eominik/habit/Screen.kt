package com.eominik.habit

sealed class Screen(val route: String) {
    data object Habits: Screen("habits")
}