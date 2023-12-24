package com.nikolaej.cacademy.dataSQL

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Lesson::class, User::class], version = 1 )
abstract class LessonDatabase: RoomDatabase() {
    abstract fun lessonDao(): LessonDao

    companion object {
        @Volatile
        private var INSTANCE: LessonDatabase? = null
        fun getDatabase(context: Context): LessonDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    LessonDatabase::class.java,
                    "lesson "
                )
                    .createFromAsset("db/lesson.db")
                    .build()
                    .also {
                        INSTANCE = it
                    }
            }
        }
    }
}