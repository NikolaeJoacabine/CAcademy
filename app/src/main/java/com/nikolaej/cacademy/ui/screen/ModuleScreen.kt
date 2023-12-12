package com.nikolaej.cacademy.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.exyte.animatednavbar.utils.noRippleClickable
import com.nikolaej.cacademy.dataSQL.Lesson
import com.nikolaej.cacademy.ui.CAcademyViewModel
import com.nikolaej.cacademy.ui.MainScreen

@Composable
fun ModuleScreen(
    module: List<Lesson>,
    nameModule: CAcademyViewModel,
    navController: NavHostController
) {
    var sosto: String? = ""

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(
            items = module,
            key = { module -> module.id }
        ) { module ->

            if (sosto != module.nameModule) {
                ModuleCard(
                name = module.nameModule,
                nameModule = nameModule,
                navController = navController
            )
                sosto = module.nameModule
            }
        }
    }
}

@Composable
fun ModuleCard(
    name: String,
    nameModule: CAcademyViewModel,
    navController: NavHostController
) {
    val haptic = LocalHapticFeedback.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .noRippleClickable  {
                nameModule.nameModule = name
                navController.navigate(MainScreen.Start.name)
                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
             }
    ) {
        Text(
            text = name,
            modifier = Modifier.padding(4.dp),

        )
    }
}