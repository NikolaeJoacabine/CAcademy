package com.nikolaej.cacademy.ui.screen

import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.exyte.animatednavbar.utils.noRippleClickable
import com.nikolaej.cacademy.R
import com.nikolaej.cacademy.data.LessonInModule
import com.nikolaej.cacademy.data.items
import com.nikolaej.cacademy.data.lesson
import com.nikolaej.cacademy.ui.theme.CAcademyTheme
import java.time.format.TextStyle

@Composable
fun LessonScreen() {
    LazyColumn() {
        items(lesson) {
            CardLesson(
                lesson = it
            )
        }
    }
}

@Composable
fun CardLesson(
    lesson: LessonInModule
) {

    var ddd by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .noRippleClickable {
                ddd = !ddd
            },
        shape = RoundedCornerShape(15)
    ) {
        Column {
            Row(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = stringResource(R.string.lesson),
                )
                Spacer(modifier = Modifier.size(5.dp))
                Text(
                    text = lesson.countLesson.toString()
                )
                Spacer(modifier = Modifier.size(3.dp))
                Text(text = ": ")
                Text(text = stringResource(lesson.nameLesson), fontWeight = FontWeight.W600)

            }
            AnimatedVisibility(visible = ddd) {
                Text(text = stringResource(lesson.description), )
            }
        }
    }
}

@Preview
@Composable
fun perw() {
    CAcademyTheme {
        LessonScreen()
    }
}



