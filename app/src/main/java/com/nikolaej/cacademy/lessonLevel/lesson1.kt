package com.nikolaej.cacademy.lessonLevel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nikolaej.cacademy.R
import com.nikolaej.cacademy.ui.MainScreen
import com.nikolaej.cacademy.ui.screen.LessonViewModel

@Composable
fun Lesson1Theory() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp)
    ) {
        item {
            Text(
                text = stringResource(R.string.Lesson1Theory1),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge
            )



            Text(
                text = stringResource(R.string.Lesson1Theory2),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 8.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))


            Text(text = stringResource(R.string.Lesson1Theory3), fontWeight = FontWeight.Bold)



            Text(
                text = stringResource(R.string.Lesson1Theory4),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 8.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))


            Text(text = stringResource(R.string.Lesson1Theory5), fontWeight = FontWeight.Bold)



            Text(
                text = stringResource(R.string.Lesson1Theory6),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 8.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))


            Text(text = stringResource(R.string.Lesson1Theory7), fontWeight = FontWeight.Bold)



            Text(
                text = stringResource(R.string.Lesson1Theory8),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 8.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))
        }
    }
}

@Composable
fun Lesson1Practice(viewModel: LessonViewModel, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Для этой темы нет заданий, вы можете пройти дальше 😉")
        Button(onClick = {
            viewModel.progress += 1f
            if(viewModel.progress == 1f) {
                navController.navigate(MainScreen.Finish.name)
            }
        }) {
            Text(text = "Закончить урок")
        }
    }
}


