package com.nikolaej.cacademy.ui.screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikolaej.cacademy.dataSQL.Lesson
import com.nikolaej.cacademy.dataSQL.LessonRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class LessonsScreenViewModel(
    lessonRepository: LessonRepository
) : ViewModel() {

    private val moduleName: String = LessonsDestination.routeWithArgs

    val lessonUiState: StateFlow<LessonUiState> =
        lessonRepository.getAllLesson(moduleName).map { LessonUiState(it) }

            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = LessonUiState()
            )
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

data class LessonUiState(
    val lessonList: List<Lesson> = listOf()
)