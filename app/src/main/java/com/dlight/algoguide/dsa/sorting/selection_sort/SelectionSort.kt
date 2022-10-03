package com.dlight.algoguide.dsa.sorting.selection_sort

/**
 * Selection sort
 *
 * @constructor Create empty Selection sort
 */

class SelectionSort {
    suspend fun selectionSort(
        arr: IntArray,
    ) {
        for (i in 1 until arr.size) {
            var min = i
            for (j in (i + 1) until arr.size) {
                if (arr[j] < arr[min])
                    min = j
            }

            sortSwap(arr, min, i)
        }
    }

    private fun sortSwap(arr: IntArray, min: Int, i: Int) {

        val temp = arr[min]
        arr[min] = arr[i]
        arr[i] = temp
    }
}