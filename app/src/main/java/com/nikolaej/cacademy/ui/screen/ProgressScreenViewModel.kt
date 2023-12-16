package com.nikolaej.cacademy.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikolaej.cacademy.dataSQL.LessonRepository
import kotlinx.coroutines.Delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.time.delay

class ProgressScreenViewModel(private val lessonRepository: LessonRepository) : ViewModel() {

    private var progressUiState by mutableIntStateOf(0)

    fun progress():Int {
        viewModelScope.launch {
            kotlinx.coroutines.delay(500)
            progressUiState  = lessonRepository.getProgress()
        }
        return progressUiState
    }
}