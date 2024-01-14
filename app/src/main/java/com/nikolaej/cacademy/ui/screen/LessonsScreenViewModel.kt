package com.nikolaej.cacademy.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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
import kotlinx.coroutines.launch

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