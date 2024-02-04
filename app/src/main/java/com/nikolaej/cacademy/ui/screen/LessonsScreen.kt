package com.nikolaej.cacademy.ui.screen


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.exyte.animatednavbar.utils.noRippleClickable
import com.nikolaej.cacademy.ui.AppViewModelProvider
import com.nikolaej.cacademy.ui.CAcademyViewModel
import com.nikolaej.cacademy.ui.navigation.NavigationDestination


object LessonsDestination : NavigationDestination {
    override val route = "FullLesson"
    var routeWithArgs = ""
}

@Composable

fun LessonScreenCard(
    navController: NavController,
    viewModel: CAcademyViewModel,
    lessonViewModel: LessonsScreenViewModel = viewModel(factory = AppViewModelProvider.Factory),
) {
    val lessons by lessonViewModel.lessonUiState.collectAsState()

    val haptic = LocalHapticFeedback.current
    var isSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }

    var text by rememberSaveable {
        mutableStateOf("")
    }

    var pass1 by rememberSaveable {
        mutableStateOf(true)
    }

    var id by rememberSaveable {
        mutableIntStateOf(0)
    }
    if (LessonsDestination.routeWithArgs == "") {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Выберите модуль в верхней части экрана, чтобы отобразить уроки",
                textAlign = TextAlign.Center
            )
        }
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(
                items = lessons.lessonList,
                key = { lesson -> lesson.id }
            ) { module ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                        .noRippleClickable {
                            if (module.passTheTask) {
                                isSheetOpen = true
                            } else {
                                pass1 = false
                            }
                            id = module.id
                            text = module.nameLesson
                            haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        },
                    border = when (module.Yes) {
                        true -> BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
                        else -> BorderStroke(0.dp, MaterialTheme.colorScheme.secondaryContainer)
                    }

                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    ) {
                        Text(
                            text = module.nameLesson, modifier = Modifier.weight(10f),
                            color = when (module.Yes) {
                                true -> MaterialTheme.colorScheme.primary
                                else -> MaterialTheme.colorScheme.onSurfaceVariant
                            }
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        if (!module.passTheTask) {
                            Icon(imageVector = Icons.Filled.Lock, contentDescription = null)
                        }
                        if (module.Yes) {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }
            }
        }
    }

    if (isSheetOpen) {
        DialogWithImage(
            onDismissRequest = { isSheetOpen = false },
            text = text,
            navController = navController,
            vieweModel = viewModel,
            id = id
        )
    }

    if (!pass1) {
        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
        Dialog(onCancel = {
            pass1 = true
        }
        )
    }
}


@Composable
fun Dialog(
    onCancel: () -> Unit,
) {
    AlertDialog(onDismissRequest = { onCancel() },
        title = { Text("Ой!") },
        text = { Text("Вы не прошли предыдущие уроки") },
        dismissButton = {
            TextButton(onClick = onCancel) {
                Text(text = "Понятно")
            }
        },
        confirmButton = {
        }
    )
}


@Composable
fun DialogWithImage(
    onDismissRequest: () -> Unit,
    text: String,
    navController: NavController,
    vieweModel: CAcademyViewModel,
    id: Int
) {
    androidx.compose.ui.window.Dialog(onDismissRequest = { onDismissRequest() }) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Text(
                    text = text,
                    modifier = Modifier.padding(16.dp),
                )

                OutlinedButton(
                    onClick = {
                        LessonDestination.idlesson = id
                        onDismissRequest()
                        LessonDestination.nameLesson = text
                        navController.navigate(LessonDestination.route)
                    },
                    modifier = Modifier.padding(bottom = 8.dp),
                ) {
                    Text("Начать практиковаться")
                }
            }
        }
    }
}






