package com.dlight.algoguide.algorithms.sorting.quick_sort

/**
 * Quick sort
 *
 * @constructor Create empty Quick sort
 */
class QuickSort {
    suspend fun quickSort(
        arr: IntArray, left: Int, right: Int) {
        val index = partition (arr, left, right)
        if (left < index - 1)
            quickSort(arr, left, index - 1)
        if (index < right )
            quickSort(arr, index, right)
    }

    private fun partition(arr: IntArray, left: Int, right: Int): Int {
        var left = left
        var right = right
        /* Pivot point */
        val pivot = arr[(left + right) / 2]
        while (left <= right) {
            while (arr[left] < pivot) left++
            while (arr[right] > pivot) right--
            if (left <= right) {
                swap(arr, left, right)
                left++
                right--
            }
        }
        return left
    }

    private fun swap(arr: IntArray, left: Int, right: Int) {
        val temp = arr [left]
        arr[left] = arr[right]
        arr[right] = temp
    }
}

