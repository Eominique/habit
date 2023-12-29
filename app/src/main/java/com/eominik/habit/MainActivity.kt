package com.eominik.habit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.eominik.habit.data.HabitDatabase
import com.eominik.habit.data.HabitRepositoryImpl
import com.eominik.habit.ui.habit.HabitScreen
import com.eominik.habit.ui.theme.HabitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HabitTheme {
                val navController = rememberNavController()
                val habitDao = HabitDatabase.getDataBase(application)
                    .habitDao()
                HabitScreen(
                    habitRepositoryImpl = HabitRepositoryImpl(habitDao),
                    navController = navController
                )


            }
        }
    }
}

