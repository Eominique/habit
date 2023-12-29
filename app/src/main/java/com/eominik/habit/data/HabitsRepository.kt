package com.eominik.habit.data

import com.eominik.habit.model.Habit
import java.util.concurrent.Flow

interface HabitsRepository {
    suspend fun insertHabit(habit: Habit)
    suspend fun deleteHabit(id: Long)
    suspend fun getAllHabits(): List<Habit>


}
