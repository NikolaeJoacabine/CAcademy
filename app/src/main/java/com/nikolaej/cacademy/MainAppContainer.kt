package com.nikolaej.cacademy

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.balltrajectory.Parabolic
import com.exyte.animatednavbar.animation.indendshape.Height
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius
import com.exyte.animatednavbar.utils.noRippleClickable
import com.nikolaej.cacademy.ui.AppViewModelProvider
import com.nikolaej.cacademy.ui.CAcademyViewModel
import com.nikolaej.cacademy.ui.screen.FinishDestination
import com.nikolaej.cacademy.ui.screen.FinishScreen
import com.nikolaej.cacademy.ui.screen.LessonDestination
import com.nikolaej.cacademy.ui.screen.LessonScreen
import com.nikolaej.cacademy.ui.screen.LessonScreenCard
import com.nikolaej.cacademy.ui.screen.LessonsDestination
import com.nikolaej.cacademy.ui.screen.ModuleScreen
import com.nikolaej.cacademy.ui.screen.ModuleScreenViewModel
import com.nikolaej.cacademy.ui.screen.ProgressDestination
import com.nikolaej.cacademy.ui.screen.ProgressScreeen
import com.nikolaej.cacademy.ui.screen.SettingsDestination
import com.nikolaej.cacademy.ui.screen.SettingsScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenApp(
    moduleViewModel: ModuleScreenViewModel = viewModel(factory = AppViewModelProvider.Factory),
    gameviewModel: CAcademyViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),
    darkTheme: Boolean,
    onClick: () -> Unit
) {
    val paddingValue = WindowInsets.systemBars.asPaddingValues()


    val module by moduleViewModel.moduleUiState.collectAsState()


    val navBackStackEntry by navController.currentBackStackEntryAsState() //получаем в текстовом виде название страницы
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            //верхняя информационная панель, отсюда вызывается глобальное меню в приложении
            Beautiful_app_bar(
                navBackStackEntry = navBackStackEntry,
                navController = navController,
                gameviewModel = gameviewModel
            )
        },
        //нижняя панель навигации( по курсам и урокам )
        bottomBar = {
            Very_beautiful_control_panel(navController, gameviewModel, paddingValue)
        }
    ) { paddingValues ->

        //навигация по всему приложению
        NavHost(
            navController = navController,
            startDestination = LessonsDestination.route,
            modifier = when (navBackStackEntry?.destination?.route) {
                "Module" -> Modifier.padding(paddingValues)
                "FullLesson" -> Modifier.padding(paddingValues)
                "Settings" -> Modifier.padding(
                    top = paddingValues.calculateTopPadding(),
                    bottom = 0.dp
                )

                "Progress" -> Modifier.padding(paddingValues)
                else -> Modifier.padding(
                    top = paddingValue.calculateTopPadding(),
                    bottom = paddingValue.calculateBottomPadding()
                )
            }


        ) {
            //экран уроков
            composable(
                route = LessonsDestination.route
            ) {
                gameviewModel.bottomBarState = true
                gameviewModel.topBarState = true
                gameviewModel.selectedIndex = 0
                LessonScreenCard(
                    navController = navController,
                    viewModel = gameviewModel
                )
            }
            //экран прогресса
            composable(route = ProgressDestination.route) {
                gameviewModel.bottomBarState = true
                gameviewModel.topBarState = true
                gameviewModel.selectedIndex = 1
                ProgressScreeen()
            }
            //экран настроек
            composable(route = SettingsDestination.route) {
                gameviewModel.bottomBarState = true
                gameviewModel.topBarState = false
                SettingsScreen(darkTheme, onClick)
            }
            composable(route = LessonDestination.route) {
                gameviewModel.bottomBarState = false
                gameviewModel.topBarState = false
                LessonScreen(
                    navController = navController,
                    darkTheme = darkTheme
                )
            }
            composable(route = FinishDestination.route) {
                gameviewModel.bottomBarState = false
                gameviewModel.topBarState = false
                FinishScreen(navController = navController)
            }
        }
    }

    if (gameviewModel.IndexModalBottomSheets) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = { gameviewModel.IndexModalBottomSheets = false }
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "Выберите модуль",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                ModuleScreen(
                    navigateToItemUpdate = {
                        navController.navigate(LessonsDestination.route)
                        coroutineScope.launch {
                            delay(200)
                            sheetState.hide()

                            gameviewModel.IndexModalBottomSheets = false
                        }
                    },
                    moduleViewModel = moduleViewModel,
                    module = module
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Beautiful_app_bar(
    navBackStackEntry: NavBackStackEntry?,
    navController: NavHostController,
    gameviewModel: CAcademyViewModel
) {

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()


    AnimatedVisibility(
        gameviewModel.bottomBarState,
        enter = fadeIn(tween(800)) + slideInVertically(tween(600),
            initialOffsetY = { fullHeight -> -fullHeight }),
        exit = fadeOut(tween(800)) + slideOutVertically(
            tween(600),
            targetOffsetY = { fullHeight -> -fullHeight })
    ) {
        //верхняя панель
        TopAppBar(
            title = {
                if (navBackStackEntry?.destination?.route == "FullLesson") {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Уроки")
                        Spacer(modifier = Modifier.weight(1f))
                        IconButton(
                            onClick = {
                                gameviewModel.IndexModalBottomSheets = true
                            },
                            modifier = Modifier.padding(horizontal = 4.dp)
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Menu, contentDescription = null
                                )
                            }
                        }
                    }
                }
                if (navBackStackEntry?.destination?.route == "Progress") {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Профиль")
                        Spacer(modifier = Modifier.weight(1f))
                        IconButton(
                            onClick = {
                                navController.navigate(SettingsDestination.route)
                            },
                            modifier = Modifier.padding(horizontal = 4.dp)
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Settings, contentDescription = null
                                )
                            }
                        }
                    }
                }
                if (navBackStackEntry?.destination?.route == "Settings") {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Настройки")
                    }
                }
            },
            navigationIcon = {
                if (navBackStackEntry?.destination?.route == "Settings") {
                    IconButton(
                        onClick = {
                            navController.popBackStack(ProgressDestination.route, inclusive = false)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack, contentDescription = null
                        )
                    }
                    Spacer(modifier = Modifier.size(4.dp))
                }
            },
            scrollBehavior = scrollBehavior,
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = colorScheme.secondaryContainer),
            modifier = Modifier.clip(shape = RoundedCornerShape(0.dp, 0.dp, 15.dp, 15.dp)),
        )
    }
}

//анимированная панель в приложении
@Composable
private fun Very_beautiful_control_panel(
    navController: NavHostController,
    gameviewModel: CAcademyViewModel,
    ppp: PaddingValues

) {

    AnimatedVisibility(
        visible = gameviewModel.topBarState,
        enter = fadeIn(tween(800)) + slideInVertically(tween(600),
            initialOffsetY = { fullHeight -> fullHeight }),
        exit = fadeOut(tween(800)) + slideOutVertically(
            tween(600),
            targetOffsetY = { fullHeight -> fullHeight })
    ) {
        AnimatedNavigationBar(
            modifier = Modifier.height(75.dp),
            selectedIndex = gameviewModel.selectedIndex,
            cornerRadius = shapeCornerRadius(30.dp, 30.dp, 0.dp, 0.dp),
            ballAnimation = Parabolic(tween(600)),
            barColor = colorScheme.secondaryContainer,
            ballColor = colorScheme.secondaryContainer,
            indentAnimation = Height(tween(300)),

            ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .noRippleClickable {
                        navController.popBackStack(LessonsDestination.route, inclusive = false)
                    },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Book,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )

            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .noRippleClickable {
                        navController.navigate(ProgressDestination.route)
                    },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    }
}