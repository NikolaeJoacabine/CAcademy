package com.nikolaej.cacademy.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class CAcademyViewModel: ViewModel() {
    var selectedIndex by mutableStateOf(0)
        internal set

}



