package com.dlight.algoguide.dsa.sorting.quick_sort

/**
 * Quick sort
 *
 * @constructor Create empty Quick sort
 */
class QuickSort {
    suspend fun quickSort(
        arr: IntArray, left: Int, right: Int) {
            /*First finding the partioning index using thepartion function */
        val index = partition (arr, left, right)
        if (left < index - 1)
        /*checking for better position left or right then performing thr sort*/
            quickSort(arr, left, index - 1)
        if (index < right )
            quickSort(arr, index, right)
    }
     /* This function takes last element as pivot, places
       the pivot element at its correct position in sorted
       array, and places all smaller (smaller than pivot)
       to left of pivot and all greater elements to right
       of pivot */ 
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
    /*Swap function that helps in swaping the numbers */
    private fun swap(arr: IntArray, left: Int, right: Int) {
        val temp = arr [left]
        arr[left] = arr[right]
        arr[right] = temp
    }
}

