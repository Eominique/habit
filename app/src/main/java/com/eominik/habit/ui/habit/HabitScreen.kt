package com.eominik.habit.ui.habit

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.eominik.habit.data.HabitRepositoryImpl
import com.eominik.habit.R
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HabitScreen(
    navController: NavController,
    viewModel: HabitViewModel = hiltViewModel()
) {
    val habitsUIState by viewModel.habitsUIState.collectAsState()

    Scaffold(

    ) {

    }

}

