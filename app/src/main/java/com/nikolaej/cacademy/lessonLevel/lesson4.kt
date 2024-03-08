package com.nikolaej.cacademy.lessonLevel

import Cmain
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.nikolaej.cacademy.ui.theme.intov_dark
import com.nikolaej.cacademy.ui.theme.intov_light
import com.nikolaej.cacademy.ui.theme.peremenna_dark
import com.nikolaej.cacademy.ui.theme.peremenna_light
import com.nikolaej.cacademy.ui.theme.string_dark
import com.nikolaej.cacademy.ui.theme.string_light
import include

@Composable
fun Lesson4Theory(
    darkTheme: Boolean
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp)
    ) {
        item {
            Text(text = LessonDestination.nameLesson, style = MaterialTheme.typography.bodyLarge)
            Text(
                style = MaterialTheme.typography.bodySmall,
                text = "Для хранения данных в программе в языке C++ используются переменные.Переменные - это как коробки, в которые мы можем положить что-то (данные), а затем использовать это позже. Переменная имеет тип, имя и значение. Тип определяет, какие именно данные может хранить переменная."
            )

            Text(
                style = MaterialTheme.typography.bodySmall,
                text = "Перед использованием любую переменную надо определить. Синтаксис определения переменной выглядит следующим образом:"
            )
            Card(
                Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    Modifier.padding(4.dp)
                ) {
                    Text(
                        modifier = Modifier.horizontalScroll(rememberScrollState()),
                        text = " тип_переменной имя_переменной;",
                        style = MaterialTheme.typography.displaySmall,
                    )
                }
            }
            Text(text = "Именование переменных", style = MaterialTheme.typography.bodyMedium)
            val bullet = "\u2022"
            val messages = listOf(
                "имена, которые начинаются с двух подчеркиваний",
                "имена, которые начинаются с подчеркивания, за которым идет заглавный алфавитный символ",
                "имена в глобальной области (вне функции main), которые начинаются с подчеркивания"
            )
            Text(
                buildAnnotatedString {
                    messages.forEach {
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.W300,
                                fontSize = 17.sp
                            )
                        ) {
                            append(bullet)
                            append("\t\t")
                            append(it + "\n")
                        }
                    }
                }
            )
            Text(
                style = MaterialTheme.typography.bodySmall,
                text = "Дело в том, что при подобных именах повышается вероятность, что подобные названия будут конфликтовать с именами (например, именами переменных), которые генерирует компилятор или которые определены в подключаемых стандартных модулях C++. Поэтому некоторые вообще не рекомендуют начинать имя с символа подчеркивания."
            )
            Text(
                style = MaterialTheme.typography.bodySmall,
                text = "Например, простейшее определение переменной:"
            )
            Card(
                Modifier
                    .padding(4.dp)
            ) {
                Column(
                    Modifier
                        .padding(4.dp)
                        .fillMaxSize()
                ) {

                    Row {
                        Text(
                            text = "int",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                intov_dark
                            } else {
                                intov_light
                            }
                        )
                        Text(
                            text = " age",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                peremenna_dark
                            } else {
                                peremenna_light
                            }
                        )
                        Text(text = ";", style = MaterialTheme.typography.displaySmall)
                    }
                }
            }
            Text(buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W300, fontSize = 17.sp)) {
                    append("Здесь определена переменная age, которая имеет тип ")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W900,
                        textDecoration = TextDecoration.Underline,
                        fontSize = 17.sp
                    )
                ) {
                    append("int")
                }
                withStyle(style = SpanStyle(fontWeight = FontWeight.W300, fontSize = 17.sp)) {
                    append(". Поскольку определение переменной представляет собой инструкцию, то после него ставится точка с запятой.")
                }
            })
            Text(
                style = MaterialTheme.typography.bodySmall,
                text = "Также стоит учитывать, что C++ - регистрозависимый язык, а это значит, что регистр символов имеет большое значение. То есть в следующем коде будут определяться две разные переменные:"
            )
            Card(
                Modifier
                    .padding(4.dp)
            ) {
                Column(
                    Modifier
                        .padding(4.dp)
                        .fillMaxSize()
                ) {
                    Row {
                        Text(
                            text = "int",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                intov_dark
                            } else {
                                intov_light
                            }
                        )
                        Text(
                            text = " age",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                peremenna_dark
                            } else {
                                peremenna_light
                            }
                        )
                        Text(text = ";", style = MaterialTheme.typography.displaySmall)
                    }
                    Row {
                        Text(
                            text = "int",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                intov_dark
                            } else {
                                intov_light
                            }
                        )
                        Text(
                            text = " Age",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                peremenna_dark
                            } else {
                                peremenna_light
                            }
                        )
                        Text(text = ";", style = MaterialTheme.typography.displaySmall)
                    }
                }
            }
            Text(
                style = MaterialTheme.typography.bodySmall,
                text = "Поэтому переменная Age не будет представлять то же самое, что и переменная age."
            )
            Text(
                style = MaterialTheme.typography.bodySmall,
                text = "Также нельзя объявить больше одной переменной с одним и тем же именем, например:"
            )
            Card(
                Modifier
                    .padding(4.dp)
            ) {
                Column(
                    Modifier
                        .padding(4.dp)
                        .fillMaxSize()
                ) {
                    Row {
                        Text(
                            text = "int",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                intov_dark
                            } else {
                                intov_light
                            }
                        )
                        Text(
                            text = " age",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                peremenna_dark
                            } else {
                                peremenna_light
                            }
                        )
                        Text(text = ";", style = MaterialTheme.typography.displaySmall)
                    }
                    Row {
                        Text(
                            text = "int",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                intov_dark
                            } else {
                                intov_light
                            }
                        )
                        Text(
                            text = " age",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                peremenna_dark
                            } else {
                                peremenna_light
                            }
                        )
                        Text(text = ";", style = MaterialTheme.typography.displaySmall)
                    }
                }
            }
            Text(
                style = MaterialTheme.typography.bodySmall,
                text = "Подобное определение вызовет ошибку на этапе компиляции."
            )
            Text(text = "Инициализация", style = MaterialTheme.typography.bodyMedium)
            Text(
                style = MaterialTheme.typography.bodySmall,
                text = "После определения переменной можно присвоить некоторое значение. Присвоение переменной начального значения называется инициализацией. В C++ есть три вида инициализации:"
            )
            val messagesi = listOf(
                "Нотация присваивания (assignment notation)",
                "Функциональная нотация (functional notation)",
                "Инициализация в фигурных скобках (braced initialization)"
            )
            Text(
                buildAnnotatedString {
                    messagesi.forEach {
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.W300,
                                fontSize = 17.sp
                            )
                        ) {
                            append(bullet)
                            append("\t\t")
                            append(it + "\n")
                        }
                    }
                }
            )
            Text(
                style = MaterialTheme.typography.bodySmall,
                text = "Рассмотрим все эти виды инициализаций"
            )
            Text(
                text = "Нотация присваивания",
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 17.sp)
            )
            Text(
                style = MaterialTheme.typography.bodySmall,
                text = "Суть нотациия присваивания - с помощью оператора присваивания (знак \"равно\" или =) переменной передаем некоторое значение:"
            )
            Card(
                Modifier
                    .padding(4.dp)
            ) {
                Column(
                    Modifier
                        .padding(4.dp)
                        .fillMaxSize()
                ) {
                    Row {
                        Text(
                            text = "int",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                intov_dark
                            } else {
                                intov_light
                            }
                        )
                        Text(
                            text = " age",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                peremenna_dark
                            } else {
                                peremenna_light
                            }
                        )
                        Text(text = ";", style = MaterialTheme.typography.displaySmall)
                    }
                    Row {
                        Text(
                            text = "age",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                peremenna_dark
                            } else {
                                peremenna_light
                            }
                        )
                        Text(
                            text = "  = 20;",
                            style = MaterialTheme.typography.displaySmall,
                        )
                    }
                }
            }
            Text(buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W300, fontSize = 17.sp)) {
                    append("Здесь в качестве значения переменной присваивается число 20. Постоянные значения любого типа, наподобие чисел, символов, строк, такие как 20, 123.456 (дробное число), \"A\" или \"hello\", называются ")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W900,
                        textDecoration = TextDecoration.Underline,
                        fontSize = 17.sp
                    )
                ) {
                    append("литералами")
                }
                withStyle(style = SpanStyle(fontWeight = FontWeight.W300, fontSize = 17.sp)) {
                    append(". То есть в данном случае переменной присваивается целочисленный литерал 20.")
                }
            })
            Text(
                style = MaterialTheme.typography.bodySmall,
                text = "Например, определим в программе переменную и выведем ее значение на консоль:"
            )
            Card(
                Modifier.padding(4.dp)
            ) {
                Column(
                    Modifier
                        .padding(4.dp)
                        .fillMaxSize()
                ) {
                    Row {
                        Text(
                            text = " #include ",
                            style = MaterialTheme.typography.displaySmall,

                            )
                        Text(
                            text = "<iostream>\n",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                string_dark
                            } else {
                                string_light
                            }
                        )
                    }
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
                    Text(text = "{", style = MaterialTheme.typography.displaySmall)
                    Row {
                        Text(
                            text = "    int",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                intov_dark
                            } else {
                                intov_light
                            }
                        )
                        Text(
                            text = " age",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                peremenna_dark
                            } else {
                                peremenna_light
                            }
                        )
                        Text(text = ";", style = MaterialTheme.typography.displaySmall)
                    }
                    Row {
                        Text(
                            text = "    age",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                peremenna_dark
                            } else {
                                peremenna_light
                            }
                        )
                        Text(
                            text = "  = 28;",
                            style = MaterialTheme.typography.displaySmall,
                        )
                        Text(text = ";", style = MaterialTheme.typography.displaySmall)
                    }
                    Row {
                        Text(
                            text = "    std::cout << ",
                            style = MaterialTheme.typography.displaySmall,
                        )
                        Text(
                            text = " \"Age = \"",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                string_dark
                            } else {
                                string_light
                            }
                        )
                        Text(
                            text = " << ",
                            style = MaterialTheme.typography.displaySmall,
                        )
                        Text(
                            text = " age",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                peremenna_dark
                            } else {
                                peremenna_light
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
                text = "С помощью последовательности операторов << можно вывести несколько значений на консоль.",
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = "После компиляции и запуска скомпилированной программы на консоль будет выведено число 28.",
                style = MaterialTheme.typography.bodySmall
            )
            Card(
                shape = RoundedCornerShape(0.dp),
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Age = 28",
                    Modifier.padding(4.dp),
                    style = MaterialTheme.typography.bodySmall
                )
            }
            Text(
                text = "Можно сразу при определении переменной дать ей некоторое начальное значение:",
                style = MaterialTheme.typography.bodySmall
            )
            Card(
                Modifier.padding(4.dp)
            ) {
                Column(
                    Modifier
                        .padding(4.dp)
                        .fillMaxSize()
                ) {
                    Row {
                        Text(
                            text = " #include ",
                            style = MaterialTheme.typography.displaySmall,

                            )
                        Text(
                            text = "<iostream>\n",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                string_dark
                            } else {
                                string_light
                            }
                        )
                    }
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
                    Text(text = "{", style = MaterialTheme.typography.displaySmall)
                    Row {
                        Text(
                            text = "    int",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                intov_dark
                            } else {
                                intov_light
                            }
                        )
                        Text(
                            text = " age = 28;",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                peremenna_dark
                            } else {
                                peremenna_light
                            }
                        )
                        Text(text = ";", style = MaterialTheme.typography.displaySmall)
                    }
                    Row {
                        Text(
                            text = "    std::cout << ",
                            style = MaterialTheme.typography.displaySmall,
                        )
                        Text(
                            text = " \"Age = \"",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                string_dark
                            } else {
                                string_light
                            }
                        )
                        Text(
                            text = " << ",
                            style = MaterialTheme.typography.displaySmall,
                        )
                        Text(
                            text = " age",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                peremenna_dark
                            } else {
                                peremenna_light
                            }
                        )
                        Text(
                            text = ";",
                            style = MaterialTheme.typography.displaySmall,
                        )
                    }
                    Text(text = "{", style = MaterialTheme.typography.displaySmall)
                }
            }
            Text(
                text = "Инициализация в фигурных скобках",
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 17.sp)
            )
            Text(
                text = "При инициализации braced initialization после названия переменной в фигурных скобках указывается ее значение:",
                style = MaterialTheme.typography.bodySmall
            )
            Card(
                Modifier.padding(4.dp)
            ) {
                Column(
                    Modifier
                        .padding(4.dp)
                        .fillMaxWidth()
                ) {
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
                        Text(
                            text = " age",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                peremenna_dark
                            } else {
                                peremenna_light
                            }
                        )
                        Text(
                            text = " { 38 };",
                            style = MaterialTheme.typography.displaySmall,
                        )
                    }
                }
            }
            Text(
                text = "В данном случае переменная будет иметь значение 38.",
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = "Функциональная нотация",
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 17.sp)
            )
            Text(
                text = "При функциональной нотации после названия переменной в круглых скобках указывается ее значение:",
                style = MaterialTheme.typography.bodySmall
            )
            Card(
                Modifier.padding(4.dp)
            ) {
                Column(
                    Modifier
                        .padding(4.dp)
                        .fillMaxWidth()
                ) {
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
                        Text(
                            text = " age",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                peremenna_dark
                            } else {
                                peremenna_light
                            }
                        )
                        Text(
                            text = " ( 38 );",
                            style = MaterialTheme.typography.displaySmall,
                        )
                    }
                }
            }
            Text(
                text = "В данном случае переменная будет иметь значение 38.",
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = "Во всех трех случаях присваиваемое переменной значение может представлять сложное вычисляемое выражение. Например:",
                style = MaterialTheme.typography.bodySmall
            )
            Card(
                Modifier.padding(4.dp)
            ) {
                Column(
                    Modifier
                        .padding(4.dp)
                        .fillMaxWidth()
                ) {
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
                        Text(
                            text = " age1",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                peremenna_dark
                            } else {
                                peremenna_light
                            }
                        )
                        Text(
                            text = " {22 + 5};",
                            style = MaterialTheme.typography.displaySmall,
                        )
                    }
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
                        Text(
                            text = " age2",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                peremenna_dark
                            } else {
                                peremenna_light
                            }
                        )
                        Text(
                            text = " (22 + 5);",
                            style = MaterialTheme.typography.displaySmall,
                        )
                    }
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
                        Text(
                            text = " age3",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                peremenna_dark
                            } else {
                                peremenna_light
                            }
                        )
                        Text(
                            text = " = 22 + 5;",
                            style = MaterialTheme.typography.displaySmall,
                        )
                    }
                }
            }
            Text(
                text = "Можно сразу инициализировать несколько переменных:",
                style = MaterialTheme.typography.bodySmall
            )
            Card(
                Modifier.padding(4.dp)
            ) {
                Column(
                    Modifier
                        .padding(4.dp)
                        .fillMaxWidth()
                ) {
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
                        Text(
                            text = " age1",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                peremenna_dark
                            } else {
                                peremenna_light
                            }
                        )
                        Text(
                            text = " {22},",
                            style = MaterialTheme.typography.displaySmall,
                        )
                        Text(
                            text = " age2",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                peremenna_dark
                            } else {
                                peremenna_light
                            }
                        )
                        Text(
                            text = " (23),",
                            style = MaterialTheme.typography.displaySmall,
                        )
                        Text(
                            text = " age3",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                peremenna_dark
                            } else {
                                peremenna_light
                            }
                        )
                        Text(
                            text = " = 24;",
                            style = MaterialTheme.typography.displaySmall,
                        )
                    }
                }
            }
            Text(
                text = "В большинстве случаев все три варианта инициализации эквивалентны. Однако инициализация в фигурных скобках немного безопаснее, когда применяется сужающее преобразование. В общем случае ожидается, что переменной передается значение, которое соответствует ее типу. Если же это не так, то компилятор попытается преобразовать присваиваемое значение в тип переменной. Сужающее преобразование изменяет значение одного типа на тип с более ограниченным диапазоном значений. Таким образом, преобразование может привести к потере информации. Возьмем следующий пример:",
                style = MaterialTheme.typography.bodySmall
            )
            Card(
                Modifier.padding(4.dp)
            ) {
                Column(
                    Modifier
                        .padding(4.dp)
                        .fillMaxSize()
                ) {
                    Row {
                        Text(
                            text = " #include ",
                            style = MaterialTheme.typography.displaySmall,

                            )
                        Text(
                            text = "<iostream>\n",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                string_dark
                            } else {
                                string_light
                            }
                        )
                    }
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
                    Text(text = "{", style = MaterialTheme.typography.displaySmall)
                    Row {
                        Text(
                            text = "    int",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                intov_dark
                            } else {
                                intov_light
                            }
                        )
                        Text(
                            text = " age1",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                peremenna_dark
                            } else {
                                peremenna_light
                            }
                        )
                        Text(text = " (23.5);", style = MaterialTheme.typography.displaySmall)
                    }
                    Row {
                        Text(
                            text = "    int",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                intov_dark
                            } else {
                                intov_light
                            }
                        )
                        Text(
                            text = " age2",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                peremenna_dark
                            } else {
                                peremenna_light
                            }
                        )
                        Text(text = " = 24.5;", style = MaterialTheme.typography.displaySmall)
                    }
                    Row {
                        Text(
                            text = "    std::cout << ",
                            style = MaterialTheme.typography.displaySmall,
                        )
                        Text(
                            text = " \"Age1 = \"",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                string_dark
                            } else {
                                string_light
                            }
                        )
                        Text(
                            text = " << ",
                            style = MaterialTheme.typography.displaySmall,
                        )
                        Text(
                            text = " age1",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                peremenna_dark
                            } else {
                                peremenna_light
                            }
                        )
                        Text(
                            text = " << ",
                            style = MaterialTheme.typography.displaySmall,
                        )

                        Text(
                            text = "\"\\n\"",
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
                            text = " \"Age2 = \"",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                string_dark
                            } else {
                                string_light
                            }
                        )
                        Text(
                            text = " << ",
                            style = MaterialTheme.typography.displaySmall,
                        )
                        Text(
                            text = " age2",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                peremenna_dark
                            } else {
                                peremenna_light
                            }
                        )
                        Text(
                            text = " << ",
                            style = MaterialTheme.typography.displaySmall,
                        )

                        Text(
                            text = "\"\\n\"",
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
                text = "Здесь переменным age1 и age2, которые представляют тип int, то есть целое число, присваивается дробное значение - 23.5 и 24.5 соответственно. Но в большинстве компиляторов, по крайней мере на момент написания данной статьи, этот код нормально скомпилируется и выполнится. Мы получим следующий вывод:",
                style = MaterialTheme.typography.bodySmall
            )
            Card(
                shape = RoundedCornerShape(0.dp),
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Age1 = 23",
                    Modifier.padding(4.dp),
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Age2 = 24",
                    Modifier.padding(4.dp),
                    style = MaterialTheme.typography.bodySmall
                )
            }
            Text(
                text = "Теперь возьмем пример с инициализацией через фигурные скобки:",
                style = MaterialTheme.typography.bodySmall
            )
            Card(
                Modifier.padding(4.dp)
            ) {
                Column(
                    Modifier
                        .padding(4.dp)
                        .fillMaxSize()
                ) {
                    Row {
                        Text(
                            text = " #include ",
                            style = MaterialTheme.typography.displaySmall,

                            )
                        Text(
                            text = "<iostream>\n",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                string_dark
                            } else {
                                string_light
                            }
                        )
                    }
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
                    Text(text = "{", style = MaterialTheme.typography.displaySmall)
                    Row {
                        Text(
                            text = "    int",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                intov_dark
                            } else {
                                intov_light
                            }
                        )
                        Text(
                            text = " age",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                peremenna_dark
                            } else {
                                peremenna_light
                            }
                        )
                        Text(text = " {22.5};", style = MaterialTheme.typography.displaySmall)
                    }
                    Row {
                        Text(
                            text = "    std::cout << ",
                            style = MaterialTheme.typography.displaySmall,
                        )
                        Text(
                            text = " \"Age = \"",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                string_dark
                            } else {
                                string_light
                            }
                        )
                        Text(
                            text = " << ",
                            style = MaterialTheme.typography.displaySmall,
                        )
                        Text(
                            text = " age",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                peremenna_dark
                            } else {
                                peremenna_light
                            }
                        )
                        Text(
                            text = " << ",
                            style = MaterialTheme.typography.displaySmall,
                        )

                        Text(
                            text = "\"\\n\"",
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
                text = "Здесь переменной age, которая также представляет целое число, также присваивается дробное значение - 22.5. Однако теперь при компиляции многие компиляторы сообщат нам об ошибке.",
                style = MaterialTheme.typography.bodySmall
            )
            Text(text = "Инициализация нулем", style = MaterialTheme.typography.bodyMedium)
            Card(
                Modifier.padding(4.dp)
            ) {
                Column(
                    Modifier
                        .padding(4.dp)
                        .fillMaxSize()
                ) {
                    Row {
                        Text(
                            text = "int",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                intov_dark
                            } else {
                                intov_light
                            }
                        )
                        Text(
                            text = " counter ",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                peremenna_dark
                            } else {
                                peremenna_light
                            }
                        )
                        Text(
                            text = "{};",
                            style = MaterialTheme.typography.displaySmall
                        )
                    }
                }
            }
            Text(
                text = "В этом случае переменная будет инициализироваться нулем и фактически будет аналогично коду:",
                style = MaterialTheme.typography.bodySmall
            )
            Card(
                Modifier.padding(4.dp)
            ) {
                Column(
                    Modifier
                        .padding(4.dp)
                        .fillMaxSize()
                ) {
                    Row {
                        Text(
                            text = "int",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                intov_dark
                            } else {
                                intov_light
                            }
                        )
                        Text(
                            text = " counter ",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                peremenna_dark
                            } else {
                                peremenna_light
                            }
                        )
                        Text(
                            text = "{0};",
                            style = MaterialTheme.typography.displaySmall
                        )
                    }
                }
            }
            Text(text = "Инициализация по умолчанию", style = MaterialTheme.typography.bodyMedium)
            Text(
                text = "Если переменную не инициализировать, то происходит ее инициализация по умолчанию. И переменная получает некоторое значение по умолчанию, которое зависит от места, где эта переменная определена.",
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = "Но в любом случае перед использованием переменной лучше явным образом назначать ей определенное значение, а не полагаться на значение по умолчанию.",
                style = MaterialTheme.typography.bodySmall
            )
            Text(text = "Изменение значения", style = MaterialTheme.typography.bodyMedium)
            Text(
                text = "Ключевой особенностью переменных является то, что мы можем изменять их значения:Ключевой особенностью переменных является то, что мы можем изменять их значения:",
                style = MaterialTheme.typography.bodySmall
            )
            Card(
                Modifier.padding(4.dp)
            ) {
                Column(
                    Modifier
                        .padding(4.dp)
                        .fillMaxSize()
                ) {
                    Row {
                        Text(
                            text = " #include ",
                            style = MaterialTheme.typography.displaySmall,

                            )
                        Text(
                            text = "<iostream>\n",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                string_dark
                            } else {
                                string_light
                            }
                        )
                    }
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
                    Text(text = "{", style = MaterialTheme.typography.displaySmall)
                    Row {
                        Text(
                            text = "    int",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                intov_dark
                            } else {
                                intov_light
                            }
                        )
                        Text(
                            text = " age ",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                peremenna_dark
                            } else {
                                peremenna_light
                            }
                        )
                        Text(
                            text = "= 22;",
                            style = MaterialTheme.typography.displaySmall
                        )
                    }
                    Row {
                        Text(
                            text = "    std::cout << ",
                            style = MaterialTheme.typography.displaySmall,
                        )
                        Text(
                            text = " \"Age1 = \"",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                string_dark
                            } else {
                                string_light
                            }
                        )
                        Text(
                            text = " << ",
                            style = MaterialTheme.typography.displaySmall,
                        )
                        Text(
                            text = " age",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                peremenna_dark
                            } else {
                                peremenna_light
                            }
                        )
                        Text(
                            text = " << ",
                            style = MaterialTheme.typography.displaySmall,
                        )

                        Text(
                            text = "\"\\n\"",
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
                            text = "    age ",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                peremenna_dark
                            } else {
                                peremenna_light
                            }
                        )
                        Text(
                            text = "= 23;",
                            style = MaterialTheme.typography.displaySmall
                        )
                    }
                    Row {
                        Text(
                            text = "    std::cout << ",
                            style = MaterialTheme.typography.displaySmall,
                        )
                        Text(
                            text = " \"Age2 = \"",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                string_dark
                            } else {
                                string_light
                            }
                        )
                        Text(
                            text = " << ",
                            style = MaterialTheme.typography.displaySmall,
                        )
                        Text(
                            text = " age",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                peremenna_dark
                            } else {
                                peremenna_light
                            }
                        )
                        Text(
                            text = " << ",
                            style = MaterialTheme.typography.displaySmall,
                        )

                        Text(
                            text = "\"\\n\"",
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
                            text = "    age ",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                peremenna_dark
                            } else {
                                peremenna_light
                            }
                        )
                        Text(
                            text = "= 38;",
                            style = MaterialTheme.typography.displaySmall
                        )
                    }
                    Row {
                        Text(
                            text = "    std::cout << ",
                            style = MaterialTheme.typography.displaySmall,
                        )
                        Text(
                            text = " \"Age3 = \"",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                string_dark
                            } else {
                                string_light
                            }
                        )
                        Text(
                            text = " << ",
                            style = MaterialTheme.typography.displaySmall,
                        )
                        Text(
                            text = " age",
                            style = MaterialTheme.typography.displaySmall,
                            color = if (darkTheme) {
                                peremenna_dark
                            } else {
                                peremenna_light
                            }
                        )
                        Text(
                            text = " << ",
                            style = MaterialTheme.typography.displaySmall,
                        )

                        Text(
                            text = "\"\\n\"",
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
                text = "Консольный вывод программы:",
                style = MaterialTheme.typography.bodySmall
            )
            Card(
                shape = RoundedCornerShape(0.dp),
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Age1 = 22",
                    Modifier.padding(4.dp),
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Age2 = 23",
                    Modifier.padding(4.dp),
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Age3 = 38",
                    Modifier.padding(4.dp),
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Composable
fun Lesson4Practice(
    viewModel: LessonScreenViewModel,
    navController: NavController,
    darkTheme: Boolean
) {
    Column(
        Modifier.fillMaxSize()
    ) {
        AnimatedVisibility(visible = viewModel.zadan == 1) {
            val youChoiseState = remember {
                mutableStateListOf(
                    "int", ";", "distance", "<<", "}"
                )
            }
            val correrct = remember {
                listOf("int", "distance", ";")
            }
            lot_of_choise(
                variantCorrect = correrct,
                youChoise = youChoiseState,
                code = {
                    Column {
                        include(darkTheme = darkTheme)
                        Cmain(darkTheme = darkTheme)
                        Text(text = "{", style = MaterialTheme.typography.displaySmall)
                        Row {
                            cartochca(viewModel = viewModel, index = 0)
                            cartochca(viewModel = viewModel, index = 1)
                            cartochca(viewModel = viewModel, index = 2)
                        }
                        Text(text = "}", style = MaterialTheme.typography.displaySmall)
                    }
                },
                viewModel = viewModel,
                question = "определите правильно целоцисленную переменную distance",
                prog = 0.25f
            )
        }
        AnimatedVisibility(visible = viewModel.zadan == 2) {
            val radioButtons = remember {
                mutableStateListOf(
                    ToggleableInfo(
                        isChecked = false,
                        text = "1age"
                    ),
                    ToggleableInfo(
                        isChecked = false,
                        text = "ag e"
                    ),
                    ToggleableInfo(
                        isChecked = false,
                        text = "age"
                    )
                )
            }

            task_with_a_choise(
                radioButtons,
                "Выберите допустимое имя переменной",
                2,
                viewModel,
                prog = 0.25f
            )
        }
        AnimatedVisibility(visible = viewModel.zadan == 3) {
            val radioButtons = remember {
                mutableStateListOf(
                    ToggleableInfo(
                        isChecked = false,
                        text = "Да"
                    ),
                    ToggleableInfo(
                        isChecked = false,
                        text = "Нет"
                    )
                )
            }

            task_with_a_choise(
                radioButtons,
                "можно ли инициализировать сразу несколько переменных?",
                0,
                viewModel,
                prog = 0.25f
            )
        }
        AnimatedVisibility(visible = viewModel.zadan == 4) {
            val youChoiseState = remember {
                mutableStateListOf(
                    ")", "age1", "=",  "}", "<<","{", "("
                )
            }
            val correrct = remember {
                listOf("age1", "=", "{", "}", "(", ")")
            }
            lot_of_choise(
                variantCorrect = correrct,
                youChoise = youChoiseState,
                code = {
                    Column {
                        include(darkTheme = darkTheme)
                        Cmain(darkTheme = darkTheme)
                        Text(text = "{", style = MaterialTheme.typography.displaySmall)
                        Row {
                            Text(
                                text = "    int",
                                style = MaterialTheme.typography.displaySmall,
                                color = if (darkTheme) {
                                    intov_dark
                                } else {
                                    intov_light
                                }
                            )
                            Text(
                                text = " age1;",
                                style = MaterialTheme.typography.displaySmall,
                                color = if (darkTheme) {
                                    peremenna_dark
                                } else {
                                    peremenna_light
                                }
                            )
                        }
                        Row{
                            Text(
                                text = "    ",
                                style = MaterialTheme.typography.displaySmall)
                            cartochca(viewModel = viewModel, index = 0)
                            cartochca(viewModel = viewModel, index = 1)
                            Text(
                                text = "23;",
                                style = MaterialTheme.typography.displaySmall)
                        }

                        Row {
                            Text(
                                text = "    int",
                                style = MaterialTheme.typography.displaySmall,
                                color = if (darkTheme) {
                                    intov_dark
                                } else {
                                    intov_light
                                }
                            )
                            Text(
                                text = " age2 ",
                                style = MaterialTheme.typography.displaySmall,
                                color = if (darkTheme) {
                                    peremenna_dark
                                } else {
                                    peremenna_light
                                }
                            )
                            cartochca(viewModel = viewModel, index = 2)
                            Text(
                                text = " 25 ",
                                style = MaterialTheme.typography.displaySmall
                            )
                            cartochca(viewModel = viewModel, index = 3)
                            Text(
                                text = ";",
                                style = MaterialTheme.typography.displaySmall
                            )
                        }
                        Row {
                            Text(
                                text = "    int",
                                style = MaterialTheme.typography.displaySmall,
                                color = if (darkTheme) {
                                    intov_dark
                                } else {
                                    intov_light
                                }
                            )
                            Text(
                                text = " age3 ",
                                style = MaterialTheme.typography.displaySmall,
                                color = if (darkTheme) {
                                    peremenna_dark
                                } else {
                                    peremenna_light
                                }
                            )
                            cartochca(viewModel = viewModel, index = 4)
                            Text(
                                text = " 29 ",
                                style = MaterialTheme.typography.displaySmall
                            )
                            cartochca(viewModel = viewModel, index = 5)
                            Text(
                                text = ";",
                                style = MaterialTheme.typography.displaySmall
                            )
                        }


                        Text(text = "}", style = MaterialTheme.typography.displaySmall)
                    }
                },
                viewModel = viewModel,
                question = "Инициализируйте первую переменную при помощи нотации присвания, вторую с помощью функциональной нотации, и третью при помощи инициализации в фигурных скобках.",
                prog = 0.25f
            )
        }
        if (viewModel.zadan > 4) {
            viewModel.update(LessonDestination.idlesson + 1, LessonDestination.idlesson)
            navController.navigate(FinishDestination.route)
        }
    }
}