package com.nikolaej.cacademy.lessonLevel

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
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nikolaej.cacademy.ui.theme.CAcademyTheme
import com.nikolaej.cacademy.ui.theme.intov_dark
import com.nikolaej.cacademy.ui.theme.intov_light
import com.nikolaej.cacademy.ui.theme.peremenna_dark
import com.nikolaej.cacademy.ui.theme.peremenna_light

@Composable
fun Lesson4Theory(
    darkTheme: Boolean
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        item {
            Text(
                style = MaterialTheme.typography.bodySmall,
                text = "Для хранения данных в программе в языке C++ используются переменные.Переменные - это как коробки, в которые мы можем положить что-то (данные), а затем использовать это позже. Каждая коробка (переменная) имеет свое имя, чтобы мы могли найти нужную нам коробку. Синтаксис определения переменной выглядит следующим образом:"
            )
            Card(
                Modifier
                    .padding(4.dp)
            ) {
                Column(
                    Modifier.padding(4.dp)
                ) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                    ) {
                        Box(modifier = Modifier.width(16.dp)) {
                            Column {
                                Text(text = "1", style = MaterialTheme.typography.displaySmall, modifier = Modifier.alpha(0.4f))
                            }
                        }
                        Column(
                            Modifier
                                .weight(1f)
                        ) {
                            Text(
                                modifier = Modifier.horizontalScroll(rememberScrollState()),
                                text = " тип_переменной имя_переменной;",
                                style = MaterialTheme.typography.displaySmall,
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.size(4.dp))

            Text(
                style = MaterialTheme.typography.bodySmall,
                text = "Данная строка выводит на консоль строку \"Hello world!\", является инструкцией и поэтому завершается точкой с запятой."
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                style = MaterialTheme.typography.bodySmall,
                text = "Набор инструкций может представлять блок кода. Блок кода заключается в фигурные скобки, а инструкции помещаются между открывающей и закрывающей фигурными скобками:"
            )
            Card(
                Modifier
                    .padding(4.dp)
            ) {
                Column(
                    Modifier.padding(4.dp)
                ) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                    ) {
                        Box(modifier = Modifier.width(16.dp)) {
                            Column {
                                Text(text = "1", style = MaterialTheme.typography.displaySmall, modifier = Modifier.alpha(0.4f))
                            }
                        }

                        Column(
                            Modifier
                                .weight(1f)
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
                }
            }
            Text(buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W300, fontSize = 17.sp)){
                    append("Здесь определена переменная age, которая имеет тип ")
                }
                withStyle(style = SpanStyle(fontWeight = FontWeight.W900, textDecoration = TextDecoration.Underline, fontSize = 17.sp)) {
                    append("int")
                }
                withStyle(style = SpanStyle(fontWeight = FontWeight.W300, fontSize = 17.sp)){
                    append(". Поскольку определение переменной представляет собой инструкцию, то после него ставится точка с запятой.")
                }
            })
        }
    }
}

@Composable
fun Lesson4Practice() {

}

@Preview
@Composable
fun fff() {
    CAcademyTheme(darkTheme = true) {
        Lesson4Theory(true)
    }
}