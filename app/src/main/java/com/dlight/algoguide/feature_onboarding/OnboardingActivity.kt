package com.dlight.algoguide.feature_onboarding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.dlight.algoguide.composables.onboarding_screen.OnboardingPager
import com.dlight.algoguide.dsa.sorting.Events
import com.dlight.algoguide.dsa.sorting.SortViewModel
import com.dlight.algoguide.dsa.sorting.SortingViewModelProvider
import com.dlight.algoguide.dsa.sorting.composables.VisualizerBottomBar
import com.dlight.algoguide.dsa.sorting.composables.VisualizerSection
import com.dlight.algoguide.dsa.sorting.insertion_sort.InsertionSort
import com.dlight.algoguide.feature_onboarding.data.OnboardingData
import com.dlight.algoguide.ui.theme.AlgoGuideTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

/**
 * Main activity
 *
 * @constructor Create empty Main activity
 */
class OnboardingActivity : ComponentActivity() {


    private val viewModel: SortViewModel by lazy {
        val viewModelProviderFactory = SortingViewModelProvider(InsertionSort())
        ViewModelProvider(this, viewModelProviderFactory)[
                SortViewModel::class.java]
    }

    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlgoGuideTheme {

                //onBoarding screen
                val items = ArrayList<OnboardingData>()
                items.add(
                    OnboardingData(
                        123,
                        "Easy Algo Guides",
                        "We have number of algorithm concepts"
                    )
                )
                items.add(
                    OnboardingData(
                        123,
                        "Easy Algo Guides",
                        "We have number of algorithm concepts"
                    )
                )
                items.add(
                    OnboardingData(
                        123,
                        "Easy Algo Guides",
                        "We have number of algorithm concepts"
                    )
                )

                val pagerState = rememberPagerState(
                    pageCount = items.size,
                    initialOffscreenLimit = 2,
                    infiniteLoop = false,
                    initialPage = 0,
                )

                OnboardingPager(
                    item = items,
                    pagerState = pagerState,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.Black)
                )


                // A surface container using the 'background' color from the theme
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.background),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Column {
                        VisualizerSection(
                            arr = viewModel.arr.value,
                            modifier = Modifier
                        )

                        val isPlaying = viewModel.sortingStart.value
                        val isFinished = viewModel.sortFinish.value

                        VisualizerBottomBar(
                            playPauseClick = { viewModel.onEvent(Events.playPause) },
                            slowDownClick = { viewModel.onEvent(Events.slowDown) },
                            speedUpClick = { viewModel.onEvent(Events.speedUp) },
                            previousClick = { viewModel.onEvent(Events.previous) },
                            nextClick = { viewModel.onEvent(Events.next) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(75.dp),
                            isPlaying = if (isFinished) !isFinished else isPlaying
                        )
                    }
                }
            }
        }
    }
}
