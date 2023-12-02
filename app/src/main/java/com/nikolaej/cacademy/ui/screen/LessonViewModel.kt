package com.nikolaej.cacademy.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LessonViewModel: ViewModel() {
    var selectTabIndex by mutableStateOf(0)

}