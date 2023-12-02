package com.nikolaej.cacademy.ui.screen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.exyte.animatednavbar.utils.noRippleClickable
import com.nikolaej.cacademy.R
import com.nikolaej.cacademy.dataSQL.Lesson
import com.nikolaej.cacademy.ui.MainScreen
import java.sql.Driver


@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun LessonScreenCard(
    lesson: List<Lesson>,
    navController: NavController
) {
    var isSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }
    val sheetState = rememberModalBottomSheetState()

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
                    }

            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 8.dp)
                ) {
                    Text(
                        text = stringResource(R.string.lesson),
                    )
                    Text(text = ": ")
                    Text(text = module.id.toString(), fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.weight(1f))
                    if (!module.passTheTask) {
                        Icon(imageVector = Icons.Filled.Lock, contentDescription = null)
                    }
                }
            }
        }
    }

    if (isSheetOpen) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {
                isSheetOpen = false
            }
        ) {
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = text,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Divider()
                Row(modifier = Modifier.padding(start = 10.dp)) {
                    Spacer(modifier = Modifier.weight(1f))
                    OutlinedButton(
                        onClick = {
                            if (pass) {
                                isSheetOpen = false
                                navController.navigate(MainScreen.Lesson.name)
                            } else {
                                pass1 = false
                            }
                        },
                    ) {
                        Text(
                            text = "Начать урок",
                        )
                    }
                }
            }
        }

        if (!pass1) {
            Dialog(onCancel = {
                pass1 = true
                isSheetOpen = false
            }
            )
        }
    }
}


@Composable
fun Dialog(
    onCancel: () -> Unit,
) {
    AlertDialog(onDismissRequest = { /* Do nothing */ },
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


