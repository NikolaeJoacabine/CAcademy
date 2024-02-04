package com.nikolaej.cacademy.ui

import android.text.Spannable.Factory
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.nikolaej.cacademy.AcademyApplication
import com.nikolaej.cacademy.ui.screen.LessonScreenViewModel
import com.nikolaej.cacademy.ui.screen.LessonsScreenViewModel
import com.nikolaej.cacademy.ui.screen.ModuleScreenViewModel
import com.nikolaej.cacademy.ui.screen.ProgressScreenViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            ModuleScreenViewModel(inventoryApplication().container.lessonRepository)
        }
        initializer {
            LessonsScreenViewModel(
                inventoryApplication().container.lessonRepository
            )
        }
        initializer {
            ProgressScreenViewModel(
                inventoryApplication().container.lessonRepository
            )
        }
        initializer {
            LessonScreenViewModel(
                inventoryApplication().container.lessonRepository
            )
        }
    }
}

fun CreationExtras.inventoryApplication(): AcademyApplication =
    (this[APPLICATION_KEY] as AcademyApplication)