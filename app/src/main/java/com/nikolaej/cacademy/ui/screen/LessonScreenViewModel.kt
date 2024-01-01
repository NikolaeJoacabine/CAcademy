package com.nikolaej.cacademy.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikolaej.cacademy.dataSQL.LessonRepository
import kotlinx.coroutines.launch

class LessonScreenViewModel(private val lessonRepository: LessonRepository): ViewModel() {
    var selectTabIndex by mutableIntStateOf(0) //для переключения слайдов
    var progress by  mutableFloatStateOf(0f)//отображение для анимации прогресса

    val varick: MutableList<String> = mutableStateListOf()//тута мы сохраняем ответы пользователя, очистка происходит после каждого задания с типом выбора карточек

     fun update(pass: Int, yes: Int){
         viewModelScope.launch {
             lessonRepository.updatePass(pass)
             lessonRepository.updateYes(yes)
         }
    }
}