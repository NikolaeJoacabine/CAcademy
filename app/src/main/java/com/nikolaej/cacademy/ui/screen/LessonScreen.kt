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
import com.nikolaej.cacademy.lessonLevel.Lesson10Practice
import com.nikolaej.cacademy.lessonLevel.Lesson10Theory
import com.nikolaej.cacademy.lessonLevel.Lesson11Practice
import com.nikolaej.cacademy.lessonLevel.Lesson11Theory
import com.nikolaej.cacademy.lessonLevel.Lesson12Practice
import com.nikolaej.cacademy.lessonLevel.Lesson12Theory
import com.nikolaej.cacademy.lessonLevel.Lesson13Practice
import com.nikolaej.cacademy.lessonLevel.Lesson13Theory
import com.nikolaej.cacademy.lessonLevel.Lesson14Practice
import com.nikolaej.cacademy.lessonLevel.Lesson14Theory
import com.nikolaej.cacademy.lessonLevel.Lesson15Practice
import com.nikolaej.cacademy.lessonLevel.Lesson15Theory
import com.nikolaej.cacademy.lessonLevel.Lesson16Practice
import com.nikolaej.cacademy.lessonLevel.Lesson16Theory
import com.nikolaej.cacademy.lessonLevel.Lesson17Practice
import com.nikolaej.cacademy.lessonLevel.Lesson17Theory
import com.nikolaej.cacademy.lessonLevel.Lesson18Practice
import com.nikolaej.cacademy.lessonLevel.Lesson18Theory
import com.nikolaej.cacademy.lessonLevel.Lesson19Practice
import com.nikolaej.cacademy.lessonLevel.Lesson19Theory
import com.nikolaej.cacademy.lessonLevel.Lesson20Practice
import com.nikolaej.cacademy.lessonLevel.Lesson20Theory
import com.nikolaej.cacademy.lessonLevel.Lesson21Practice
import com.nikolaej.cacademy.lessonLevel.Lesson21Theory
import com.nikolaej.cacademy.lessonLevel.Lesson22Practice
import com.nikolaej.cacademy.lessonLevel.Lesson22Theory
import com.nikolaej.cacademy.lessonLevel.Lesson23Practice
import com.nikolaej.cacademy.lessonLevel.Lesson23Theory
import com.nikolaej.cacademy.lessonLevel.Lesson24Practice
import com.nikolaej.cacademy.lessonLevel.Lesson24Theory
import com.nikolaej.cacademy.lessonLevel.Lesson25Practice
import com.nikolaej.cacademy.lessonLevel.Lesson25Theory
import com.nikolaej.cacademy.lessonLevel.Lesson26Practice
import com.nikolaej.cacademy.lessonLevel.Lesson26Theory
import com.nikolaej.cacademy.lessonLevel.Lesson27Practice
import com.nikolaej.cacademy.lessonLevel.Lesson27Theory
import com.nikolaej.cacademy.lessonLevel.Lesson28Practice
import com.nikolaej.cacademy.lessonLevel.Lesson28Theory
import com.nikolaej.cacademy.lessonLevel.Lesson29Practice
import com.nikolaej.cacademy.lessonLevel.Lesson29Theory
import com.nikolaej.cacademy.lessonLevel.Lesson30Practice
import com.nikolaej.cacademy.lessonLevel.Lesson30Theory
import com.nikolaej.cacademy.lessonLevel.Lesson31Practice
import com.nikolaej.cacademy.lessonLevel.Lesson31Theory
import com.nikolaej.cacademy.lessonLevel.Lesson32Practice
import com.nikolaej.cacademy.lessonLevel.Lesson32Theory
import com.nikolaej.cacademy.lessonLevel.Lesson33Practice
import com.nikolaej.cacademy.lessonLevel.Lesson33Theory
import com.nikolaej.cacademy.lessonLevel.Lesson34Practice
import com.nikolaej.cacademy.lessonLevel.Lesson34Theory
import com.nikolaej.cacademy.lessonLevel.Lesson35Practice
import com.nikolaej.cacademy.lessonLevel.Lesson35Theory
import com.nikolaej.cacademy.lessonLevel.Lesson36Practice
import com.nikolaej.cacademy.lessonLevel.Lesson36Theory
import com.nikolaej.cacademy.lessonLevel.Lesson37Practice
import com.nikolaej.cacademy.lessonLevel.Lesson37Theory
import com.nikolaej.cacademy.lessonLevel.Lesson38Practice
import com.nikolaej.cacademy.lessonLevel.Lesson38Theory
import com.nikolaej.cacademy.lessonLevel.Lesson39Practice
import com.nikolaej.cacademy.lessonLevel.Lesson39Theory
import com.nikolaej.cacademy.lessonLevel.Lesson40Practice
import com.nikolaej.cacademy.lessonLevel.Lesson40Theory
import com.nikolaej.cacademy.lessonLevel.Lesson41Practice
import com.nikolaej.cacademy.lessonLevel.Lesson41Theory
import com.nikolaej.cacademy.lessonLevel.Lesson42Practice
import com.nikolaej.cacademy.lessonLevel.Lesson42Theory
import com.nikolaej.cacademy.lessonLevel.Lesson43Practice
import com.nikolaej.cacademy.lessonLevel.Lesson43Theory
import com.nikolaej.cacademy.lessonLevel.Lesson44Practice
import com.nikolaej.cacademy.lessonLevel.Lesson44Theory
import com.nikolaej.cacademy.lessonLevel.Lesson45Practice
import com.nikolaej.cacademy.lessonLevel.Lesson45Theory
import com.nikolaej.cacademy.lessonLevel.Lesson46Practice
import com.nikolaej.cacademy.lessonLevel.Lesson46Theory
import com.nikolaej.cacademy.lessonLevel.Lesson47Practice
import com.nikolaej.cacademy.lessonLevel.Lesson47Theory
import com.nikolaej.cacademy.lessonLevel.Lesson48Practice
import com.nikolaej.cacademy.lessonLevel.Lesson48Theory
import com.nikolaej.cacademy.lessonLevel.Lesson49Practice
import com.nikolaej.cacademy.lessonLevel.Lesson49Theory
import com.nikolaej.cacademy.lessonLevel.Lesson4Practice
import com.nikolaej.cacademy.lessonLevel.Lesson4Theory
import com.nikolaej.cacademy.lessonLevel.Lesson50Practice
import com.nikolaej.cacademy.lessonLevel.Lesson50Theory
import com.nikolaej.cacademy.lessonLevel.Lesson51Practice
import com.nikolaej.cacademy.lessonLevel.Lesson51Theory
import com.nikolaej.cacademy.lessonLevel.Lesson52Practice
import com.nikolaej.cacademy.lessonLevel.Lesson52Theory
import com.nikolaej.cacademy.lessonLevel.Lesson53Practice
import com.nikolaej.cacademy.lessonLevel.Lesson53Theory
import com.nikolaej.cacademy.lessonLevel.Lesson54Practice
import com.nikolaej.cacademy.lessonLevel.Lesson54Theory
import com.nikolaej.cacademy.lessonLevel.Lesson55Practice
import com.nikolaej.cacademy.lessonLevel.Lesson55Theory
import com.nikolaej.cacademy.lessonLevel.Lesson56Practice
import com.nikolaej.cacademy.lessonLevel.Lesson56Theory
import com.nikolaej.cacademy.lessonLevel.Lesson57Practice
import com.nikolaej.cacademy.lessonLevel.Lesson57Theory
import com.nikolaej.cacademy.lessonLevel.Lesson58Practice
import com.nikolaej.cacademy.lessonLevel.Lesson58Theory
import com.nikolaej.cacademy.lessonLevel.Lesson59Practice
import com.nikolaej.cacademy.lessonLevel.Lesson59Theory
import com.nikolaej.cacademy.lessonLevel.Lesson5Practice
import com.nikolaej.cacademy.lessonLevel.Lesson5Theory
import com.nikolaej.cacademy.lessonLevel.Lesson60Practice
import com.nikolaej.cacademy.lessonLevel.Lesson60Theory
import com.nikolaej.cacademy.lessonLevel.Lesson61Practice
import com.nikolaej.cacademy.lessonLevel.Lesson61Theory
import com.nikolaej.cacademy.lessonLevel.Lesson62Practice
import com.nikolaej.cacademy.lessonLevel.Lesson62Theory
import com.nikolaej.cacademy.lessonLevel.Lesson63Practice
import com.nikolaej.cacademy.lessonLevel.Lesson63Theory
import com.nikolaej.cacademy.lessonLevel.Lesson64Practice
import com.nikolaej.cacademy.lessonLevel.Lesson64Theory
import com.nikolaej.cacademy.lessonLevel.Lesson65Practice
import com.nikolaej.cacademy.lessonLevel.Lesson65Theory
import com.nikolaej.cacademy.lessonLevel.Lesson6Practice
import com.nikolaej.cacademy.lessonLevel.Lesson6Theory
import com.nikolaej.cacademy.lessonLevel.Lesson7Practice
import com.nikolaej.cacademy.lessonLevel.Lesson7Theory
import com.nikolaej.cacademy.lessonLevel.Lesson8Practice
import com.nikolaej.cacademy.lessonLevel.Lesson8Theory
import com.nikolaej.cacademy.lessonLevel.Lesson9Practice
import com.nikolaej.cacademy.lessonLevel.Lesson9Theory
import com.nikolaej.cacademy.lessonLevel.Lesson_4Practice
import com.nikolaej.cacademy.lessonLevel.Lesson_4Theory
import com.nikolaej.cacademy.ui.AppViewModelProvider
import com.nikolaej.cacademy.ui.navigation.NavigationDestination


