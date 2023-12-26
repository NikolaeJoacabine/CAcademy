package com.nikolaej.cacademy.lessonLevel

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.nikolaej.cacademy.tipsTasck.ToggleableInfo
import com.nikolaej.cacademy.tipsTasck.task_with_a_choise
import com.nikolaej.cacademy.ui.screen.LessonDestination
import com.nikolaej.cacademy.ui.screen.LessonScreenViewModel
import com.nikolaej.cacademy.ui.theme.CAcademyTheme
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
                    Modifier.padding(4.dp)
                ) {
                    Row(
                        Modifier.fillMaxWidth()
                    ) {
                        Box(modifier = Modifier.width(16.dp)) {
                            Column {
                                Text(
                                    text = "1",
                                    style = MaterialTheme.typography.displaySmall,
                                    modifier = Modifier.alpha(0.4f)
                                )
                            }
                        }

                        Column(
                            Modifier.weight(1f)
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
                    Modifier.padding(4.dp)
                ) {
                    Row(
                        Modifier.fillMaxWidth()
                    ) {
                        Box(modifier = Modifier.width(16.dp)) {
                            Column {
                                for (i in 1..4) {
                                    Text(
                                        text = "$i",
                                        style = MaterialTheme.typography.displaySmall,
                                        modifier = Modifier.alpha(0.4f)
                                    )
                                }
                            }
                        }
                        Column(
                            Modifier.weight(1f)
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
                    Modifier.padding(4.dp)
                ) {
                    Row(
                        Modifier.fillMaxWidth()
                    ) {
                        Box(modifier = Modifier.width(16.dp)) {
                            Column {
                                for (i in 1..7) {
                                    Text(
                                        text = "$i",
                                        style = MaterialTheme.typography.displaySmall,
                                        modifier = Modifier.alpha(0.4f)
                                    )
                                }
                            }
                        }
                        Column(
                            Modifier.weight(1f)
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
                    Modifier.padding(4.dp)
                ) {
                    Row(
                        Modifier.fillMaxWidth()
                    ) {
                        Box(modifier = Modifier.width(16.dp)) {
                            Column {
                                for (i in 1..1) {
                                    Text(
                                        text = "$i",
                                        style = MaterialTheme.typography.displaySmall,
                                        modifier = Modifier.alpha(0.4f)
                                    )
                                }
                            }
                        }
                        Column(
                            Modifier.weight(1f)
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
                    Modifier.padding(4.dp)
                ) {
                    Row(
                        Modifier.fillMaxWidth()
                    ) {
                        Box(modifier = Modifier.width(16.dp)) {
                            Column {
                                Text(
                                    text = "1",
                                    style = MaterialTheme.typography.displaySmall,
                                    modifier = Modifier.alpha(0.4f)
                                )
                            }
                        }
                        Column(
                            Modifier.weight(1f)
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
                text = "Исходный код может содержать комментарии. Комментарии позволяют понять смысл программы, что делают те или иные ее части. При компиляции комментарии игнорируются и не оказывают никакого влияние на работу приложения и на его размер.",
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
                    Modifier.padding(4.dp)
                ) {
                    Row(
                        Modifier.fillMaxWidth()
                    ) {
                        Box(modifier = Modifier.width(16.dp)) {
                            Column {
                                for (i in 1..8) {
                                    Text(
                                        text = "$i",
                                        style = MaterialTheme.typography.displaySmall,
                                        modifier = Modifier.alpha(0.4f)
                                    )
                                }
                            }
                        }
                        Column(
                            Modifier.weight(1f)
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
                    Modifier.padding(4.dp)
                ) {
                    Row(
                        Modifier.fillMaxWidth()
                    ) {
                        Box(modifier = Modifier.width(16.dp)) {
                            Column {
                                for (i in 1..10) {
                                    Text(
                                        text = "$i",
                                        style = MaterialTheme.typography.displaySmall,
                                        modifier = Modifier.alpha(0.4f)
                                    )
                                }
                            }
                        }
                        Column(
                            Modifier.weight(1f)
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
                                text = "Выводит на консоль строку Hello World!",
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
    }
}

@Composable
fun Lesson_4Practice(
    viewModel: LessonScreenViewModel,
    navController: NavController
) {
    AnimatedVisibility(visible = viewModel.progress == 0f) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val radioButtons = remember {
                mutableStateListOf(
                    ToggleableInfo(
                        isChecked = false,
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
            task_with_a_choise(radioButtons, "привет", 1) { viewModel.progress += 0.1f }
        }
    }
}


@Preview
@Composable
fun ddd() {
    CAcademyTheme(false) {
        Lesson_4Theory(darkTheme = false)
    }
}