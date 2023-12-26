package com.eominik.habit.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.eominik.habit.model.Habit
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitDao {

    @Insert(onConflict =  OnConflictStrategy.IGNORE)
    suspend fun insertHabit(habit: Habit)

    @Query("SELECT * FROM habit ORDER BY id ASC")
    fun getAllData(): Flow<List<Habit>>

}