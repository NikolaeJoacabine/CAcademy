package com.nikolaej.cacademy.dataSQL

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lesson")
data class Lesson(
    @PrimaryKey
    val id: Int,
    val nameLesson: String,
    val nameModule: String,
    val passTheTask: Boolean,
    val Yes: Boolean

)