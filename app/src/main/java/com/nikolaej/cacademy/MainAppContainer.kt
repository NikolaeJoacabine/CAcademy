package com.nikolaej.cacademy

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.nikolaej.cacademy.data.items
import com.nikolaej.cacademy.ui.AppViewModelProvider
import com.nikolaej.cacademy.ui.CAcademyViewModel
import com.nikolaej.cacademy.ui.screen.FinishDestination
import com.nikolaej.cacademy.ui.screen.FinishScreen
import com.nikolaej.cacademy.ui.screen.LessonDestination
import com.nikolaej.cacademy.ui.screen.LessonScreen
import com.nikolaej.cacademy.ui.screen.LessonScreenCard
import com.nikolaej.cacademy.ui.screen.LessonsDestination
import com.nikolaej.cacademy.ui.screen.LessonsScreenViewModel
import com.nikolaej.cacademy.ui.screen.ModuleDestination
import com.nikolaej.cacademy.ui.screen.ModuleScreen
import com.nikolaej.cacademy.ui.screen.ProgressDestination
import com.nikolaej.cacademy.ui.screen.ProgressScreeen
import com.nikolaej.cacademy.ui.screen.SettingsDestination
import com.nikolaej.cacademy.ui.screen.SettingsScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun ScreenApp(
    gameviewModel: CAcademyViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),
    darkTheme: Boolean,
    onClick: () -> Unit
) {
    val paddingValue = WindowInsets.systemBars.asPaddingValues()

    val navBackStackEntry by navController.currentBackStackEntryAsState() //получаем в текстовом виде название страницы


    val drawerState =
        rememberDrawerState(initialValue = DrawerValue.Closed) // по умолчанию окно боковой навигации скрыто
    val scope = rememberCoroutineScope()
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }

    //боковое меню навигации в самом приложении
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Spacer(modifier = Modifier.size(15.dp))
                IconButton(
                    modifier = Modifier.padding(start = 12.dp),
                    onClick = {
                        scope.launch {
                            drawerState.close()
                        }
                    }
                ) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                }
                Spacer(modifier = Modifier.height(10.dp))
                items.forEachIndexed { index, item ->
                    NavigationDrawerItem(
                        label = {
                            Text(text = item.title)
                        },
                        selected = index == selectedItemIndex,

                        onClick = {
                            navController.navigate(route = item.nav)
                            selectedItemIndex =
                                if (navBackStackEntry?.destination?.route == "Start" || navBackStackEntry?.destination?.route == "Module") {
                                    0
                                } else {
                                    index
                                }
                            scope.launch {
                                drawerState.close()
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = if (index == selectedItemIndex) {
                                    item.selectedIcon
                                } else item.unselectedIcon, contentDescription = item.title
                            )
                        },
                        badge = {
                            item.badgeCount?.let {
                                Text(text = item.badgeCount.toString())
                            }
                        }, modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                }
            }
        },
        drawerState = drawerState,
        gesturesEnabled = false
    ) {
        Scaffold(
            topBar = {
                //верхняя информационная панель, отсюда вызывается глобальное меню в приложении
                Beautiful_app_bar(
                    drawerState = drawerState,
                    scope = scope,
                    currentScreenTitle = when (navBackStackEntry?.destination?.route) {
                        "FullLesson" -> "Уроки"
                        "Module" -> "Модули"
                        "Settings" -> "Настройки"
                        "Progress" -> "Прогресс"
                        else -> ""
                    },
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
                startDestination = ModuleDestination.route,
                modifier = when (navBackStackEntry?.destination?.route) {
                    "Module" -> Modifier.padding(paddingValues)
                    "FullLesson" -> Modifier.padding(paddingValues)
                    "Settings" -> Modifier.padding(
                        top = paddingValues.calculateTopPadding(),
                        bottom = 0.dp
                    )

                    "Progress" -> Modifier.padding(
                        top = paddingValues.calculateTopPadding(),
                        bottom = 0.dp
                    )

                    else -> Modifier.padding(
                        top = paddingValue.calculateTopPadding(),
                        bottom = paddingValue.calculateBottomPadding()
                    )
                }


            ) {
                //экран модулей
                composable(route = ModuleDestination.route) {
                    gameviewModel.bottomBarState = true
                    gameviewModel.topBarState = true
                    gameviewModel.selectedIndex = 0
                    ModuleScreen(
                        navigateToItemUpdate = {
                            navController.navigate(LessonsDestination.route)
                        }
                    )
                }

                //экран уроков

                composable(
                    route = LessonsDestination.route
                ) {
                    gameviewModel.bottomBarState = true
                    gameviewModel.topBarState = true
                    gameviewModel.selectedIndex = 1
                    LessonScreenCard(
                        navController = navController,
                        viewModel = gameviewModel
                    )
                }
                //экран прогресса
                composable(route = ProgressDestination.route) {
                    gameviewModel.bottomBarState = true
                    gameviewModel.topBarState = false
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
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Beautiful_app_bar(
    drawerState: DrawerState,
    scope: CoroutineScope,
    currentScreenTitle: String,
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
                Text(text = currentScreenTitle)
            },
            //что делает кнопка
            navigationIcon = {
                IconButton(onClick = {
                    if (navBackStackEntry?.destination?.route == "FullLesson" || navBackStackEntry?.destination?.route == "Module") {
                        scope.launch {
                            drawerState.open()
                        }
                    } else {
                        navController.popBackStack(ModuleDestination.route, inclusive = false)

                    }
                }
                ) {
                    if (navBackStackEntry?.destination?.route == "FullLesson" || navBackStackEntry?.destination?.route == "Module") {
                        Icon(
                            imageVector = Icons.Default.Menu, contentDescription = null
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Default.ArrowBack, contentDescription = null
                        )
                    }

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
            modifier = Modifier.height(75.dp + ppp.calculateBottomPadding()),
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
                        if (gameviewModel.selectedIndex != 0) {
                            navController.popBackStack(ModuleDestination.route, inclusive = false)
                        }
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
                        if (gameviewModel.selectedIndex != 1) {
                            navController.navigate(LessonsDestination.route)
                        }
                    },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.AccountBalance,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    }
}



