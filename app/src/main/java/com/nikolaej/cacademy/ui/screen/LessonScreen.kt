package com.nikolaej.cacademy.ui.screen

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.nikolaej.cacademy.lessonLevel.Lesson1Practice
import com.nikolaej.cacademy.lessonLevel.Lesson1Theory
import com.nikolaej.cacademy.lessonLevel.Lesson2Practice
import com.nikolaej.cacademy.lessonLevel.Lesson2Theory
import com.nikolaej.cacademy.ui.MainScreen


data class TabItem(
    val name: String
)

val tabItem = listOf(
    TabItem("Теория"),
    TabItem("Задания")
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LessonScreen(
    viewModel: LessonViewModel = viewModel(),
    lessonName: String,
    navController: NavController
) {

    var pass by rememberSaveable {
        mutableStateOf(false)
    }


    BackHandler {
        pass = true
    }


    val pagerState = rememberPagerState {
        tabItem.size
    }

    val indicator = @Composable { tabPositions: List<TabPosition> ->
        CustomIndicator(tabPositions, pagerState)
    }

    LaunchedEffect(viewModel.selectTabIndex) {
        pagerState.animateScrollToPage(viewModel.selectTabIndex)
    }

    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {

        if (!pagerState.isScrollInProgress) {
            viewModel.selectTabIndex = pagerState.currentPage
        }
    }


    Column(modifier = Modifier.fillMaxSize()) {

        TabRow(
            selectedTabIndex = viewModel.selectTabIndex,
            indicator = indicator,
            divider = {}
        ) {
            tabItem.forEachIndexed { index, title ->
                Tab(
                    selected = index == viewModel.selectTabIndex,
                    onClick = {
                        viewModel.selectTabIndex = index
                    },
                    text = {
                        Text(text = title.name)
                    }
                )
            }
        }

        val progressAnimDuration = 500

        val progressAnimation by animateFloatAsState(
            targetValue = viewModel.progress,
            animationSpec = tween(
                durationMillis = progressAnimDuration,
                easing = FastOutSlowInEasing
            )
        )


        AnimatedVisibility(visible = viewModel.selectTabIndex == 1) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(end = 8.dp)
            ) {
                IconButton(onClick = { pass = true }) {
                    Icon(imageVector = Icons.Default.Clear, contentDescription = null)
                }
                LinearProgressIndicator(
                    progress = progressAnimation,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(16.dp)
                        .clip(RoundedCornerShape(8.dp))

                )
            }

        }

        if (pass) {
            Dialog(
                onCancel = {
                    pass = false
                    navController.popBackStack(MainScreen.Start.name, inclusive = false)
                },
                onYes = {
                    pass = false
                }
            )
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            when (lessonName) {
                "Что такое программирование?" -> when (it) {
                    0 -> Lesson1Theory()
                    1 -> Lesson1Practice(viewModel, navController)
                }

                "История программирования" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Виды программирования" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Программирование на C++" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Переменные" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Типы данных" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Константы" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Ввод и вывод в консоли" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Операторы присваивания" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Арифметические операторы" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Операторы сравнения" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Логические операторы" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "конструкция if" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "конструкция switch" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Цикл while" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Цикл for" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Цикл do..while" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Операторы continue и break" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Массивы" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Многомерные массивы" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Массивы символов" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Ссылки" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Указатели" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Арифметика указателей" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Определение и объявление" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Область видимости объектов" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Передача аргументов" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Оператор return" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Указатели в параметрах функций" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Параметры функции main" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Возвращение указателей и ссылок" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Перегрузка функций" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Рекурсивные функции" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Указатели на функции" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Указатели на функции как параметры" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Тип функции" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Указатель на функцию как возвращаемое значение" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Динамические объекты" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Динамические массивы" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Определение классов" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Конструкторы и инициализация объектов" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Управление доступом. Инкапсуляция" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Определение и объявление функций класса" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Конструктор копирования" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Константные объекты и функции" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Ключевое слово this" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Дружественные функции и классы" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Статические члены класса" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Деструктор" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Структуры" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Перечисления" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Наследование" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Управление доступом в базовых и производных классах" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Скрытие функционала базового класса" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Множественное наследование" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Виртуальные функции и их переопределение" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Преобразование типов" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Динамическое преобразование" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Особенности динамического связывания" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Чистые  виртуальные функции и абстрактные классы" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Перегрузка операторов" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Операторы преобразования типов" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Оператор индексирования" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Переопределение оператора присваивания " -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Пространство имён" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }

                "Вложенные классы" -> when (it) {
                    0 -> Lesson2Theory()
                    1 -> Lesson2Practice()
                }
            }
        }
    }
}


@Composable
fun Dialog(onCancel: () -> Unit, onYes: () -> Unit) {

    AlertDialog(onDismissRequest = { /* Do nothing */ },
        title = { Text("Внимание") },
        text = { Text("Если вы покините урок, то весь прогресс не сохранится!!") },
        dismissButton = {
            TextButton(onClick = onCancel) {
                Text(text = "Уйти")
            }
        },
        confirmButton = {
            TextButton(onClick =  onYes ) {
                Text(text = "Остаться")
            }
        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun CustomIndicator(tabPositions: List<TabPosition>, pagerState: PagerState) {
    val transition = updateTransition(pagerState.currentPage)
    val indicatorStart by transition.animateDp(
        transitionSpec = {
            if (initialState < targetState) {
                spring(dampingRatio = 1f, stiffness = 50f)
            } else {
                spring(dampingRatio = 1f, stiffness = 1000f)
            }
        }, label = ""
    ) {
        tabPositions[it].left
    }

    val indicatorEnd by transition.animateDp(
        transitionSpec = {
            if (initialState < targetState) {
                spring(dampingRatio = 1f, stiffness = 1000f)
            } else {
                spring(dampingRatio = 1f, stiffness = 50f)
            }
        }, label = ""
    ) {
        tabPositions[it].right
    }

    Box(
        Modifier
            .offset(x = indicatorStart)
            .wrapContentSize(align = Alignment.BottomStart)
            .width(indicatorEnd - indicatorStart)
            .padding(2.dp)
            .fillMaxSize()
            .border(
                BorderStroke(2.dp, MaterialTheme.colorScheme.secondaryContainer),
                RoundedCornerShape(50)
            )
            .zIndex(1f)
    )
}

