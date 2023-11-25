package com.nikolaej.cacademy

import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
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
import com.nikolaej.cacademy.ui.CAcademyViewModel
import com.nikolaej.cacademy.ui.screen.LessonScreen
import com.nikolaej.cacademy.ui.screen.LessonScreenCard
import com.nikolaej.cacademy.ui.screen.ModuleScreen
import com.nikolaej.cacademy.ui.screen.ProgressScreeen
import com.nikolaej.cacademy.ui.screen.SettingsScreen
import com.nikolaej.cacademy.ui.theme.CAcademyTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

enum class MainScreen(@StringRes val title: Int) {
    Start(title = R.string.tem),
    Module(title = R.string.module),
    Settings(title = R.string.settings),
    Progress(title = R.string.progress),
    Lesson(title = R.string.lesson)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenApp(
    gameviewModel: CAcademyViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState() //получаем в текстовом виде название страницы
    val currentScreen = MainScreen.valueOf(
        navBackStackEntry?.destination?.route ?: MainScreen.Start.name
    )

    val drawerState =
        rememberDrawerState(initialValue = DrawerValue.Closed) // по умолчанию окно боковой навигации скрыто
    val scope = rememberCoroutineScope()
    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }

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
                            navController.navigate(route = item.nav.toString())
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
            modifier = Modifier.padding(start = 12.dp, top = 0.dp, end = 12.dp, bottom = 12.dp),
            topBar = {
                //верхняя информационная панель, отсюда вызывается глобальное меню в приложении
                beautiful_app_bar(
                    drawerState = drawerState,
                    scope = scope,
                    currentScreenTitle = currentScreen.title,
                    navBackStackEntry = navBackStackEntry,
                    navController = navController
                )
            },
            //нижняя панель навигации( по курсам и урокам )
            bottomBar = {
                AnimatedVisibility(
                    navBackStackEntry?.destination?.route == "Start"
                            || navBackStackEntry?.destination?.route == "Module",
                    enter = fadeIn(tween(800)) + slideInVertically(tween(600),
                        initialOffsetY = { fullHeight -> fullHeight }),
                    exit = fadeOut(tween(800)) + slideOutVertically(
                        tween(600),
                        targetOffsetY = { fullHeight -> fullHeight })
                ) {
                    very_beautiful_control_panel(navController, gameviewModel)
                }
            }
        ) { paddingValues ->


            //навигация по всему приложению
            NavHost(
                navController = navController,
                startDestination = MainScreen.Start.name,
                modifier = Modifier
                    .padding(paddingValues)
            ) {
                //экран уроков
                composable(route = MainScreen.Start.name) {

                    LessonScreenCard(gameviewModel)
                }
                //экран модулей
                composable(route = MainScreen.Module.name) {

                    ModuleScreen(gameviewModel)
                }
                //экран прогресса
                composable(route = MainScreen.Progress.name) {
                    ProgressScreeen()
                }
                //экран настроек
                composable(route = MainScreen.Settings.name) {
                    SettingsScreen()
                }
                composable(route = MainScreen.Lesson.name) {
                    LessonScreen()
                }

            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun beautiful_app_bar(
    drawerState: DrawerState,
    scope: CoroutineScope,
    @StringRes currentScreenTitle: Int,
    navBackStackEntry: NavBackStackEntry?,
    navController: NavHostController
) {

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    //верхняя панель
    TopAppBar(
        title = {
            Text(text = stringResource(currentScreenTitle))
        },
        //что делает кнопка
        navigationIcon = {
            IconButton(onClick = {
                if (navBackStackEntry?.destination?.route == "Start" || navBackStackEntry?.destination?.route == "Module") {
                    scope.launch {
                        drawerState.open()
                    }
                } else {
                    navController.navigateUp()

                }
            }
            ) {
                if (navBackStackEntry?.destination?.route == "Start" || navBackStackEntry?.destination?.route == "Module") {
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
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
        modifier = Modifier.clip(shape = RoundedCornerShape(15.dp)),
    )
}

//анимированная панель в приложении
@Composable
private fun very_beautiful_control_panel(
    navController: NavHostController,
    gameviewModel: CAcademyViewModel
) {
    AnimatedNavigationBar(
        modifier = Modifier.height(70.dp),
        selectedIndex = gameviewModel.selectedIndex,
        cornerRadius = shapeCornerRadius(cornerRadius = 25.dp),
        ballAnimation = Parabolic(tween(600)),
        barColor = MaterialTheme.colorScheme.primary,
        ballColor = MaterialTheme.colorScheme.primary,
        indentAnimation = Height(tween(300)),

        ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .noRippleClickable {
                    navController.popBackStack(MainScreen.Start.name, inclusive = false)
                    gameviewModel.selectedIndex = 0
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.AccountBalance,
                contentDescription = null,
                modifier = Modifier.size(27.dp)
            )

        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .noRippleClickable {
                    navController.navigate(MainScreen.Module.name)
                    gameviewModel.selectedIndex = 1
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Book,
                contentDescription = null,
                modifier = Modifier.size(27.dp)
            )
        }
    }
}





@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CAcademyTheme {
        ScreenApp()
    }
}

