package com.eominik.habit.ui.habit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eominik.habit.data.HabitRepositoryImpl
import com.eominik.habit.model.HabitEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HabitViewModel  @Inject constructor(
    private val habitRepositoryImpl: HabitRepositoryImpl

) : ViewModel() {

    private val _habitsUIState = MutableStateFlow(HabitsUIState())
    val habitsUIState: StateFlow<HabitsUIState> get() = _habitsUIState

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