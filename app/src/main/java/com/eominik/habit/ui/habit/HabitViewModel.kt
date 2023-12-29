package com.eominik.habit.ui.habit

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.eominik.habit.data.HabitRepositoryImpl
import com.eominik.habit.model.HabitEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HabitViewModel(
    private val habitRepositoryImpl: HabitRepositoryImpl,
    application: Application
) : AndroidViewModel(application) {

    private val _habitsData = MutableLiveData<List<HabitEntity>>()
    val habitsData: LiveData<List<HabitEntity>> = _habitsData

    init {
        loadData()
    }

    fun loadData() {
        viewModelScope.launch {
        //    habitRepositoryImpl.getAllHabits().collect {
        //        _habitsData.postValue(it)
            }
        }


    fun insertHabit(habitEntity: HabitEntity) {
 //       viewModelScope.launch(Dispatchers.IO) {
//            habitRepositoryImpl.insertHabit(habitEntity)
//        }
    }


}