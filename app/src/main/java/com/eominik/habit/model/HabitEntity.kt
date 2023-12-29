package com.eominik.habit.model

import java.util.Date
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.eominik.habit.model.EntityConstant.NEXT_RESET_DATE_HABIT

@Entity
data class HabitEntity(

    @PrimaryKey(autoGenerate = true)
    val id:Long =0,
    val habitName: String,
    val targetWeekCheckCount: Int,
    val type: String,
    val isCompleted: Boolean,
    val nextResetDate: Date = NEXT_RESET_DATE_HABIT,

    )