object LessonDestination : NavigationDestination {
    override val route = "Lesson"
    var nameLesson: String = ""
    var idlesson: Int = 0
}

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
    viewModel: LessonScreenViewModel = viewModel(factory = AppViewModelProvider.Factory),
    navController: NavController,
    darkTheme: Boolean
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
            divider = {},
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            modifier = Modifier.clip(shape = RoundedCornerShape(0.dp, 0.dp, 15.dp, 15.dp))
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
                    navController.popBackStack(LessonsDestination.route, inclusive = false)
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
            when (LessonDestination.nameLesson) {
                "Структура программы" -> when(it) {
                    0 -> Lesson_4Theory(darkTheme)
                    1 -> Lesson_4Practice(viewModel, navController, darkTheme)
                }

                "Переменные" -> when (it) {
                    0 -> Lesson4Theory(darkTheme)
                    1 -> Lesson4Practice(viewModel, navController, darkTheme)
                }

                "Типы данных" -> when (it) {
                    0 -> Lesson5Theory()
                    1 -> Lesson5Practice()
                }

                "Константы" -> when (it) {
                    0 -> Lesson6Theory()
                    1 -> Lesson6Practice()
                }

                "Ввод и вывод в консоли" -> when (it) {
                    0 -> Lesson7Theory()
                    1 -> Lesson7Practice()
                }

                "using. Подключение пространств имен и определение псевдонимов" -> when (it) {
                    0 -> Lesson8Theory()
                    1 -> Lesson8Practice()
                }

                "Операторы присваивания" -> when (it) {
                    0 -> Lesson9Theory()
                    1 -> Lesson9Practice()
                }

                "Арифметические операторы" -> when (it) {
                    0 -> Lesson10Theory()
                    1 -> Lesson10Practice()
                }

                "Операторы сравнения" -> when (it) {
                    0 -> Lesson11Theory()
                    1 -> Lesson11Practice()
                }

                "Логические операторы" -> when (it) {
                    0 -> Lesson12Theory()
                    1 -> Lesson12Practice()
                }

                "конструкция if" -> when (it) {
                    0 -> Lesson13Theory()
                    1 -> Lesson13Practice()
                }

                "конструкция switch" -> when (it) {
                    0 -> Lesson14Theory()
                    1 -> Lesson14Practice()
                }

                "Цикл while" -> when (it) {
                    0 -> Lesson15Theory()
                    1 -> Lesson15Practice()
                }

                "Цикл for" -> when (it) {
                    0 -> Lesson16Theory()
                    1 -> Lesson16Practice()
                }

                "Цикл do..while" -> when (it) {
                    0 -> Lesson17Theory()
                    1 -> Lesson17Practice()
                }

                "Операторы continue и break" -> when (it) {
                    0 -> Lesson18Theory()
                    1 -> Lesson18Practice()
                }

                "Массивы" -> when (it) {
                    0 -> Lesson19Theory()
                    1 -> Lesson19Practice()
                }

                "Многомерные массивы" -> when (it) {
                    0 -> Lesson20Theory()
                    1 -> Lesson20Practice()
                }

                "Массивы символов" -> when (it) {
                    0 -> Lesson21Theory()
                    1 -> Lesson21Practice()
                }

                "Ссылки" -> when (it) {
                    0 -> Lesson22Theory()
                    1 -> Lesson22Practice()
                }

                "Указатели" -> when (it) {
                    0 -> Lesson23Theory()
                    1 -> Lesson23Practice()
                }

                "Арифметика указателей" -> when (it) {
                    0 -> Lesson24Theory()
                    1 -> Lesson24Practice()
                }

                "Определение и объявление" -> when (it) {
                    0 -> Lesson25Theory()
                    1 -> Lesson25Practice()
                }

                "Область видимости объектов" -> when (it) {
                    0 -> Lesson26Theory()
                    1 -> Lesson26Practice()
                }

                "Передача аргументов" -> when (it) {
                    0 -> Lesson27Theory()
                    1 -> Lesson27Practice()
                }

                "Оператор return" -> when (it) {
                    0 -> Lesson28Theory()
                    1 -> Lesson28Practice()
                }

                "Указатели в параметрах функций" -> when (it) {
                    0 -> Lesson29Theory()
                    1 -> Lesson29Practice()
                }

                "Параметры функции main" -> when (it) {
                    0 -> Lesson30Theory()
                    1 -> Lesson30Practice()
                }

                "Возвращение указателей и ссылок" -> when (it) {
                    0 -> Lesson31Theory()
                    1 -> Lesson31Practice()
                }

                "Перегрузка функций" -> when (it) {
                    0 -> Lesson32Theory()
                    1 -> Lesson32Practice()
                }

                "Рекурсивные функции" -> when (it) {
                    0 -> Lesson33Theory()
                    1 -> Lesson33Practice()
                }

                "Указатели на функции" -> when (it) {
                    0 -> Lesson34Theory()
                    1 -> Lesson34Practice()
                }

                "Указатели на функции как параметры" -> when (it) {
                    0 -> Lesson35Theory()
                    1 -> Lesson35Practice()
                }

                "Тип функции" -> when (it) {
                    0 -> Lesson36Theory()
                    1 -> Lesson36Practice()
                }

                "Указатель на функцию как возвращаемое значение" -> when (it) {
                    0 -> Lesson37Theory()
                    1 -> Lesson37Practice()
                }

                "Динамические объекты" -> when (it) {
                    0 -> Lesson38Theory()
                    1 -> Lesson38Practice()
                }

                "Динамические массивы" -> when (it) {
                    0 -> Lesson39Theory()
                    1 -> Lesson39Practice()
                }

                "Определение классов" -> when (it) {
                    0 -> Lesson40Theory()
                    1 -> Lesson40Practice()
                }

                "Конструкторы и инициализация объектов" -> when (it) {
                    0 -> Lesson41Theory()
                    1 -> Lesson41Practice()
                }

                "Управление доступом. Инкапсуляция" -> when (it) {
                    0 -> Lesson42Theory()
                    1 -> Lesson42Practice()
                }

                "Определение и объявление функций класса" -> when (it) {
                    0 -> Lesson43Theory()
                    1 -> Lesson43Practice()
                }

                "Конструктор копирования" -> when (it) {
                    0 -> Lesson44Theory()
                    1 -> Lesson44Practice()
                }

                "Константные объекты и функции" -> when (it) {
                    0 -> Lesson45Theory()
                    1 -> Lesson45Practice()
                }

                "Ключевое слово this" -> when (it) {
                    0 -> Lesson46Theory()
                    1 -> Lesson46Practice()
                }

                "Дружественные функции и классы" -> when (it) {
                    0 -> Lesson47Theory()
                    1 -> Lesson47Practice()
                }

                "Статические члены класса" -> when (it) {
                    0 -> Lesson48Theory()
                    1 -> Lesson48Practice()
                }

                "Деструктор" -> when (it) {
                    0 -> Lesson49Theory()
                    1 -> Lesson49Practice()
                }

                "Структуры" -> when (it) {
                    0 -> Lesson50Theory()
                    1 -> Lesson50Practice()
                }

                "Перечисления" -> when (it) {
                    0 -> Lesson51Theory()
                    1 -> Lesson51Practice()
                }

                "Наследование" -> when (it) {
                    0 -> Lesson52Theory()
                    1 -> Lesson52Practice()
                }

                "Управление доступом в базовых и производных классах" -> when (it) {
                    0 -> Lesson53Theory()
                    1 -> Lesson53Practice()
                }

                "Скрытие функционала базового класса" -> when (it) {
                    0 -> Lesson54Theory()
                    1 -> Lesson54Practice()
                }

                "Множественное наследование" -> when (it) {
                    0 -> Lesson55Theory()
                    1 -> Lesson55Practice()
                }

                "Виртуальные функции и их переопределение" -> when (it) {
                    0 -> Lesson56Theory()
                    1 -> Lesson56Practice()
                }

                "Преобразование типов" -> when (it) {
                    0 -> Lesson57Theory()
                    1 -> Lesson57Practice()
                }

                "Динамическое преобразование" -> when (it) {
                    0 -> Lesson58Theory()
                    1 -> Lesson58Practice()
                }

                "Особенности динамического связывания" -> when (it) {
                    0 -> Lesson59Theory()
                    1 -> Lesson59Practice()
                }

                "Чистые  виртуальные функции и абстрактные классы" -> when (it) {
                    0 -> Lesson60Theory()
                    1 -> Lesson60Practice()
                }

                "Перегрузка операторов" -> when (it) {
                    0 -> Lesson61Theory()
                    1 -> Lesson61Practice()
                }

                "Операторы преобразования типов" -> when (it) {
                    0 -> Lesson62Theory()
                    1 -> Lesson62Practice()
                }

                "Оператор индексирования" -> when (it) {
                    0 -> Lesson63Theory()
                    1 -> Lesson63Practice()
                }

                "Переопределение оператора присваивания " -> when (it) {
                    0 -> Lesson64Theory()
                    1 -> Lesson64Practice()
                }

                "Вложенные классы" -> when (it) {
                    0 -> Lesson65Theory()
                    1 -> Lesson65Practice()
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
                BorderStroke(2.dp, MaterialTheme.colorScheme.primary),
                RoundedCornerShape(50)
            )
            .zIndex(1f)
    )
}

