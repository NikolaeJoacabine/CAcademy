package com.nikolaej.cacademy.ui.screen

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.google.accompanist.pager.*
import com.nikolaej.cacademy.lessonLevel.Lesson1Practice
import com.nikolaej.cacademy.lessonLevel.Lesson1Theory


data class TabItem(
    val name: String
)

val tabItem = listOf(
    TabItem("Теория"),
    TabItem("Задания")
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LessonScreen(

) {
    var selectTabIndex by remember {
        mutableIntStateOf(0)
    }

    val pagerState = rememberPagerState {
        tabItem.size
    }

    val indicator = @Composable { tabPositions: List<TabPosition> ->
        CustomIndicator(tabPositions, pagerState)
    }

    LaunchedEffect(selectTabIndex) {
        pagerState.animateScrollToPage(selectTabIndex)
    }

    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {

        if (!pagerState.isScrollInProgress) {
            selectTabIndex = pagerState.currentPage
        }
    }


    Column(modifier = Modifier.fillMaxSize()) {

        TabRow(
            selectedTabIndex = selectTabIndex,
            indicator = indicator,
            divider = {}
            ) {
            tabItem.forEachIndexed { index, title ->
                Tab(
                    selected = index == selectTabIndex,
                    onClick = {
                        selectTabIndex = index
                    },
                    text = {
                        Text(text = title.name)
                    }
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {

            when(it){
                0 -> Lesson1Theory()
                1 -> Lesson1Practice()
            }

        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun CustomIndicator(tabPositions: List<TabPosition>, pagerState: PagerState) {
    val transition = updateTransition(pagerState.currentPage)
    val indicatorStart by transition.animateDp(
        transitionSpec = {
            if (initialState < targetState) {
                spring(dampingRatio = 1f, stiffness = 50f)
            } else {
                spring(dampingRatio = 1f, stiffness = 1000f)
            }
        }, label = ""
    ) {
        tabPositions[it].left
    }

    val indicatorEnd by transition.animateDp(
        transitionSpec = {
            if (initialState < targetState) {
                spring(dampingRatio = 1f, stiffness = 1000f)
            } else {
                spring(dampingRatio = 1f, stiffness = 50f)
            }
        }, label = ""
    ) {
        tabPositions[it].right
    }

    Box(
        Modifier
            .offset(x = indicatorStart)
            .wrapContentSize(align = Alignment.BottomStart)
            .width(indicatorEnd - indicatorStart)
            .padding(2.dp)
            .fillMaxSize()
            .border(
                BorderStroke(2.dp, MaterialTheme.colorScheme.secondaryContainer),
                RoundedCornerShape(50)
            )
            .zIndex(1f)
    )
}

