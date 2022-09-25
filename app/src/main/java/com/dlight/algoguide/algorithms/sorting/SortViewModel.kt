package com.dlight.algoguide.algorithms.sorting

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dlight.algoguide.algorithms.sorting.insertion_sort.InsertionSort
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SortViewModel(
    private val insertionSort: InsertionSort
) : ViewModel() {

    var arr = mutableStateOf(
        intArrayOf(
            345, 167, 188, 276, 123, 375, 180, 120,240, 37, 173, 156
        )
    )
    val insertionSortingStart = mutableStateOf(false)
    val insertionSortFinish = mutableStateOf(false)
    private var sortDelay = 300L
    private var pause = false
    private var next = 1
    private var previous = 0

    private var insertionSortLevels = mutableListOf<List<Int>>()

    init {
        viewModelScope.launch {
            insertionSort.insertionSort(
                arr.value.clone()
            ) { modifyArray ->
                insertionSortLevels.add(modifyArray.toMutableList())
            }
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
        if (next < insertionSortLevels.size) {
            arr.value = insertionSortLevels[next].toIntArray()
            next++
            previous++
        }
    }

    private fun previouss() {
        if (previous >= 0) {
            arr.value = insertionSortLevels[previous].toIntArray()
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

        if (insertionSortingStart.value)
            pause()
        else
            play()

    }

    private var sortingState = 0
    private fun play() = viewModelScope.launch{

        pause = false
        for (i in sortingState until insertionSortLevels.size) {
            if (!pause) {
                delay(sortDelay)
                arr.value = insertionSortLevels[i].toIntArray()
            } else {
                sortingState = i
                next = i + 1
                previous = i
                return@launch
            }
        }

        insertionSortFinish.value = true
    }

    private fun pause() {
        pause = true
    }

}