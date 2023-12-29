package com.eominik.habit.data

import com.eominik.habit.model.Habit
import com.eominik.habit.model.toHabitEntity
import com.eominik.habit.model.toHabits
import javax.inject.Inject

class HabitRepositoryImpl @Inject constructor(
    private val habitDao: HabitDao
) : HabitsRepository {

    override suspend fun insertHabit(habit: Habit) {
        habitDao.insertHabit(habit.toHabitEntity())
    }

    override suspend fun deleteHabit(id: Long) {
        habitDao.deleteHabit(id)
    }

    override suspend fun getAllHabits(): List<Habit> {
        return habitDao.getAllHabits().toHabits()
    }


}