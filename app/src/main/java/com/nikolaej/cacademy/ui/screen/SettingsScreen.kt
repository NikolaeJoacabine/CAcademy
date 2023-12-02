package com.nikolaej.cacademy.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun SettingsScreen() {
    cardSettings()

}

@Composable
private fun cardSettings() {
    var hh by remember {
        mutableStateOf(false)
    }

    Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 10.dp)) {
        Row {
            Text(text = "Тёмная тема", Modifier.padding(8.dp))
            Spacer(modifier = Modifier.weight(1f))
            Switch(checked = hh, onCheckedChange = {
                hh = it
            }
            )
        }
    }

}