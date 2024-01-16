package com.nikolaej.cacademy.lessonLevel

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.nikolaej.cacademy.tipsTasck.ToggleableInfo
import com.nikolaej.cacademy.tipsTasck.cartochca
import com.nikolaej.cacademy.tipsTasck.lot_of_choise
import com.nikolaej.cacademy.tipsTasck.task_with_a_choise
import com.nikolaej.cacademy.ui.screen.FinishDestination
import com.nikolaej.cacademy.ui.screen.LessonDestination
import com.nikolaej.cacademy.ui.screen.LessonScreenViewModel
import com.nikolaej.cacademy.ui.theme.comment_dark
import com.nikolaej.cacademy.ui.theme.comment_light
import com.nikolaej.cacademy.ui.theme.helper_dark
import com.nikolaej.cacademy.ui.theme.helper_light
import com.nikolaej.cacademy.ui.theme.intov_dark
import com.nikolaej.cacademy.ui.theme.intov_light
import com.nikolaej.cacademy.ui.theme.string_dark
import com.nikolaej.cacademy.ui.theme.string_light

@Composable
fun Lesson_4Theory(
    darkTheme: Boolean
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp)
    ) {
        item {
            Text(text = LessonDestination.nameLesson, style = MaterialTheme.typography.bodyLarge)
            Text(text = "Инструкции", style = MaterialTheme.typography.bodyMedium)
            Text(
                style = MaterialTheme.typography.bodySmall,
                text = "Программа на С++ состоит из набора инструкций. Каждая инструкция (statement) выполняет определенное действие. В конце инструкции в языке C++ ставится точка с запятой (;). Данный знак указывает компилятору на завершение инструкции. Например:"
            )
            Card(
                Modifier.padding(4.dp)
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(4.dp)
                ) {
                    Row(
                        modifier = Modifier.horizontalScroll(rememberScrollState()),
                    ) {
                        Text(
                            text = "std::cout << ",
                            style = MaterialTheme.typography.displaySmall,
                        )
                        Text(
                            text = " \"Hello World!\"",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                string_dark
                            } else {
                                string_light
                            }
                        )
                        Text(
                            text = ";",
                            style = MaterialTheme.typography.displaySmall,
                        )
                    }
                }
            }

            Text(
                style = MaterialTheme.typography.bodySmall,
                text = "Данная строка выводит на консоль строку \"Hello world!\", является инструкцией и поэтому завершается точкой с запятой."
            )
            Text(
                style = MaterialTheme.typography.bodySmall,
                text = "Набор инструкций может представлять блок кода. Блок кода заключается в фигурные скобки, а инструкции помещаются между открывающей и закрывающей фигурными скобками:"
            )
            Card(
                Modifier.padding(4.dp)
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(4.dp)
                ) {
                    Text(text = "{", style = MaterialTheme.typography.displaySmall)
                    Row {
                        Text(
                            text = "    std::cout << ",
                            style = MaterialTheme.typography.displaySmall,
                        )
                        Text(
                            text = " \"Hello World!\"",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                string_dark
                            } else {
                                string_light
                            }
                        )
                        Text(
                            text = ";",
                            style = MaterialTheme.typography.displaySmall,
                        )
                    }
                    Row {
                        Text(
                            text = "    std::cout << ",
                            style = MaterialTheme.typography.displaySmall,
                        )
                        Text(
                            text = " \"Bye World!\"",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                string_dark
                            } else {
                                string_light
                            }
                        )
                        Text(
                            text = ";",
                            style = MaterialTheme.typography.displaySmall,
                        )
                    }
                    Text(text = "}", style = MaterialTheme.typography.displaySmall)
                }
            }
            Text(
                text = "В этом блоке кода две инструкции, которые выводят на консоль определенную строку.",
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(text = "Функция main", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.size(4.dp))
            Text(buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W300, fontSize = 17.sp)) {
                    append("Каждая программа на языке С++ должна иметь как минимум одну функцию - функцию ")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W900,
                        textDecoration = TextDecoration.Underline,
                        fontSize = 17.sp
                    )
                ) {
                    append("main()")
                }
                withStyle(style = SpanStyle(fontWeight = FontWeight.W300, fontSize = 17.sp)) {
                    append(". Именно с этой функции начинается выполнение приложения. Ее имя main фиксировано и для всех программ на С++ всегда одинаково.")
                }
            })

            Text(
                text = "Функция также является блоком кода, поэтому ее тело обрамляется фигурными скобками, между которыми определяется набор инструкций.",
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                style = MaterialTheme.typography.bodySmall,
                text = "В частности, при создании первой программы использовалась следующая функция main:"
            )

            Card(
                Modifier.padding(4.dp)
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(4.dp)
                ) {

                    Row {
                        Row {
                            Text(
                                text = " #include ",
                                style = MaterialTheme.typography.displaySmall,

                                )
                            Text(
                                text = "<iostream>",
                                style = MaterialTheme.typography.displaySmall,
                                color = if (darkTheme) {
                                    string_dark
                                } else {
                                    string_light
                                }
                            )
                        }
                    }
                    Text(text = "", style = MaterialTheme.typography.displaySmall)
                    Row {
                        Text(
                            text = " int ",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                intov_dark
                            } else {
                                intov_light
                            }
                        )
                        Text(text = "main()", style = MaterialTheme.typography.displaySmall)
                    }
                    Text(text = " {", style = MaterialTheme.typography.displaySmall)
                    Row {
                        Text(
                            text = "    std::cout << ",
                            style = MaterialTheme.typography.displaySmall,
                        )
                        Text(
                            text = " \"Hello World!\"",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                string_dark
                            } else {
                                string_light
                            }
                        )
                        Text(
                            text = ";",
                            style = MaterialTheme.typography.displaySmall,
                        )
                    }
                    Row {
                        Text(
                            text = "    return ",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                helper_dark
                            } else {
                                helper_light
                            }
                        )
                        Text(text = "0;", style = MaterialTheme.typography.displaySmall)
                    }
                    Text(text = " }", style = MaterialTheme.typography.displaySmall)
                }
            }
            Text(buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W300, fontSize = 17.sp)) {
                    append("Определение функии main начинается с возвращаемого типа. Функция main в любом случае должна возвращать число. Поэтому ее определение начинается с ключевого слова ")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W900,
                        textDecoration = TextDecoration.Underline,
                        fontSize = 17.sp
                    )
                ) {
                    append("int.")
                }
            })
            Text(buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W300, fontSize = 17.sp)) {
                    append("Далее идет название функции, то есть ")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W900,
                        textDecoration = TextDecoration.Underline,
                        fontSize = 17.sp
                    )
                ) {
                    append("main")
                }
                withStyle(style = SpanStyle(fontWeight = FontWeight.W300, fontSize = 17.sp)) {
                    append(". После названия в скобках идет список параметров. В данном случае функция main не принимает никаких параметров, поэтому после названия указаны пустые скобки.И после списка параметров идет блок кода, который и содержит в виде инструкций собственно те действия, выполняемые функцией main.")
                }
            })
            Text(buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W300, fontSize = 17.sp)) {
                    append("В конце функции идет инструкция ")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W900,
                        textDecoration = TextDecoration.Underline,
                        fontSize = 17.sp
                    )
                ) {
                    append("return:")
                }
            })
            Card(
                Modifier.padding(4.dp)
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(4.dp)
                ) {
                    Row {
                        Text(
                            text = "return ", style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                helper_dark
                            } else {
                                helper_light
                            }
                        )
                        Text(text = "0", style = MaterialTheme.typography.displaySmall)
                    }
                }
            }
            Text(
                text = "Эта инструкция завершает выполнение функции, передавая управление во вне туда, где была вызвана функция. В случае с функцией main контроль передается операционной системе.",
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = "Число 0 после оператора return указывает операционной системе, что выполнение функции завершилось успешно, без ошибок.",
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = "Также стоит отметить, что в функции main можно опустить инструкцию return 0;",
                style = MaterialTheme.typography.bodySmall
            )

            Text(text = "Директивы препроцессора", style = MaterialTheme.typography.bodyMedium)
            Text(buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W300, fontSize = 17.sp)) {
                    append("В примере выше на консоль выводится строка, но чтобы использовать вывод на консоль, необходимо в начале файла с исходным кодом подключать библиотеку iostream с помощью директивы ")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W900,
                        textDecoration = TextDecoration.Underline,
                        fontSize = 17.sp
                    )
                ) {
                    append("include.")
                }
            })
            Card(
                Modifier.padding(4.dp)
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(4.dp)
                ) {
                    Row {
                        Text(
                            text = "#include ",
                            style = MaterialTheme.typography.displaySmall,
                        )
                        Text(
                            text = "<iostream>",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                string_dark
                            } else {
                                string_light
                            }
                        )
                    }
                }
            }
            Text(buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W300, fontSize = 17.sp)) {
                    append("Директива ")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W900,
                        textDecoration = TextDecoration.Underline,
                        fontSize = 17.sp
                    )
                ) {
                    append("include")
                }
                withStyle(style = SpanStyle(fontWeight = FontWeight.W300, fontSize = 17.sp)) {
                    append(" является директивой препроцессора. Каждая директива препроцессора размещается на одной строке. И в отличие от обычных инструкциий языка C++, которые завершаются точкой с запятой ")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W900,
                        textDecoration = TextDecoration.Underline,
                        fontSize = 17.sp
                    )
                ) {
                    append(";")
                }
                withStyle(style = SpanStyle(fontWeight = FontWeight.W300, fontSize = 17.sp)) {
                    append(" , признаком завершения препроцессорной директивы является перевод на новую строку. Кроме того, директива должна начинаться со знака решетки #. Непосредственно директива \"include\" определяет, какие файлы и библиотеки надо подключить в данном месте в код программы.")
                }
            })
            Text(text = "Комментарии", style = MaterialTheme.typography.bodyMedium)
            Text(
                text = "Исходный код может содержать комментарии. Комментарии позволяют понять смысл программы, что делают те или иные ее части. При компиляции комментарии игнорируются и не оказывают никакого влияния на работу приложения и на его размер.",
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = "В языке C++ есть два типа комментариев: однострочный и многострочный. Однострочный комментарий размещается на одной строке после двойного слеша //:",
                style = MaterialTheme.typography.bodySmall
            )
            Card(
                Modifier.padding(4.dp)
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(4.dp)
                ) {

                    Row {
                        Row {
                            Text(
                                text = " #include ",
                                style = MaterialTheme.typography.displaySmall,

                                )
                            Text(
                                text = "<iostream>",
                                style = MaterialTheme.typography.displaySmall,
                                color = if (darkTheme) {
                                    string_dark
                                } else {
                                    string_light
                                }
                            )

                        }
                    }
                    Text(
                        text = "// подключаем библиотеку iostream",
                        style = MaterialTheme.typography.displaySmall,
                        color = if (darkTheme) {
                            comment_dark
                        } else {
                            comment_light
                        }
                    )
                    Text(text = "", style = MaterialTheme.typography.displaySmall)
                    Row {
                        Text(
                            text = " int ",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                intov_dark
                            } else {
                                intov_light
                            }
                        )
                        Text(text = "main()", style = MaterialTheme.typography.displaySmall)
                        Text(
                            text = " // начало функции",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                comment_dark
                            } else {
                                comment_light
                            }
                        )
                    }
                    Text(text = " {", style = MaterialTheme.typography.displaySmall)
                    Row {
                        Text(
                            text = "    std::cout << ",
                            style = MaterialTheme.typography.displaySmall,
                        )
                        Text(
                            text = " \"Hello World!\"",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                string_dark
                            } else {
                                string_light
                            }
                        )
                        Text(
                            text = ";",
                            style = MaterialTheme.typography.displaySmall,
                        )
                        Text(
                            text = " // вывод",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                comment_dark
                            } else {
                                comment_light
                            }
                        )
                    }
                    Row {
                        Text(
                            text = "    return ",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                helper_dark
                            } else {
                                helper_light
                            }
                        )
                        Text(text = "0;", style = MaterialTheme.typography.displaySmall)
                        Text(
                            text = " // выход из функции",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                comment_dark
                            } else {
                                comment_light
                            }
                        )

                    }
                    Text(text = " }", style = MaterialTheme.typography.displaySmall)

                }
            }
            Text(buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W300,
                        fontSize = 17.sp
                    )
                ) {
                    append("Многострочный комментарий заключается между символами ")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W900,
                        textDecoration = TextDecoration.Underline,
                        fontSize = 17.sp
                    )
                ) {
                    append("/* текст комментария */")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W300,
                        fontSize = 17.sp
                    )
                ) {
                    append(". Он может размещаться на нескольких строках. Например:")
                }
            })
            Card(
                Modifier.padding(4.dp)
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(4.dp)
                ) {

                    Row {
                        Row {
                            Text(
                                text = " #include ",
                                style = MaterialTheme.typography.displaySmall,

                                )
                            Text(
                                text = "<iostream>",
                                style = MaterialTheme.typography.displaySmall,
                                color = if (darkTheme) {
                                    string_dark
                                } else {
                                    string_light
                                }
                            )
                        }
                    }
                    Text(
                        text = "/*",
                        style = MaterialTheme.typography.displaySmall,
                        color = if (darkTheme) {
                            comment_dark
                        } else {
                            comment_light
                        }
                    )
                    Text(
                        text = "Определение функции Main",
                        style = MaterialTheme.typography.displaySmall,
                        color = if (darkTheme) {
                            comment_dark
                        } else {
                            comment_light
                        }
                    )
                    Text(
                        text = "*/",
                        style = MaterialTheme.typography.displaySmall,
                        color = if (darkTheme) {
                            comment_dark
                        } else {
                            comment_light
                        }
                    )
                    Row {
                        Text(
                            text = " int ",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                intov_dark
                            } else {
                                intov_light
                            }
                        )
                        Text(text = "main()", style = MaterialTheme.typography.displaySmall)
                    }
                    Text(text = " {", style = MaterialTheme.typography.displaySmall)
                    Row {
                        Text(
                            text = "    std::cout << ",
                            style = MaterialTheme.typography.displaySmall,
                        )
                        Text(
                            text = " \"Hello World!\"",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                string_dark
                            } else {
                                string_light
                            }
                        )
                        Text(
                            text = ";",
                            style = MaterialTheme.typography.displaySmall,
                        )
                        Text(
                            text = " // вывод",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                comment_dark
                            } else {
                                comment_light
                            }
                        )
                    }
                    Row {
                        Text(
                            text = "    return ",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                helper_dark
                            } else {
                                helper_light
                            }
                        )
                        Text(text = "0;", style = MaterialTheme.typography.displaySmall)
                    }
                    Text(text = " }", style = MaterialTheme.typography.displaySmall)

                }
            }
        }
    }
}

