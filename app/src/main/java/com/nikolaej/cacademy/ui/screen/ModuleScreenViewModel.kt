package com.nikolaej.cacademy.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikolaej.cacademy.dataSQL.Lesson
import com.nikolaej.cacademy.dataSQL.LessonRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class ModuleScreenViewModel(lessonRepository: LessonRepository) : ViewModel() {

    val moduleUiState: StateFlow<ModuleUiState> =
        lessonRepository.getAllModule().map { ModuleUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = ModuleUiState()
            )

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

data class ModuleUiState(val moduleList: List<Lesson> = listOf())