package com.eominik.habit.ui.habit

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HabitUI(
    val id: Long = 0,
    val name: String = "",
    val type: String = HabitType.SPIRITUALITY.pathName,
    val isCompleted: Boolean = false,
) : Parcelable