package com.eominik.habit.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.eominik.habit.MainScreen
import com.eominik.habit.ui.theme.HabitTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HabitTheme {
                MainScreen()
            }
        }
    }
}

