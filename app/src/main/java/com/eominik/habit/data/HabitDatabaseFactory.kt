package com.eominik.habit.data

import android.content.Context
import androidx.room.Room
import com.eominik.habit.data.DatabaseConstant.DATABASE_ASSET_PATH
import com.eominik.habit.data.DatabaseConstant.DATABASE_NAME

object HabitDatabaseFactory {

    fun roomDatabase(context: Context) = Room.databaseBuilder(
        context,
        HabitDatabase::class.java,
        DATABASE_NAME
    ).createFromAsset(DATABASE_ASSET_PATH)
//    .addMigrations()
        .build()

}