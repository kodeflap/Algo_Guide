package com.dlight.algoguide.algorithms.sorting.insertion_sort

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Algorithm view model provider
 *
 * @property insertionSort
 * @constructor Create empty Algorithm view model provider
 */
class AlgorithmViewModelProvider(
    private var insertionSort: InsertionSort
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return InsertionSortViewModel(insertionSort) as T
    }

}