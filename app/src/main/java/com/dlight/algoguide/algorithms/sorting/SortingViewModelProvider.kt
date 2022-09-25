package com.dlight.algoguide.algorithms.sorting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dlight.algoguide.algorithms.sorting.insertion_sort.InsertionSort

/**
 * Algorithm view model provider
 *
 * @property insertionSort
 * @constructor Create empty Algorithm view model provider
 */
class SortingViewModelProvider(
    private var insertionSort: InsertionSort
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SortViewModel(insertionSort) as T
    }

}