package com.dlight.algoguide.dsa.sorting.insertion_sort

/**
 * Insertion sort
 *
 * @constructor Create empty Insertion sort
 */
class InsertionSort {
    suspend fun insertionSort(
        arr: IntArray,
        swap: (IntArray) -> Unit
    ) {
        for (i in 1 until arr.size)
        {
            val key = arr[i - 1]
            var j = i - 1
            while (j >= 0 && key < arr[j]) {
                arr [j + 1] = arr[j]
                swap(arr)
                j--
            }
            arr[j + 1] = key
            swap(arr)
        }
    }
}