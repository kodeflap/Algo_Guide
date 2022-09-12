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
import com.dlight.algoguide.algorithms.sorting.insertion_sort.AlgoithmViewModelProvider
import com.dlight.algoguide.algorithms.sorting.insertion_sort.Events
import com.dlight.algoguide.algorithms.sorting.insertion_sort.InsertionSort
import com.dlight.algoguide.algorithms.sorting.insertion_sort.InsertionSortViewModel
import com.dlight.algoguide.algorithms.sorting.insertion_sort.composables.Visualizer
import com.dlight.algoguide.algorithms.sorting.insertion_sort.composables.VisualizerSection
import com.dlight.algoguide.ui.theme.AlgoGuideTheme

class MainActivity : ComponentActivity() {

    private val viewModel: InsertionSortViewModel by lazy {
        val viewModelProviderFactory = AlgoithmViewModelProvider(InsertionSort())
        ViewModelProvider(this, viewModelProviderFactory)[
                InsertionSortViewModel::class.java]
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
                            modifier = Modifier.fillMaxWidth()
                        )

                        val isPlaying = viewModel.insertionSortingStart.value
                        val isFinished = viewModel.insertionSortFinish.value

                        Visualizer(
                            playPauseClick = { viewModel.onEvent(Events.playPause) },
                            slowDownClick = { viewModel.onEvent(Events.slowDown) },
                            speedUpClick = { viewModel.onEvent(Events.speedUp) },
                            previousClick = { viewModel.onEvent(Events.previous) },
                            nextClick = { viewModel.onEvent(Events.next) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(70.dp),
                            isPlaying = if (isFinished) !isFinished else isPlaying
                        )
                    }
                }
            }
        }
    }
}
