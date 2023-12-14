package com.nikolaej.cacademy.ui.screen


import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.exyte.animatednavbar.utils.noRippleClickable
import com.nikolaej.cacademy.dataSQL.Lesson
import com.nikolaej.cacademy.ui.CAcademyViewModel
import com.nikolaej.cacademy.ui.MainScreen


@Composable

fun LessonScreenCard(
    lesson: List<Lesson>,
    navController: NavController,
    viewModel: CAcademyViewModel
) {
    val haptic = LocalHapticFeedback.current
    var isSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }

    var text by rememberSaveable {
        mutableStateOf("")
    }

    var pass by rememberSaveable {
        mutableStateOf(false)
    }

    var pass1 by rememberSaveable {
        mutableStateOf(true)
    }
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(
            items = lesson,
            key = { lesson -> lesson.id }
        ) { module ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .noRippleClickable {
                        isSheetOpen = true
                        text = module.nameLesson
                        pass = module.passTheTask
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
                }
            }
        }
    }



    if (isSheetOpen) {
        DialogWithImage(
            onDismissRequest = { isSheetOpen = false },
            onConfirmation = { },
            text = text,
            navController = navController,
            vieweModel = viewModel
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
    AlertDialog(onDismissRequest = { },
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
    onConfirmation: () -> Unit,
    text: String,
    navController: NavController,
    vieweModel: CAcademyViewModel
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
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(16.dp),
                )

                OutlinedButton(
                    onClick = {
                        onDismissRequest()
                        vieweModel.namelesson = text
                        navController.navigate(MainScreen.Lesson.name)
                    },
                    modifier = Modifier.padding(bottom = 8.dp),
                ) {
                    Text("Начать практиковаться")
                }


            }
        }
    }
}






