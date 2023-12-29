package com.eominik.habit.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.eominik.habit.model.HabitEntity

@Database(
    entities = [
        HabitEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(TypeConverter::class)
abstract class HabitDatabase : RoomDatabase() {

    abstract fun habitDao(): HabitDao

    companion object {

        @Volatile
        private var INSTANCE: HabitDatabase? = null

        fun getDataBase(context: Context): HabitDatabase {

                synchronized(this) {

                val tempInstance = INSTANCE
                if (tempInstance != null) {
                    return tempInstance
                }

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HabitDatabase::class.java,
                    "habit_database"
                ).build()

                INSTANCE = instance
                return instance
            }

        }
    }
}