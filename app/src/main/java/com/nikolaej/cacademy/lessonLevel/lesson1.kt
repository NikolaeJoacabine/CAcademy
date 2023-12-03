package com.nikolaej.cacademy.lessonLevel

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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nikolaej.cacademy.R
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
fun Lesson1Practice(viewModel: LessonViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp)
    ) {

        Button(onClick = {
            viewModel.progress += 0.2f
            if (viewModel.progress > 1f) {
                viewModel.progress = 0f
            }
        }) {
            Text(text = "привет")
        }
    }
}


