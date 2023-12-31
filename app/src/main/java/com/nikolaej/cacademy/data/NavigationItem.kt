package com.nikolaej.cacademy.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector
import com.nikolaej.cacademy.ui.screen.LessonsDestination
import com.nikolaej.cacademy.ui.screen.ProgressDestination
import com.nikolaej.cacademy.ui.screen.SettingsDestination

data class NavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val badgeCount: Int? = null,
    val nav: String
)


val items = listOf(

    NavigationItem(
        title = "Меню",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        nav = LessonsDestination.route
    ),
    NavigationItem(
        title = "Настройки",
        selectedIcon = Icons.Filled.Settings,
        unselectedIcon = Icons.Outlined.Settings,
        nav = SettingsDestination.route
    ),
    NavigationItem(
        title = "Ваши успехи",
        selectedIcon = Icons.Filled.ThumbUp,
        unselectedIcon = Icons.Outlined.ThumbUp,
        nav = ProgressDestination.route
    )
)

val randomNo = listOf(
    "Подумайте ещё раз",
    "Попробуйте заново",
    "Может есть другое решение?"
)
