package com.eominik.habit.ui.habit.add_habit

import androidx.navigation.NavController
import com.eominik.habit.Screen

fun NavController.navigateToAddHabit(){
    navigate(Screen.HabitAdd.route)
}