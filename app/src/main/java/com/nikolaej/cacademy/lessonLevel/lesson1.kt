package com.nikolaej.cacademy.lessonLevel

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nikolaej.cacademy.R
import com.nikolaej.cacademy.ui.theme.CAcademyTheme

@Composable
fun Lesson1Theory() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Text(text = stringResource(R.string.Lesson1Theory1), fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.size(4.dp))


            Text(text = stringResource(R.string.Lesson1Theory2))
            Spacer(modifier = Modifier.size(8.dp))


            Text(text = stringResource(R.string.Lesson1Theory3), fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.size(4.dp))


            Text(text = stringResource(R.string.Lesson1Theory4))
            Spacer(modifier = Modifier.size(8.dp))


            Text(text = stringResource(R.string.Lesson1Theory5), fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.size(4.dp))


            Text(text = stringResource(R.string.Lesson1Theory6))
            Spacer(modifier = Modifier.size(8.dp))


            Text(text = stringResource(R.string.Lesson1Theory7), fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.size(4.dp))


            Text(text = stringResource(R.string.Lesson1Theory8))
            Spacer(modifier = Modifier.size(8.dp))
        }
    }
}

@Composable
fun Lesson1Practice() {
    
}

@Preview
@Composable
fun prev () {
    CAcademyTheme {
        Lesson1Theory()
    }
}