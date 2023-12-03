package com.nikolaej.cacademy.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LessonViewModel: ViewModel() {
    var selectTabIndex by mutableIntStateOf(0)
    var progress by   mutableFloatStateOf(0f)

}