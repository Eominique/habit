package com.eominik.habit.ui.habit

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.*
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.eominik.habit.data.HabitRepositoryImpl
import com.eominik.habit.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HabitScreen(
    modifier: Modifier = Modifier,
    habitRepositoryImpl: HabitRepositoryImpl,
    navController: NavController,
    viewModel: HabitViewModel = viewModel(
        factory = HabitViewModelFactory(habitRepositoryImpl)
    ),
) {

    val sheetState = rememberModalBottomSheetState()
//    val bottomSheetState = rememberSheetState()
//    val bottomSheetState = rememberSheetState()
    val scaffoldState =
        rememberBottomSheetScaffoldState(bottomSheetState = sheetState)
    val scope = rememberCoroutineScope()

    BottomSheetScaffold(
         sheetPeekHeight = 0.dp,
        scaffoldState = scaffoldState,
        sheetContent = {
            AddHabitBottomSheet(viewModel, closeBottomSheetCallback = {
                scope.launch {
    // Here
                    sheetState.expand()
                }
            })
        }
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Habits",
                    style = TextStyle(fontSize = 24.sp),
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Cursive
                )

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = "add habit",
                    tint = Color.DarkGray,
                    modifier = Modifier
                        .size(28.dp)
                        .clickable {
                            scope.launch {
           // Here problems
                                if (sheetState.isVisible) {
                                    sheetState.expand()
                                } else {
                                    sheetState.hide()
                                }
                            }
                        }
                )

                Icon(
                    modifier = Modifier.padding(start = 16.dp),
                    painter = painterResource(id = R.drawable.ic_filter),
                    contentDescription = "add habit",
                    tint = Color.DarkGray
                )
            }

            Divider(Modifier.padding(vertical = 16.dp))

            val habits by viewModel.habitsData.observeAsState()
            LazyColumn {
                items(items = habits ?: arrayListOf()) { habit ->
                    HabitItem(habitEntity = habit)
                }
            }
        }
    }
}

//
//@Preview(showBackground = true)
//@Composable
//fun HabitsScreenPreview() {
//    HabitScreen()
//}
