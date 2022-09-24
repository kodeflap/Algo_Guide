package com.dlight.algoguide.algorithms.sorting.bubble_sort

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dlight.algoguide.algorithms.sorting.Events
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class BubbleSortViewModel(
    private val bubbleSort: BubbleSort
) : ViewModel() {

    var arr = mutableStateOf(
        intArrayOf(
            345, 167, 188, 276, 123, 375, 180, 120,240, 37, 173, 156
        )
    )
    val bubbleSortingStart = mutableStateOf(false)
    val bubbleSortFinish = mutableStateOf(false)
    private var sortDelay = 300L
    private var pause = false
    private var next = 1
    private var previous = 0

    private var bubbleSortLevels = mutableListOf<List<Int>>()

    init {
        viewModelScope.launch {
            bubbleSort.bubbleSort(
                arr.value.clone()
            )
        }
    }


    fun onEvent(event: Events) {
        when (event) {
            is Events.playPause -> {
                playPauseAlgorithm()
            }
            is Events.slowDown -> {
                slowDowns()
            }
            is Events.speedUp -> {
                speedUps()
            }
            is Events.previous -> {
                previouss()
            }
            is Events.next -> {
                nexts()
            }
        }
    }

    private fun nexts() {
        if (next < bubbleSortLevels.size) {
            arr.value = bubbleSortLevels[next].toIntArray()
            next++
            previous++
        }
    }

    private fun previouss() {
        if (previous >= 0) {
            arr.value = bubbleSortLevels[previous].toIntArray()
            next--
            previous--

        }
    }

    private fun speedUps() {
        sortDelay += 100
    }

    private fun slowDowns() {
        if (sortDelay >= 150L) {
            sortDelay -= 50
        }
    }

    private fun playPauseAlgorithm() {

        if (bubbleSortingStart.value)
            pause()
        else
            play()

    }

    private var sortingState = 0
    private fun play() = viewModelScope.launch{

        pause = false
        for (i in sortingState until bubbleSortLevels.size) {
            if (!pause) {
                delay(sortDelay)
                arr.value = bubbleSortLevels[i].toIntArray()
            } else {
                sortingState = i
                next = i + 1
                previous = i
                return@launch
            }
        }

        bubbleSortFinish.value = true
    }

    private fun pause() {
        pause = true
    }

}