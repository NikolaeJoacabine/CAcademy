package com.nikolaej.cacademy.tipsTasck

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.nikolaej.cacademy.ui.theme.intov_dark
import com.nikolaej.cacademy.ui.theme.intov_light
import com.nikolaej.cacademy.ui.theme.string_dark
import com.nikolaej.cacademy.ui.theme.string_light

@Composable
fun include(darkTheme:Boolean){
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
}

@Composable
fun Cmain(darkTheme: Boolean){
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
}