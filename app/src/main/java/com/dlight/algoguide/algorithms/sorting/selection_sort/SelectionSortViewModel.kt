package com.dlight.algoguide.algorithms.sorting.selection_sort

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dlight.algoguide.algorithms.sorting.Events
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SelectionSortViewModel (
    private val selectionSort: SelectionSort
) : ViewModel() {

    var arr = mutableStateOf(
        intArrayOf(
            345, 167, 188, 276, 123, 375, 180, 120,240, 37, 173, 156
        )
    )
    val selectionSortStart = mutableStateOf(false)
    val selectionSortFinish = mutableStateOf(false)
    private var sortDelay = 300L
    private var pause = false
    private var next = 1
    private var previous = 0

    private var selectionSortLevels = mutableListOf<List<Int>>()

    init {
        viewModelScope.launch {
            selectionSort.selectionSort(
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
        if (next < selectionSortLevels.size) {
            arr.value = selectionSortLevels[next].toIntArray()
            next++
            previous++
        }
    }

    private fun previouss() {
        if (previous >= 0) {
            arr.value = selectionSortLevels[previous].toIntArray()
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

        if (selectionSortStart.value)
            pause()
        else
            play()

    }

    private var sortingState = 0
    private fun play() = viewModelScope.launch{

        pause = false
        for (i in sortingState until selectionSortLevels.size) {
            if (!pause) {
                delay(sortDelay)
                arr.value = selectionSortLevels[i].toIntArray()
            } else {
                sortingState = i
                next = i + 1
                previous = i
                return@launch
            }
        }

        selectionSortFinish.value = true
    }

    private fun pause() {
        pause = true
    }

}