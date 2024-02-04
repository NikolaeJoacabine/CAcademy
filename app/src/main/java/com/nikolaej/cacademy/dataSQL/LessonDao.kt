package com.nikolaej.cacademy.dataSQL

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface LessonDao{
    @Query("""
        SELECT Distinct(nameModule), * FROM lesson;
    """)
    fun getAllModule(): Flow<List<Lesson>>

    @Query(
        """
            SELECT * FROM lesson
            where nameModule = :nameModule
            ORDER BY countInModule ASC;
        """
    )
    fun getAllLesson(nameModule: String): Flow<List<Lesson>>

    @Query(
        """
            UPDATE lesson
            set Yes = true
            where id = :id
        """
    )
    suspend fun updateYes(id: Int)

    @Query(
        """
            UPDATE lesson
            set passTheTask = true
            where id = :id
        """
    )
    suspend fun updatePass(id: Int)

    @Query(
        """
            SELECT COUNT(*) FROM lesson
            where Yes = 1
        """
    )
    suspend fun getProgress():Int
}