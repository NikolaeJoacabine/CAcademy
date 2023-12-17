package com.nikolaej.cacademy.lessonLevel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nikolaej.cacademy.ui.screen.FinishDestination
import com.nikolaej.cacademy.ui.screen.LessonDestination
import com.nikolaej.cacademy.ui.screen.LessonScreenViewModel

@Composable
fun Lesson2Theory() {
    LazyColumn(Modifier.fillMaxSize().padding(horizontal = 8.dp), ) {
        item {
            Text(text = LessonDestination.nameLesson, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "1.Процедурное программирование:", fontWeight = FontWeight.Bold)
            Text(style = MaterialTheme.typography.bodySmall,modifier = Modifier.padding(start = 8.dp),text = "Это один из самых старых подходов к программированию. В процедурном программировании задачи решаются с помощью процедур, которые представляют собой наборы инструкций. Примеры языков: C, Fortran.")
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "2.Объектно-ориентированное программирование (ООП):", fontWeight = FontWeight.Bold)
            Text(style = MaterialTheme.typography.bodySmall,modifier = Modifier.padding(start = 8.dp),text = "В ООП используются объекты и классы для создания более сложных структур данных и программ. Примеры языков: Java, C++, Python.")
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "3.Функциональное программирование:", fontWeight = FontWeight.Bold)
            Text(style = MaterialTheme.typography.bodySmall,modifier = Modifier.padding(start = 8.dp),text = "Это подход, в котором программа состоит из чистых функций, которые не имеют побочных эффектов. Примеры языков: Haskell, Lisp, Scala.")
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "4.Логическое программирование: ", fontWeight = FontWeight.Bold)
            Text(style = MaterialTheme.typography.bodySmall,modifier = Modifier.padding(start = 8.dp),text = "В логическом программировании задачи решаются с помощью системы логических утверждений. Пример языка: Prolog.")
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "5.Событийно-ориентированное программирование:", fontWeight = FontWeight.Bold)
            Text(style = MaterialTheme.typography.bodySmall,modifier = Modifier.padding(start = 8.dp),text = "Это подход, в котором поток выполнения программы определяется событиями, такими как действия пользователя или сообщения от других программ. Примеры языков: JavaScript, C#.")
        }


    }
}


@Composable
fun Lesson2Practice(
    viewModel: LessonScreenViewModel,
    navController: NavController,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Для этой темы нет заданий, вы можете пройти дальше 😉", textAlign = TextAlign.Center)
        Button(onClick = {
            viewModel.update(LessonDestination.idlesson+1, LessonDestination.idlesson)
            viewModel.progress += 1f
            if(viewModel.progress == 1f) {
                navController.navigate(FinishDestination.route)
            }
        }) {
            Text(text = "Закончить урок")
        }
    }
}