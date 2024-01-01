package com.nikolaej.cacademy.tipsTasck

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AcUnit
import androidx.compose.material.icons.rounded.Backspace
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Replay
import androidx.compose.material.icons.sharp.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.exyte.animatednavbar.utils.noRippleClickable
import com.nikolaej.cacademy.ui.screen.LessonScreenViewModel
import com.nikolaej.cacademy.ui.theme.CAcademyTheme
import com.nikolaej.cacademy.ui.theme.string_dark
import kotlinx.coroutines.coroutineScope


data class Choise(
    val name: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun lot_of_choise(
    variantCorrect: List<String>,
    youChoise: MutableList<String>,
    fff: () -> Unit,
    varick: MutableList<String> = mutableListOf(),
    code: @Composable (() -> Unit)?
) {
    val dfg: MutableList<String> = remember {
        mutableStateListOf()
    }

    dfg.clear()
    dfg.addAll(youChoise)


    val sheetState = rememberModalBottomSheetState()
    var isSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }


    var animation by remember {
        mutableFloatStateOf(0f)
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
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Sharp.Info,
                contentDescription = null,
                modifier = Modifier.size(21.dp)
            )

            Text(
                text = "нажмите на фрагменты ниже",
                style = MaterialTheme.typography.displaySmall
            )
        }
        LazyColumn(
            Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.onSecondary)
        ) {
            item {

                if (code != null) {
                    code()
                }
            }

        }
        Spacer(modifier = Modifier.weight(1f))
        Card(
            shape = RoundedCornerShape(0.dp),

            ) {
            Column {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 6.dp)
                ) {
                    IconButton(onClick = {
                        if (varick.isNotEmpty()) {
                            dfg.clear()
                            varick.clear()
                            dfg.addAll(youChoise)
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Rounded.Replay,
                            contentDescription = null,
                            modifier = if (varick.isEmpty()) {
                                Modifier.alpha(0.4f)
                            } else {
                                Modifier.alpha(1f)
                            }
                        )
                    }

                    IconButton(onClick = {
                        if (varick.isNotEmpty()) {
                            dfg.add(varick.last())
                            varick.remove(varick.last())
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Rounded.Backspace,
                            contentDescription = null,
                            modifier = if (varick.isEmpty()) {
                                Modifier.alpha(0.4f)
                            } else {
                                Modifier.alpha(1f)
                            }
                        )
                    }
//----------------------------------------------------------------------------------------------------------------------------------------
                    Spacer(modifier = Modifier.weight(1f))

                    Column(
                        modifier = if (varick.size == variantCorrect.size) {
                            Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .background(MaterialTheme.colorScheme.primary)
                                .clickable {
                                    varick.clear()
                                }
                        } else {
                            Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .background(MaterialTheme.colorScheme.primary.copy(0.4f))
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.PlayArrow,
                            contentDescription = null,
                            modifier = if (varick.size == variantCorrect.size) {
                                Modifier.size(40.dp)
                            } else {
                                Modifier
                                    .size(40.dp)
                                    .alpha(0.4f)
                            }
                        )

                    }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 8.dp, end = 8.dp, bottom = 16.dp)
                        .horizontalScroll(rememberScrollState())
                ) {

                    if (youChoise.isEmpty()) { // проверка на пустоту списка
                        Spacer(modifier = Modifier.size(20.dp))
                    } else {
                        dfg.forEach {

                            Card(
                                modifier = if (varick.size != variantCorrect.size) {
                                    Modifier
                                        .noRippleClickable {
                                            varick.add(it)
                                        }
                                } else {
                                    Modifier
                                        .noRippleClickable { }
                                },
                                shape = RoundedCornerShape(6.dp),
                                colors = if (varick.size != variantCorrect.size) {
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
                                if (it !in varick){
                                    Text(
                                        text = it,
                                        modifier = if (varick.size != variantCorrect.size) {
                                            Modifier.padding( start = 8.dp, end = 8.dp, top = 0.dp, bottom = 4.dp )
                                        } else {
                                            Modifier
                                                .padding(4.dp)
                                                .alpha(0.4f)
                                        },
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.size(4.dp))
                        }
                    }
                }
            }
        }
    }

    if (isSheetOpen) {
        animation = 1f
        ModalBottomSheet(sheetState = sheetState, onDismissRequest = {
            isSheetOpen = false
            animation = 0f
        }, dragHandle = {}, shape = RoundedCornerShape(0.dp)
        ) {
            when (true) {
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
                            onClick = fff,
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
                            OutlinedButton(
                                onClick = { },
                                modifier = Modifier.weight(1f),
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Text(text = "помощь")
                            }
                            Spacer(modifier = Modifier.size(10.dp))
                            Button(
                                onClick = {
                                    isSheetOpen = false
                                    animation = 0f
                                }, modifier = Modifier.weight(1f), shape = RoundedCornerShape(10.dp)
                            ) {
                                Text(text = "ещё раз")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun cartochca(
    viewModel: LessonScreenViewModel
){
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .background(MaterialTheme.colorScheme.secondaryContainer),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = if (viewModel.varick.isEmpty()) {
                " "
            } else {
                viewModel.varick[viewModel.varick.lastIndex]
            },
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.padding(horizontal = 5.dp)
        )
    }
}