package com.eominik.habit.ui.habit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eominik.habit.model.HabitEntity
import com.eominik.habit.ui.theme.GreenBar
import com.eominik.habit.ui.theme.LightGrayBackground

@Composable
fun HabitItem(
    habitEntity: HabitEntity,
    modifier: Modifier = Modifier,
) {

    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            val checkedState = remember { mutableStateOf(true) }

            Checkbox(
                checked = checkedState.value,
                onCheckedChange = {},
                colors = CheckboxDefaults.colors(Color.Green)
            )

            Column(
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(
                    text = habitEntity.habitName,
                    fontSize = 15.sp
                )
            }
            Spacer(modifier = Modifier.weight(1f))

            Counter(
                lastWeekCheckCount = 0,
                targetWeekCheckCount = habitEntity.targetWeekCheckCount
            )
        }

        Box(
            modifier = Modifier.padding(top = 2.dp, bottom = 8.dp)
        ) {
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = LightGrayBackground,
                        shape = RoundedCornerShape(20.dp)
                    )
            )

            Divider(
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .background(
                        color = GreenBar,
                        shape = RoundedCornerShape(20.dp)
                    )
            )
        }


    }


}


@Composable
private fun Counter(
    lastWeekCheckCount: Int,
    targetWeekCheckCount: Int
) {
    Box(
        modifier = Modifier
            .background(LightGrayBackground, shape = RoundedCornerShape(12.dp))
            .padding(8.dp)
    ) {

        Text(text = "${lastWeekCheckCount}/${targetWeekCheckCount}")

    }
}


@Preview(showBackground = true)
@Composable
private fun HabitItemPreview() {
    HabitItem(previewHabitItemEntity)
}

private val previewHabitItemEntity = HabitEntity(
    id = 0,
    habitName = "Name",
    targetWeekCheckCount = 0,
    "",
    true
)