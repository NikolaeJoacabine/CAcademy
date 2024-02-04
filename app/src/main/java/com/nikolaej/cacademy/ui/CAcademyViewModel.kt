package com.nikolaej.cacademy.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class CAcademyViewModel: ViewModel() {
    var selectedIndex by mutableIntStateOf(0)
        internal set

    var topBarState by mutableStateOf (true)

    var bottomBarState by mutableStateOf (true)

    var IndexModalBottomSheets by mutableStateOf(false)


}