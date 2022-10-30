package com.dlight.algoguide.dsa.sorting.shell_sort

/**
 * Shell Sort
 *
 * A class carrying functionality to perform shell sort
 *
 * @constructor Creates an instance of the ShellSort class
 *
 * 1. Main idea of shell sort is comparing distant elements
 * 2. Efficiency of shell sort depends upon the gap {Better the gap sequence less time taken to sort the array}
 *
 * Time Complexity : O(n^2)
 * Space Complexity : O(1)
 * */

class ShellSort {
    suspend fun shellSort(
        arr: IntArray
    ) {
        val n = arr.size

        /* Distance between two distant element is called interval / gap */
        var interval = n / 2
        while (interval > 0) {
            /* First Sort the gap element from range [0..gap - 1] */
            var i = interval
            while (i < n) {

                val temp = arr[i]
                var j = i
                /* Shift earlier gap-sorted elements up until the correct location for a[i] is found */
                while (j >= interval && arr[j - interval] > temp) {
                    arr[j] = arr[j - interval]
                    j -= interval
                }
                /* insert temp(arr[i]) in it's correct position */
                arr[j] = temp
                i += 1
            }
            /* Reduce the gap with each iteration */
            interval /= 2
        }
    }
}
