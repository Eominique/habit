package com.eominik.habit.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Habit(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val habitName: String,
    val targetWeekCheckCount: Int
)