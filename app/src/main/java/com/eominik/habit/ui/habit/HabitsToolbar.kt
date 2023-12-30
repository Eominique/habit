package com.eominik.habit.ui.habit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eominik.habit.ui.theme.HabitTheme
import com.eominik.habit.R

@Composable
fun HabitsToolbar(
    title: String,
    onAddHabitClickedIcon: () -> Unit
) {
    TopAppBar(
        backgroundColor = Color.White,
        elevation = 0.dp,
        modifier = Modifier.height(60.dp),
        title = {
            Text(
                text = title,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    color = Color.Black,
                ),
            )
        },
        actions = {
            Box(modifier = Modifier.padding(end = 16.dp)) {
                IconButton(
                    onClick = { onAddHabitClickedIcon },
                    modifier = Modifier
                        .background(Color.Gray, CircleShape)
                        .size(34.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = "Add new habit"
                    )
                }
            }
        }
    )
}


@Preview
@Composable
fun HabitsToolbarPreview() {
    HabitTheme {
        HabitsToolbar(
            title = "",
           onAddHabitClickedIcon =  {}
        )
        }
    }



