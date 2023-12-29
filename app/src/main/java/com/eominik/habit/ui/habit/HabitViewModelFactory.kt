package com.eominik.habit.ui.habit

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eominik.habit.data.HabitRepositoryImpl

class HabitViewModelFactory(
    private val habitRepositoryImpl: HabitRepositoryImpl?
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HabitViewModel(
            habitRepositoryImpl = habitRepositoryImpl!!,
            application = Application()) as T
    }
}