@Composable
fun Lesson_4Practice(
    viewModel: LessonScreenViewModel,
    navController: NavController,
    darkTheme: Boolean
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        AnimatedVisibility(visible = viewModel.zadan == 1) {
            val radioButtons = remember {
                mutableStateListOf(
                    ToggleableInfo(
                        isChecked = false,
                        text = "<<"
                    ),
                    ToggleableInfo(
                        isChecked = false,
                        text = ":"
                    ),
                    ToggleableInfo(
                        isChecked = false,
                        text = ";"
                    ),
                    ToggleableInfo(
                        isChecked = false,
                        text = "!"
                    ),
                )
            }

            task_with_a_choise(
                radioButtons,
                "Какой знак ставится в конце инструкции?",
                2,
                viewModel,
                prog = 0.1f
            )
        }

        AnimatedVisibility(visible = viewModel.zadan == 2) {
            val youChoiseState = remember {
                mutableStateListOf(
                    "<<", ";", "{", ";", "}"
                )
            }
            val correrct = remember {
                listOf(";", ";")
            }

            lot_of_choise(
                variantCorrect = correrct,
                youChoise = youChoiseState,
                code = {
                    Column {
                        Row {
                            Row {
                                Text(
                                    text = " #include ",
                                    style = MaterialTheme.typography.displaySmall,

                                    )
                                Text(
                                    text = "<iostream>",
                                    style = MaterialTheme.typography.displaySmall,
                                    color = if (darkTheme) {
                                        string_dark
                                    } else {
                                        string_light
                                    }
                                )
                            }
                        }
                        Text(text = "", style = MaterialTheme.typography.displaySmall)
                        Row {
                            Text(
                                text = " int ",
                                style = MaterialTheme.typography.displaySmall,
                                color = if (darkTheme) {
                                    intov_dark
                                } else {
                                    intov_light
                                }
                            )
                            Text(text = "main()", style = MaterialTheme.typography.displaySmall)
                        }
                        Text(text = " {", style = MaterialTheme.typography.displaySmall)
                        Row {
                            Text(
                                text = "    std::cout << ",
                                style = MaterialTheme.typography.displaySmall,
                            )
                            Text(
                                text = " \"Hello World!\"",
                                style = MaterialTheme.typography.displaySmall,
                                color = if (darkTheme) {
                                    string_dark
                                } else {
                                    string_light
                                }
                            )
                            cartochca(viewModel = viewModel, index = 0)
                        }
                        Row {
                            Text(
                                text = "    return ",
                                style = MaterialTheme.typography.displaySmall,
                                color = if (darkTheme) {
                                    helper_dark
                                } else {
                                    helper_light
                                }
                            )
                            Text(text = "0", style = MaterialTheme.typography.displaySmall)
                            cartochca(viewModel = viewModel, index = 1)
                        }
                        Text(text = " }", style = MaterialTheme.typography.displaySmall)
                    }
                },
                viewModel, "Закончите инструкции правильными знаками",
                prog = 0.1f
            )
        }

        AnimatedVisibility(visible = viewModel.zadan == 3) {

            val radioButtons = remember {
                mutableStateListOf(
                    ToggleableInfo(
                        isChecked = false,
                        text = "{ }"
                    ),
                    ToggleableInfo(
                        isChecked = false,
                        text = "\" \""
                    ),
                    ToggleableInfo(
                        isChecked = false,
                        text = "< >"
                    ),
                    ToggleableInfo(
                        isChecked = false,
                        text = "( )"
                    )
                )
            }
            task_with_a_choise(radioButtons, "В какие знаки заключается блок кода", 0, viewModel, prog = 0.1f)
        }

        AnimatedVisibility(visible = viewModel.zadan == 4) {
            val youChoiseState = remember {
                mutableStateListOf(
                    "<<", ";", "{", ";", ">>", "}"
                )
            }
            val correrct = remember {
                listOf("{", "}")
            }
            lot_of_choise(
                variantCorrect = correrct,
                youChoise = youChoiseState,
                code = {
                    Column {
                        Row {
                            Row {
                                Text(
                                    text = " #include ",
                                    style = MaterialTheme.typography.displaySmall,

                                    )
                                Text(
                                    text = "<iostream>",
                                    style = MaterialTheme.typography.displaySmall,
                                    color = if (darkTheme) {
                                        string_dark
                                    } else {
                                        string_light
                                    }
                                )
                            }
                        }
                        Text(text = "", style = MaterialTheme.typography.displaySmall)
                        Row {
                            Text(
                                text = " int ",
                                style = MaterialTheme.typography.displaySmall,
                                color = if (darkTheme) {
                                    intov_dark
                                } else {
                                    intov_light
                                }
                            )
                            Text(text = "main()", style = MaterialTheme.typography.displaySmall)
                        }
                        cartochca(viewModel = viewModel, index = 0)
                        Row {
                            Text(
                                text = "    std::cout << ",
                                style = MaterialTheme.typography.displaySmall,
                            )
                            Text(
                                text = " \"Hello World!\"",
                                style = MaterialTheme.typography.displaySmall,
                                color = if (darkTheme) {
                                    string_dark
                                } else {
                                    string_light
                                }
                            )
                            Text(
                                text = ";",
                                style = MaterialTheme.typography.displaySmall,
                            )
                        }
                        Row {
                            Text(
                                text = "    return ",
                                style = MaterialTheme.typography.displaySmall,
                                color = if (darkTheme) {
                                    helper_dark
                                } else {
                                    helper_light
                                }
                            )
                            Text(text = "0;", style = MaterialTheme.typography.displaySmall)
                        }
                        cartochca(viewModel = viewModel, index = 1)
                    }
                },
                viewModel = viewModel,
                question = "Заключите блок кода в правильные знаки",
                prog = 0.1f
            )
        }

        AnimatedVisibility(visible = viewModel.zadan == 5) {

            val radioButtons = remember {
                mutableStateListOf(
                    ToggleableInfo(
                        isChecked = false,
                        text = "int"
                    ),
                    ToggleableInfo(
                        isChecked = false,
                        text = "run"
                    ),
                    ToggleableInfo(
                        isChecked = false,
                        text = "start"
                    ),
                    ToggleableInfo(
                        isChecked = false,
                        text = "main"
                    )
                )
            }
            task_with_a_choise(
                radioButtons,
                "Как называется, функция с которой начинается выполнение всей программы",
                3,
                viewModel,
                prog = 0.1f
            )
        }

        AnimatedVisibility(visible = viewModel.zadan == 6) {
            val youChoiseState = remember {
                mutableStateListOf(
                    "main", "run", "start", "function"
                )
            }

            val correrct = remember {
                listOf("main")
            }
            lot_of_choise(
                variantCorrect = correrct,
                youChoise = youChoiseState,
                code = {
                    Column {
                        Row {
                            Row {
                                Text(
                                    text = " #include ",
                                    style = MaterialTheme.typography.displaySmall,

                                    )
                                Text(
                                    text = "<iostream>",
                                    style = MaterialTheme.typography.displaySmall,
                                    color = if (darkTheme) {
                                        string_dark
                                    } else {
                                        string_light
                                    }
                                )
                            }
                        }
                        Text(text = "", style = MaterialTheme.typography.displaySmall)
                        Row {
                            Text(
                                text = " int ",
                                style = MaterialTheme.typography.displaySmall,
                                color = if (darkTheme) {
                                    intov_dark
                                } else {
                                    intov_light
                                }
                            )
                            cartochca(viewModel = viewModel, index = 0)
                            Text(text = "()", style = MaterialTheme.typography.displaySmall)
                        }
                        Text(text = " {", style = MaterialTheme.typography.displaySmall)
                        Row {
                            Text(
                                text = "    std::cout << ",
                                style = MaterialTheme.typography.displaySmall,
                            )
                            Text(
                                text = " \"Hello World!\"",
                                style = MaterialTheme.typography.displaySmall,
                                color = if (darkTheme) {
                                    string_dark
                                } else {
                                    string_light
                                }
                            )
                            Text(
                                text = ";",
                                style = MaterialTheme.typography.displaySmall,
                            )
                        }
                        Row {
                            Text(
                                text = "    return ",
                                style = MaterialTheme.typography.displaySmall,
                                color = if (darkTheme) {
                                    helper_dark
                                } else {
                                    helper_light
                                }
                            )
                            Text(text = "0;", style = MaterialTheme.typography.displaySmall)
                        }
                        Text(text = " }", style = MaterialTheme.typography.displaySmall)
                    }
                },
                viewModel = viewModel,
                question = "Дайте название функции, которая запустит программу",
                prog = 0.1f
            )

        }

        AnimatedVisibility(visible = viewModel.zadan == 7) {
            val radioButtons = remember {
                mutableStateListOf(
                    ToggleableInfo(
                        isChecked = false,
                        text = "include"
                    ),
                    ToggleableInfo(
                        isChecked = false,
                        text = "define"
                    ),
                    ToggleableInfo(
                        isChecked = false,
                        text = "error"
                    )
                )
            }
            task_with_a_choise(
                radioButtons,
                "Как нызывается директива подключения библиотек и сторонних файлов",
                0,
                viewModel,
                prog = 0.1f
            )
        }

        AnimatedVisibility(viewModel.zadan == 8) {
            val youChoiceState = remember {
                mutableStateListOf(
                    "#", "iostream", ">", "<", "}", "{", "include"
                )
            }
            val correrct = remember {
                listOf("#", "include", "<", "iostream", ">")
            }
            lot_of_choise(
                variantCorrect = correrct,
                youChoise = youChoiceState,
                code = {
                    Column {
                        Row {
                            cartochca(viewModel = viewModel, index = 0)
                            Spacer(modifier = Modifier.size(4.dp))
                            cartochca(viewModel = viewModel, index = 1)
                            Spacer(modifier = Modifier.size(4.dp))
                            cartochca(viewModel = viewModel, index = 2)
                            Spacer(modifier = Modifier.size(4.dp))
                            cartochca(viewModel = viewModel, index = 3)
                            Spacer(modifier = Modifier.size(4.dp))
                            cartochca(viewModel = viewModel, index = 4)
                        }
                        Text(text = "", style = MaterialTheme.typography.displaySmall)
                        Row {
                            Text(
                                text = " int ",
                                style = MaterialTheme.typography.displaySmall,
                                color = if (darkTheme) {
                                    intov_dark
                                } else {
                                    intov_light
                                }
                            )
                            Text(text = "main()", style = MaterialTheme.typography.displaySmall)
                        }
                        Text(text = " {", style = MaterialTheme.typography.displaySmall)
                        Row {
                            Text(
                                text = "    std::cout << ",
                                style = MaterialTheme.typography.displaySmall,
                            )
                            Text(
                                text = " \"Hello World!\"",
                                style = MaterialTheme.typography.displaySmall,
                                color = if (darkTheme) {
                                    string_dark
                                } else {
                                    string_light
                                }
                            )
                            Text(
                                text = ";",
                                style = MaterialTheme.typography.displaySmall,
                            )
                        }
                        Row {
                            Text(
                                text = "    return ",
                                style = MaterialTheme.typography.displaySmall,
                                color = if (darkTheme) {
                                    helper_dark
                                } else {
                                    helper_light
                                }
                            )
                            Text(text = "0;", style = MaterialTheme.typography.displaySmall)
                        }
                        Text(text = " }", style = MaterialTheme.typography.displaySmall)
                    }
                },
                viewModel = viewModel,
                question = "Подключите библиотеку iostream",
                prog = 0.1f
            )
        }

        AnimatedVisibility(visible = viewModel.zadan == 9) {
            val radioButtons = remember {
                mutableStateListOf(
                    ToggleableInfo(
                        isChecked = false,
                        text = "< и >"
                    ),
                    ToggleableInfo(
                        isChecked = false,
                        text = "# и <<"
                    ),
                    ToggleableInfo(
                        isChecked = false,
                        text = "// и /* */"
                    ),
                )
            }
            task_with_a_choise(
                radioButtons,
                "Укажите знаки, которые используются для комментирования строк",
                2,
                viewModel,
                prog = 0.1f
            )
        }

        AnimatedVisibility(viewModel.zadan == 10) {
            val youChoiseState = remember {
                mutableStateListOf(
                    "//", ";", "*/", ">>", "/*"
                )
            }
            val correrct = remember {
                listOf("/*", "*/", "//")
            }

            lot_of_choise(
                variantCorrect = correrct,
                youChoise = youChoiseState,
                code = {
                    Column {
                        Row {
                            Row {
                                Text(
                                    text = " #include ",
                                    style = MaterialTheme.typography.displaySmall,

                                    )
                                Text(
                                    text = "<iostream>",
                                    style = MaterialTheme.typography.displaySmall,
                                    color = if (darkTheme) {
                                        string_dark
                                    } else {
                                        string_light
                                    }
                                )
                            }
                        }
                        cartochca(viewModel = viewModel, index = 0)
                        Text(
                            text = "Закоментируйте эту строку",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                comment_dark
                            } else {
                                comment_light
                            }
                        )
                        cartochca(viewModel = viewModel, index = 1)
                        Row {
                            Text(
                                text = " int ",
                                style = MaterialTheme.typography.displaySmall,
                                color = if (darkTheme) {
                                    intov_dark
                                } else {
                                    intov_light
                                }
                            )
                            Text(text = "main()", style = MaterialTheme.typography.displaySmall)
                        }
                        Text(text = " {", style = MaterialTheme.typography.displaySmall)
                        Row {
                            Text(
                                text = "    std::cout << ",
                                style = MaterialTheme.typography.displaySmall,
                            )
                            Text(
                                text = " \"Hello World!\"",
                                style = MaterialTheme.typography.displaySmall,
                                color = if (darkTheme) {
                                    string_dark
                                } else {
                                    string_light
                                }
                            )
                            Text(
                                text = ";",
                                style = MaterialTheme.typography.displaySmall,
                            )
                            cartochca(viewModel = viewModel, index = 2)
                            Text(text = "вывод", style = MaterialTheme.typography.displaySmall, color = if(darkTheme) {comment_dark} else {comment_light})
                        }
                        Row {
                            Text(
                                text = "    return ",
                                style = MaterialTheme.typography.displaySmall,
                                color = if (darkTheme) {
                                    helper_dark
                                } else {
                                    helper_light
                                }
                            )
                            Text(text = "0;", style = MaterialTheme.typography.displaySmall)
                        }
                        Text(text = " }", style = MaterialTheme.typography.displaySmall)

                    }
                },
                viewModel = viewModel,
                question = "закоментируйте нужные строки правильно",
                prog = 0.1f
            )
        }
        if (viewModel.zadan > 10) {
            viewModel.update(LessonDestination.idlesson + 1, LessonDestination.idlesson)
            navController.navigate(FinishDestination.route)
        }
    }
}