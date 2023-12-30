package com.eominik.habit.ui.habit

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eominik.habit.ui.theme.Black
import com.eominik.habit.R
import com.eominik.habit.ui.theme.MainColor

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HabitItem(
    modifier: Modifier,
    habit: HabitUI,
    onHabitLongClicked: ((Long, String, String) -> Unit)?,
    onHabitCheckedChange: ((Long, Boolean) -> Unit)?,
) {

    Card(
        modifier = modifier
            .padding(start = 12.dp, end = 16.dp, bottom = 12.dp)
            .fillMaxWidth()
            .size(58.dp)
            .combinedClickable(
                onLongClick = {
                    onHabitLongClicked?.invoke(
                        habit.id,
                        habit.name,
                        habit.type,
                    )
                },
                onClick = {}
            ),
        backgroundColor = MainColor,
        elevation = 0.dp,
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CheckboxIcon(
                isCompleted = habit.isCompleted,
                onClick = {
                    if (onHabitCheckedChange != null) {
                        onHabitCheckedChange(
                            habit.id,
                            !habit.isCompleted
                        )
                    }
                }
            )
            HabitTitle(
                title = habit.name,
                isCompleted = habit.isCompleted,
                modifier = Modifier.padding(start = 8.dp, end=16.dp)
            )
        }
    }

}


@Composable
private fun CheckboxIcon(
    isCompleted: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(start = 16.dp)
            .size(19.dp)
            .clip(CircleShape)
            .background(
                color = if (isCompleted) Color.Black else Color.Transparent,
                shape = CircleShape
            )
            .clickable(onClick = onClick)
            .border(
                width = 2.dp,
                color = Black,
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        if (isCompleted) {
            Icon(
                painter = painterResource(id = R.drawable.ic_check_arrow),
                contentDescription = stringResource(id = R.string.checked_icon_description),
                tint = Color.White
            )
        }
    }
}

@Composable
fun HabitTitle(
    title: String,
    isCompleted: Boolean,
    modifier: Modifier = Modifier,
) {
    Text(
        text = title,
        modifier = modifier,
        style = TextStyle(
            fontFamily = FontFamily(Font(R.font.almarai_bold)),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Black,
            textDecoration = if (isCompleted) TextDecoration.LineThrough else TextDecoration.None,
        ),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}


@Preview(showBackground = true)
@Composable
private fun HabitItemPreview() {
    HabitItem(
        modifier = Modifier,
        habit = HabitUI(),
        onHabitLongClicked = null,
        onHabitCheckedChange = null
    )
}

