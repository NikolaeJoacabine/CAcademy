package com.nikolaej.cacademy.tipsTasck

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Backspace
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Replay
import androidx.compose.material.icons.sharp.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.exyte.animatednavbar.utils.noRippleClickable
import com.nikolaej.cacademy.ui.screen.LessonScreenViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Random
import kotlin.math.roundToInt


@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun lot_of_choise(
    variantCorrect: List<String>,
    youChoise: MutableList<String>,
    code: @Composable (() -> Unit)?,
    viewModel: LessonScreenViewModel,
    question: String,
    prog: Float
) {




//---------------------------------------------------------------------------------------------------------------------------------------------------------
    val sheetState = rememberModalBottomSheetState()
    var isSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }

    var animation by remember {
        mutableFloatStateOf(0f)
    }
    var isOpen by rememberSaveable {
        mutableStateOf(false)
    }

    val progressAnimation by animateFloatAsState(
        targetValue = animation, animationSpec = tween(
            durationMillis = 500, easing = FastOutSlowInEasing
        ), label = ""
    )

    Column(
        Modifier
            .fillMaxSize()

    ) {
        Column(
            Modifier.padding(4.dp)
        ) {
            Text(text = question, style = MaterialTheme.typography.bodySmall)
        }
        Column(
            Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp, 10.dp, 0.dp, 0.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .weight(1f)
                .border(
                    color = MaterialTheme.colorScheme.primary,
                    width = 1.dp,
                    shape = RoundedCornerShape(10.dp)
                )
                .weight(1f)
        ) {
            if (code != null) {
                code()
            }
        }
        AnimatedVisibility(visible = !isSheetOpen) {
            Card(
                shape = RoundedCornerShape(0.dp),
            ) {
                Column {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 6.dp)
                    ) {
                        IconButton(onClick = { isOpen = true }) {
                            Icon(imageVector = Icons.Rounded.Info, contentDescription = null)
                        }
                        IconButton(onClick = {
                            if (viewModel.varick.isNotEmpty()) {
                                viewModel.uuu.clear()
                                viewModel.varick.clear()

                            }
                        }) {
                            Icon(
                                imageVector = Icons.Rounded.Replay,
                                contentDescription = null,
                                modifier = if (viewModel.varick.isEmpty()) {
                                    Modifier.alpha(0.4f)
                                } else {
                                    Modifier.alpha(1f)
                                }
                            )
                        }
                        IconButton(onClick = {
                            if (viewModel.varick.isNotEmpty()) {
                                viewModel.uuu.remove(viewModel.uuu.last())
                                viewModel.varick.remove(viewModel.varick.last())
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Rounded.Backspace,
                                contentDescription = null,
                                modifier = if (viewModel.varick.isEmpty()) {
                                    Modifier.alpha(0.4f)
                                } else {
                                    Modifier.alpha(1f)
                                }
                            )
                        }
//----------------------------------------------------------------------------------------------------------------------------------------
                        Spacer(modifier = Modifier.weight(1f))
                        FloatingActionButton(
                            onClick = if (viewModel.varick.size == variantCorrect.size) {
                                {
                                    isSheetOpen = true
                                }
                            } else {
                                { }
                            },
                            modifier = if (viewModel.varick.size == variantCorrect.size) {
                                Modifier.alpha(1f)
                            } else {
                                Modifier.alpha(0.4f)
                            },
                            elevation = if (viewModel.varick.size == variantCorrect.size) {
                                FloatingActionButtonDefaults.elevation()
                            } else {
                                FloatingActionButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp)
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.PlayArrow,
                                contentDescription = null,
                                modifier = if (viewModel.varick.size == variantCorrect.size) {
                                    Modifier.size(40.dp)
                                } else {
                                    Modifier
                                        .size(40.dp)
                                        .alpha(0.4f)
                                }
                            )
                        }
                    }
                    FlowRow(
                        verticalArrangement = Arrangement.Center,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, top = 8.dp, end = 20.dp, bottom = 16.dp)
                    ) {

                        youChoise.forEachIndexed { index, it ->
                            AnimatedVisibility(visible = index !in viewModel.uuu) {
                                Card(
                                    modifier = if (viewModel.varick.size != variantCorrect.size) {
                                        Modifier
                                            .noRippleClickable {
                                                viewModel.varick.add(it)
                                                viewModel.uuu.add(index)
                                            }
                                            .padding(bottom = 8.dp, start = 3.dp, end = 3.dp)
                                    } else {
                                        Modifier
                                            .noRippleClickable { }
                                            .padding(bottom = 8.dp, start = 3.dp, end = 3.dp)
                                    },
                                    shape = RoundedCornerShape(6.dp),
                                    colors = if (viewModel.varick.size != variantCorrect.size) {
                                        CardDefaults.cardColors(
                                            containerColor = MaterialTheme.colorScheme.primary.copy(
                                                0.7f
                                            )
                                        )
                                    } else {
                                        CardDefaults.cardColors(
                                            containerColor = MaterialTheme.colorScheme.primary.copy(
                                                0.4f
                                            )
                                        )
                                    }
                                ) {
                                    Text(
                                        text = it,
                                        modifier = if (viewModel.varick.size != variantCorrect.size) {
                                            Modifier.padding(
                                                start = 10.dp,
                                                end = 10.dp,
                                                top = 0.dp,
                                                bottom = 6.dp
                                            )
                                        } else {
                                            Modifier
                                                .padding(
                                                    start = 10.dp,
                                                    end = 10.dp,
                                                    top = 0.dp,
                                                    bottom = 6.dp
                                                )
                                                .alpha(0.4f)
                                        },
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        if (isOpen){
            Dialog(onCancel = {
                 isOpen = false
            })
        }

        if (isSheetOpen) {
            animation = 1f
            ModalBottomSheet(
                sheetState = sheetState,
                onDismissRequest = {
                    if (variantCorrect == viewModel.varick) {
                        viewModel.uuu.clear()
                        isSheetOpen = false
                        viewModel.proff(prog)
                        viewModel.progress += 1

                    } else {
                        viewModel.varick.clear()
                        viewModel.uuu.clear()
                        isSheetOpen = false
                        animation = 0f
                    }
                },
                dragHandle = null,
                shape = RoundedCornerShape(0.dp)
            ) {
                if (variantCorrect == viewModel.varick) {
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
                                viewModel.uuu.clear()
                                viewModel.varick.clear()
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
                } else {
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
                                    viewModel.varick.clear()
                                    viewModel.uuu.clear()
                                    isSheetOpen = false
                                    animation = 0f
                                }, modifier = Modifier.weight(1f), shape = RoundedCornerShape(10.dp)
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

@Composable
fun Dialog(
    onCancel: () -> Unit,
) {
    AlertDialog(onDismissRequest = { onCancel() },
        title = {  },
        text = { Text("Чтобы выполнить данное задание, нужно нажать на элементы, которые находятся ниже, в нужном порядке") },
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
fun cartochca(
    viewModel: LessonScreenViewModel,
    index: Int
) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .background(MaterialTheme.colorScheme.onSecondary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = if (viewModel.varick.size - 1 < index) {
                " "
            } else {
                viewModel.varick[index]
            },
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.padding(horizontal = 5.dp)
        )
    }
}
