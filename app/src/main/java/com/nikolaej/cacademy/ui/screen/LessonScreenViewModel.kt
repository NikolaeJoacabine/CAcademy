package com.nikolaej.cacademy.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikolaej.cacademy.dataSQL.LessonRepository
import kotlinx.coroutines.launch

class LessonScreenViewModel(private val lessonRepository: LessonRepository): ViewModel() {
    var selectTabIndex by mutableIntStateOf(0)
    var progress by  mutableFloatStateOf(0f)

     fun update(pass: Int, yes: Int){
         viewModelScope.launch {
             lessonRepository.updatePass(pass)
             lessonRepository.updateYes(yes)
         }
    }
}