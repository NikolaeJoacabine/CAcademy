package com.nikolaej.cacademy.dataSQL

import kotlinx.coroutines.flow.Flow

interface LessonRepository {
    fun getAllModule(): Flow<List<Lesson>>
    fun getAllLesson(nameModule: String): Flow<List<Lesson>>
    suspend fun updateYes(id: Int)
    suspend fun updatePass(id: Int)
    suspend fun getProgress(): Int
}