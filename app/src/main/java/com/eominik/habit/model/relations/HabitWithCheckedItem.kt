package com.eominik.habit.model.relations

import com.eominik.habit.model.CheckedItem

data class HabitWithCheckedItem(
    val checkedItems: List<CheckedItem>
)
