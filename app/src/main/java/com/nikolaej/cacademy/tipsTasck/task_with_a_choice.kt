package com.nikolaej.cacademy.tipsTasck

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exyte.animatednavbar.utils.noRippleClickable
import com.nikolaej.cacademy.ui.theme.CAcademyTheme


data class ToggleableInfo(
    val isChecked: Boolean = false,
    val text: String
)

@Composable
fun task_with_a_choise(
    name: SnapshotStateList<ToggleableInfo>,
    question: String,
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(4.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(text = "Выберите правильный вариант ответа")
        RadioButtons(radioButtons = name)
    }
}

@Composable
private fun RadioButtons(
    radioButtons: SnapshotStateList<ToggleableInfo>
) {

    radioButtons.forEachIndexed { index, info ->
        Card(
            modifier = Modifier
                .noRippleClickable {
                    radioButtons.replaceAll {
                        it.copy(
                            isChecked = it.text == info.text
                        )
                    }
                }
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 4.dp),
            border = if (info.isChecked) {
                BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
            } else {
                BorderStroke(0.dp, Color.Transparent)
            }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(end = 16.dp)
            ) {
                RadioButton(
                    selected = info.isChecked,
                    onClick = {
                        radioButtons.replaceAll {
                            it.copy(
                                isChecked = it.text == info.text
                            )
                        }
                    }
                )
                Text(text = info.text)
            }
        }
    }
}


@Preview
@Composable
fun ggg() {
    CAcademyTheme {
        val radioButtons = remember {
            mutableStateListOf(
                ToggleableInfo(
                    isChecked = true,
                    text = "Привет"
                ),
                ToggleableInfo(
                    isChecked = false,
                    text = "Пока"
                ),
                ToggleableInfo(
                    isChecked = false,
                    text = "Как дела?"
                ),
            )
        }
        task_with_a_choise(radioButtons, "привет")
    }
}