package com.nikolaej.cacademy.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
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
    viewModel: LessonViewModel = viewModel()
) {


    val pagerState = rememberPagerState {
        tabItem.size
    }

    val indicator = @Composable { tabPositions: List<TabPosition> ->
        CustomIndicator(tabPositions, pagerState)
    }

    LaunchedEffect(viewModel.selectTabIndex) {
        pagerState.animateScrollToPage(viewModel.selectTabIndex)
    }

    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {

        if (!pagerState.isScrollInProgress) {
            viewModel.selectTabIndex = pagerState.currentPage
        }
    }


    Column(modifier = Modifier.fillMaxSize()) {

        TabRow(
            selectedTabIndex = viewModel.selectTabIndex,
            indicator = indicator,
            divider = {}
            ) {
            tabItem.forEachIndexed { index, title ->
                Tab(
                    selected = index == viewModel.selectTabIndex,
                    onClick = {
                        viewModel.selectTabIndex = index
                    },
                    text = {
                        Text(text = title.name)
                    }
                )
            }
        }

        val progressAnimDuration = 500

        val progressAnimation by animateFloatAsState(
            targetValue = viewModel.progress,
            animationSpec = tween(durationMillis = progressAnimDuration, easing = FastOutSlowInEasing)
        )


        AnimatedVisibility(visible = viewModel.selectTabIndex == 1) {
            LinearProgressIndicator(
                progress = progressAnimation,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            if(true) {
                when (it) {
                    0 -> Lesson1Theory()
                    1 -> Lesson1Practice(viewModel)
                }
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

