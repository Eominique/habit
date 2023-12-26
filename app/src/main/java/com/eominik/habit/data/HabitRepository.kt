package com.eominik.habit.data

import com.eominik.habit.model.Habit

class HabitRepository(private val habitDao: HabitDao) {

    fun getAllData() = habitDao.getAllData()

    suspend fun insertHabit(habit: Habit) {
        habitDao.insertHabit(habit)
    }


}