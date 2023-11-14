package com.nikolaej.cacademy.data

import androidx.annotation.StringRes
import com.nikolaej.cacademy.R

data class LessonInModule(
    @StringRes val nameLesson: Int,//название урока
    @StringRes val description: Int,//описание урока
    val countLesson: Int //номер урока по счёту
)

//список для хранения уроков в модулях(потом надо будет переделать под автоматизмб, чтобы был один список(себе на заметку))

val lesson = listOf(
    LessonInModule(
        nameLesson = R.string.lesson_vvedenie_1,
        description = R.string.lesson_vvedenie_1_description,
        countLesson = 1
        )

)