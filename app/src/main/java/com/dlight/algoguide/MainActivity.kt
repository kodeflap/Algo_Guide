package com.dlight.algoguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.dlight.algoguide.algorithms.sorting.SortingViewModelProvider
import com.dlight.algoguide.algorithms.sorting.Events
import com.dlight.algoguide.algorithms.sorting.insertion_sort.InsertionSort
import com.dlight.algoguide.algorithms.sorting.SortViewModel
import com.dlight.algoguide.algorithms.sorting.composables.VisualizerBottomBar
import com.dlight.algoguide.algorithms.sorting.composables.VisualizerSection
import com.dlight.algoguide.ui.theme.AlgoGuideTheme

/**
 * Main activity
 *
 * @constructor Create empty Main activity
 */
class MainActivity : ComponentActivity() {

    private val viewModel: SortViewModel by lazy {
        val viewModelProviderFactory = SortingViewModelProvider(InsertionSort())
        ViewModelProvider(this, viewModelProviderFactory)[
                SortViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlgoGuideTheme {
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
