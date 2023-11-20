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
        ),
    LessonInModule(
        nameLesson = R.string.lesson_vvedenie_2,
        description = R.string.leson_vvedenie_2_description,
        countLesson = 2
    ),
    LessonInModule(
        nameLesson = R.string.lesson_vvedenie_3,
        description = R.string.leson_vvedenie_3_description,
        countLesson = 3
    ),
    LessonInModule(
        nameLesson = R.string.lesson_vvedenie_4,
        description = R.string.leson_vvedenie_4_description,
        countLesson = 4
    ),
    LessonInModule(
        nameLesson = R.string.lesson_vvedenie_5,
        description = R.string.lesson_vvedenie_5_description,
        countLesson = 5
    ),
    LessonInModule(
        nameLesson = R.string.lesson_vvedenie_6,
        description = R.string.lesson_vvedenie_6_description,
        countLesson = 6
    ),LessonInModule(
        nameLesson = R.string.lesson_vvedenie_7,
        description = R.string.lesson_vvedenie_7_description,
        countLesson = 7
    ),LessonInModule(
        nameLesson = R.string.lesson_vvedenie_8,
        description = R.string.lesson_vvedenie_8_description,
        countLesson = 8
    ),LessonInModule(
        nameLesson = R.string.lesson_vvedenie_9,
        description = R.string.lesson_vvedenie_9_description,
        countLesson = 9
    ),LessonInModule(
        nameLesson = R.string.lesson_vvedenie_10,
        description = R.string.lesson_vvedenie_10_description,
        countLesson = 10
    ),LessonInModule(
        nameLesson = R.string.lesson_vvedenie_11,
        description = R.string.lesson_vvedenie_11_description,
        countLesson = 11
    ),LessonInModule(
        nameLesson = R.string.lesson_vvedenie_12,
        description = R.string.lesson_vvedenie_12_description,
        countLesson = 12
    ),LessonInModule(
        nameLesson = R.string.lesson_vvedenie_13,
        description = R.string.lesson_vvedenie_13_description,
        countLesson = 13
    ),LessonInModule(
        nameLesson = R.string.lesson_vvedenie_14,
        description = R.string.lesson_vvedenie_14_description,
        countLesson = 15
    ),LessonInModule(
        nameLesson = R.string.lesson_vvedenie_15,
        description = R.string.lesson_vvedenie_15_description,
        countLesson = 16
    ),LessonInModule(
        nameLesson = R.string.lesson_vvedenie_16,
        description = R.string.lesson_vvedenie_16_description,
        countLesson = 17
    ),


)