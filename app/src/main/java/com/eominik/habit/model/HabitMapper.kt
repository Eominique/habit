package com.eominik.habit.model

internal fun Habit.toHabitEntity(): HabitEntity {
    return HabitEntity(id,  habitName,targetWeekCheckCount,  type, isCompleted, nextResetDate)
}

internal fun List<Habit>.toHabitsEntities(): List<HabitEntity> {
    return map { it.toHabitEntity() }
}

internal fun HabitEntity.toHabit(): Habit {
    return Habit(id, habitName,targetWeekCheckCount ,type, isCompleted, nextResetDate)
}

internal fun List<HabitEntity>.toHabits(): List<Habit> {
    return map { it.toHabit() }
}