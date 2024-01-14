package com.nikolaej.cacademy.dataSQL

import kotlinx.coroutines.flow.Flow

class OfflineLessonRepository(private val lessonDao: LessonDao):LessonRepository{
    override fun getAllModule(): Flow<List<Lesson>> = lessonDao.getAllModule()

    override fun getAllLesson(nameModule: String): Flow<List<Lesson>> = lessonDao.getAllLesson(nameModule)

    override suspend fun updateYes(id: Int) = lessonDao.updateYes(id)

    override suspend fun updatePass(id:Int) = lessonDao.updatePass(id)

    override suspend fun getProgress(): Int = lessonDao.getProgress()

    override suspend fun counttt(name: String): Int = lessonDao.counttt(name)
    override suspend fun progress(name: String): Int = lessonDao.progress(name)
}