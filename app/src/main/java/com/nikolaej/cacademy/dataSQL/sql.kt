package com.nikolaej.cacademy.dataSQL

import android.app.Application
import android.content.Context
import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.flow.Flow

@Entity(tableName = "lesson")
data class Lesson(
    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "nameLesson")
    val nameLesson: String,

    @ColumnInfo(name = "nameModule")
    val nameModule: String,

    @ColumnInfo(name = "passTheTask")
    val passTheTask: Boolean,

    @ColumnInfo(name = "Yes")
    val Yes: Boolean

)

@Dao
interface LessonDao{
    @Query("""
        SELECT  * FROM lesson;
    """)
    fun getAllModule(): Flow<List<Lesson>>

    @Query(
        """
            SELECT * FROM lesson
            where nameModule = :nameModule
            ORDER BY id ASC;
        """
    )
    fun getAllLesson(nameModule: String): Flow<List<Lesson>>


}

@Database(entities = arrayOf(Lesson::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun lessonDao(): LessonDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "lesson "
                )
                    .createFromAsset("db/lesson.db")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also {
                        INSTANCE = it
                    }
            }
        }
    }
}

class LessonViewModel(private val lessonDao: LessonDao): ViewModel() {
    fun getAll(): Flow<List<Lesson>> = lessonDao.getAllModule()

    fun getLesson(nameLesson: String): Flow<List<Lesson>> = lessonDao.getAllLesson(nameLesson)
    companion object {
        val factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as LessonApp)
                LessonViewModel(application.database.lessonDao())
            }
        }
    }
}


class LessonApp: Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}
