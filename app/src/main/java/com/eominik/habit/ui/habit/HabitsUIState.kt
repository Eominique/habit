package com.eominik.habit.ui.habit

data class HabitsUIState(
    val isLoading: Boolean = true,
    val isSuccessful: Boolean = false,
    val isError: Boolean = false,
    val habits: List<HabitUI> = emptyList(),
)