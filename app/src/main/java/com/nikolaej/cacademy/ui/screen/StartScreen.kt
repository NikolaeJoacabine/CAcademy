package com.nikolaej.cacademy.ui.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nikolaej.cacademy.data.lesson
import com.nikolaej.cacademy.ui.theme.CAcademyTheme

@Composable
fun LessonScreen(

){
    LazyColumn(

    ) {
        items(lesson){

        }
    }
}

@Composable
fun CardLesson(
    /*@StringRes nameLesson: Int,//название урока
    @StringRes description: Int,//описание урока
    countLesson: Int*/
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15)
    ){
        Text(
            text = "Урок 1: Введение, ",
            modifier = Modifier.padding(8.dp)
            )
    }
}

@Preview
@Composable
fun perw() {
    CAcademyTheme {
        CardLesson()
    }
}



