package com.nikolaej.cacademy.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.exyte.animatednavbar.utils.noRippleClickable
import com.nikolaej.cacademy.R
import com.nikolaej.cacademy.data.LessonInModule
import com.nikolaej.cacademy.data.lesson
import com.nikolaej.cacademy.ui.CAcademyViewModel
import com.nikolaej.cacademy.ui.theme.CAcademyTheme
import java.sql.Driver

@Composable

fun LessonScreenCard(
    gameViewModel: CAcademyViewModel
) {


    LazyColumn() {
        items(lesson) {
            CardLesson(
                lesson = it

            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardLesson(
    lesson: LessonInModule,

) {
    val sheetState = rememberModalBottomSheetState()
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }

    if(isSheetOpen) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = { isSheetOpen = false }
        ) {
            Column() {
                Text(text = stringResource(lesson.nameLesson))
                Divider()
                Spacer(modifier = Modifier.fillMaxSize())
                
            }

        }
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .noRippleClickable {
                isSheetOpen = true
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
        }
    }
}

@Preview
@Composable
fun perw() {
    CAcademyTheme {
        LessonScreenCard(viewModel())
    }
}



