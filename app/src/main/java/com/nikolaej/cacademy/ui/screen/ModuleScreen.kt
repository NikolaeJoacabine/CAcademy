package com.nikolaej.cacademy.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.exyte.animatednavbar.utils.noRippleClickable
import com.nikolaej.cacademy.dataSQL.Lesson
import com.nikolaej.cacademy.ui.AppViewModelProvider
import com.nikolaej.cacademy.ui.CAcademyViewModel
import com.nikolaej.cacademy.ui.navigation.NavigationDestination




@Composable
fun ModuleScreen(
    moduleViewModel: ModuleScreenViewModel,
    navigateToItemUpdate: () -> Unit,
    module: ModuleUiState
) {





    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {

        ModuleList(
            moduleList = module.moduleList,
            onModuleClick = { navigateToItemUpdate() }
        )
    }
}

@Composable
private fun ModuleList(
    moduleList: List<Lesson>,
    onModuleClick: () -> Unit,
) {

    val haptic = LocalHapticFeedback.current
    var sosto: String? = ""


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(end = 8.dp)
    ) {
        items(
            items = moduleList,
            key = { module -> module.id }
        ) { module ->

            if (sosto != module.nameModule) {

                ModuleCard(
                    name = module.nameModule,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                        .noRippleClickable {
                            LessonsDestination.routeWithArgs = module.nameModule
                            onModuleClick()
                            haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        }
                )
                sosto = module.nameModule
            }
        }
    }
}

@Composable
fun ModuleCard(
    name: String,
    modifier: Modifier,

) {


    Card(
        modifier = modifier
    ) {

            Text(
                text = name,
                modifier = Modifier.padding(4.dp),
            )

    }
}