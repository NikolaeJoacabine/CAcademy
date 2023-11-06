package com.nikolaej.cacademy.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CAcademyViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CAcademyUiState())
    val uiState: StateFlow<CAcademyUiState> = _uiState.asStateFlow()

    var selectedIndex by mutableStateOf(0)
        internal set

}