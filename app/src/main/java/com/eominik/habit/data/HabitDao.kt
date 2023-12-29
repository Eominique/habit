package com.eominik.habit.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.eominik.habit.model.HabitEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitDao {

    @Insert(onConflict =  OnConflictStrategy.IGNORE)
    suspend fun insertHabit(habitEntity: HabitEntity)

    @Query("SELECT * FROM HabitEntity ORDER BY id ASC")
    fun getAllHabits(): List<HabitEntity>

    @Query("DELETE FROM HabitEntity WHERE id=:id")
    suspend fun deleteHabit(id: Long)

}