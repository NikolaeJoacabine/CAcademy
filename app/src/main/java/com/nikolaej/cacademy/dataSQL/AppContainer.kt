package com.nikolaej.cacademy.dataSQL

import android.content.Context

interface AppContainer {
    val lessonRepository: LessonRepository
}

class AppDataContainer(private val context: Context) : AppContainer {

    override val lessonRepository: LessonRepository by lazy {
        OfflineLessonRepository(LessonDatabase.getDatabase(context).lessonDao())
    }
}