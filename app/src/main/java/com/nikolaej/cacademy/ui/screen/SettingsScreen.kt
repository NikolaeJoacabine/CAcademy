package com.nikolaej.cacademy.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.unit.dp
import com.nikolaej.cacademy.ui.navigation.NavigationDestination

object SettingsDestination: NavigationDestination{
    override val route = "Settings"
}
@Composable
fun SettingsScreen(
    darkTheme: Boolean,
    onClick: () -> Unit
) {
    val haptic = LocalHapticFeedback.current
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Тёмная тема")
            Spacer(modifier = Modifier.weight(1f))
            Switch(checked = darkTheme, onCheckedChange = {
                onClick()
                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
            })
        }
        Row(

        ){
            
        }
    }
}


