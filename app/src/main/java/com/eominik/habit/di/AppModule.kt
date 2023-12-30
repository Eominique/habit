package com.eominik.habit.di

import android.content.Context
import com.eominik.habit.data.HabitDao
import com.eominik.habit.data.HabitDatabase
import com.eominik.habit.data.HabitDatabaseFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

@Singleton
@Provides
fun providesDatabase(
@ApplicationContext appContext: Context
): HabitDatabase{
    return HabitDatabaseFactory.roomDatabase(appContext)
}

    @Singleton
    @Provides
    fun providesHabitDao(database: HabitDatabase): HabitDao{
return  database.habitDao()
    }




}