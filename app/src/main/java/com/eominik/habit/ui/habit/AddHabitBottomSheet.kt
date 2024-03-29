package com.eominik.habit.ui.habit

import android.text.TextUtils
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.eominik.habit.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eominik.habit.model.HabitEntity
import com.eominik.habit.ui.theme.GreenBar
import com.eominik.habit.ui.theme.HabitTheme

@Composable
fun AddHabitBottomSheet(
    mHabitViewModel: HabitViewModel?,
    closeBottomSheetCallback: (Boolean) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 24.dp
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Create Habit",
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            IconButton(onClick = { closeBottomSheetCallback.invoke(true) }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_close),
                    contentDescription = "close"
                )
            }
        }

        Text(
            text = "Enter Habit Name",
            style = TextStyle(fontSize = 15.sp),
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 12.dp)
        )

        var textFieldState by remember { mutableStateOf("") }
        var focusManager = LocalFocusManager.current

        BasicTextField(value = textFieldState,
            onValueChange = { newText ->
                textFieldState = newText
            },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.LightGray,
                    shape = RoundedCornerShape(12.dp)
                ),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            )
        )

        Text(
            text = "Select Days per Week",
            style = TextStyle(fontSize = 15.sp),
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 24.dp, bottom = 12.dp)
        )

        var sliderPosition by remember { mutableStateOf(3f) }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "1", fontSize = 15.sp)
            Text(text = "2", fontSize = 15.sp)
            Text(text = "3", fontSize = 15.sp)
            Text(text = "4", fontSize = 15.sp)
            Text(text = "5", fontSize = 15.sp)
            Text(text = "6", fontSize = 15.sp)
            Text(text = "7", fontSize = 15.sp)
        }

        Slider(
            value = sliderPosition,
            valueRange = 1F..2F,
            steps = 5,
            onValueChange = { sliderPosition = it },
            colors = SliderDefaults.colors(
                thumbColor = GreenBar,
                activeTrackColor = GreenBar,
                inactiveTrackColor = GreenBar,
                activeTickColor = Color.White,
                inactiveTickColor = Color.White
            )
        )

        Button(
            onClick = {
                val habitName = textFieldState
                val targetDaysPerWeek = sliderPosition.toInt()

                if (inputCheck(habitName)) {
                    //Create Habit Object
                    val habitEntity = HabitEntity(0, habitName, targetDaysPerWeek, "",true)
                    // Add Data to Database
                    mHabitViewModel?.insertHabit(habitEntity)
                    closeBottomSheetCallback.invoke(true)
                } else {

                    //       Toast.makeText(this, "Please fill Habit Name field", Toast.LENGTH_LONG).show()
                }
            },
            colors = ButtonDefaults.buttonColors(Color.Black),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Create",
                modifier = Modifier.padding(vertical = 20.dp),
                style = TextStyle(fontSize = 16.sp),
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }

}


fun inputCheck(habitName: String): Boolean {
    return !(TextUtils.isEmpty(habitName))
}


@Preview(showBackground = true)
@Composable
fun AddHabitBottomSheetPreview() {
    HabitTheme {
        AddHabitBottomSheet(
            mHabitViewModel = null,
            closeBottomSheetCallback = { }
        )
    }
}