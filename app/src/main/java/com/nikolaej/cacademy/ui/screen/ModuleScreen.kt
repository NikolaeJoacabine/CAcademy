package com.nikolaej.cacademy.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.exyte.animatednavbar.utils.noRippleClickable
import com.nikolaej.cacademy.dataSQL.Lesson

@Composable
fun ModuleScreen(
    module: List<Lesson>,
    onModuleClick: (String) -> Unit
) {
    var sosto: String? = ""

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(
            items = module,
            key = { module -> module.id }
        ) { module ->

            if (sosto != module.nameModule) {
                ModuleCard(
                    name = module.nameModule,
                    onModuleClick = onModuleClick
                )
                sosto = module.nameModule
            }
        }
    }
}

@Composable
fun ModuleCard(
    name: String,
    onModuleClick: ((String) -> Unit)? = null
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .clickable(enabled = onModuleClick != null) {
                onModuleClick?.invoke(name)
             }
    ) {
        Text(
            text = name,
            modifier = Modifier.padding(4.dp)
        )
    }
}