package com.nikolaej.cacademy.tipsTasck

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.exyte.animatednavbar.utils.noRippleClickable
import com.nikolaej.cacademy.ui.screen.LessonScreenViewModel
import java.util.Random


data class ToggleableInfo(
    var isChecked: Boolean = false,
    val text: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun task_with_a_choise(
    name: MutableList<ToggleableInfo>,
    question: String,
    count: Int,
    viewModel: LessonScreenViewModel,
    prog: Float
) {
    val sheetState = rememberModalBottomSheetState()
    var isSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }
    var animation by remember {
        mutableFloatStateOf(0f)
    }

    val progressAnimation by animateFloatAsState(
        targetValue = animation,
        animationSpec = tween(
            durationMillis = 500,
            easing = FastOutSlowInEasing
        ), label = ""
    )
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Column {
            Text(text = question, Modifier.padding(horizontal = 4.dp))
            Spacer(modifier = Modifier.size(20.dp))
            name.forEachIndexed { index, info ->
                Card(
                    modifier = Modifier
                        .noRippleClickable {
                            name.replaceAll {
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
                                name.replaceAll {
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
        Spacer(modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.BottomEnd
        ) {
            FloatingActionButton(
                onClick =
                { isSheetOpen = true },
                modifier = Modifier.padding(end = 10.dp, bottom = 10.dp)
            ) {
                Icon(
                    imageVector = Icons.Rounded.PlayArrow,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)

                )
            }
        }
    }

    if (isSheetOpen) {
        animation = 1f
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {
                if(name[count].isChecked){
                    isSheetOpen = false
                    viewModel.proff(prog)
                    viewModel.zadan += 1
                } else {
                    isSheetOpen = false
                    animation = 0f
                }
            },
            dragHandle = {},
            shape = RoundedCornerShape(0.dp)
        ) {
            when (name[count].isChecked) {
                true -> {
                    LinearProgressIndicator(
                        progress = progressAnimation,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(2.dp),
                        color = Color.Green

                    )
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Button(
                            onClick = {
                                isSheetOpen = false
                                viewModel.proff(prog)
                                viewModel.zadan += 1
                            },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(text = "Продолжить")
                        }
                    }
                }

                else -> {
                    LinearProgressIndicator(
                        progress = progressAnimation,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(2.dp),
                        color = Color.Red

                    )
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Row {
                            Button(
                                onClick = {
                                    isSheetOpen = false
                                    animation = 0f
                                },
                                modifier = Modifier.weight(1f),
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Text(text = "попробовать ещё раз")
                            }
                        }
                    }
                }
            }
        }
    }
}


