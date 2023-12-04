package com.nikolaej.cacademy.ui.screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.nikolaej.cacademy.ui.MainScreen

@Composable
fun FinishScreen(navController: NavController) {

    BackHandler {
        navController.popBackStack(MainScreen.Start.name, inclusive = false)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.LocalFireDepartment,
            contentDescription = null,
            modifier = Modifier.size(80.dp)
        )
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = "Вы справились со всеми заданиями👌", fontSize = 15.sp)
        Spacer(modifier = Modifier.size(10.dp))
        Button(onClick = { navController.popBackStack(MainScreen.Start.name, inclusive = false) }) {
            Text(text = "Вернуться к урокам")
        }
    }
}

@Preview
@Composable
fun fff() {
    FinishScreen(navController = rememberNavController())
}