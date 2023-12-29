package com.eominik.habit.model

import com.eominik.habit.model.EntityConstant.NEXT_RESET_DATE_HABIT
import java.util.Date

data class Habit(
    val id: Long,
    val habitName: String,
    val targetWeekCheckCount: Int,
    val type: String,
    val isCompleted: Boolean,
    val nextResetDate: Date = NEXT_RESET_DATE_HABIT,
)