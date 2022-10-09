package com.dlight.algoguide.dsa.sorting.bubble_sort

/**
 * BubbleSort
 *
 * A class carrying functionality to perform bubble sort
 *
 * @constructor Creates an instance of the BublleSort class
 */


class BubbleSort {
    suspend fun bubbleSort(
        arr: IntArray
    ){
        /*Iterating over the whole array */
        while (1 < arr.size) {
            /*Keeping one bool variable and checking if the whole array is sorted or not*/
            var swap = true
            while (swap) {
                /*Intially keeping swap as false */ 
                swap = false
                /*Iterating over the whole array */
                for (i in 0 until arr.size - 1) {
                    /*If the adjcent element is greater then the previous element then perform the 
                    swapping between those 2 numbers */
                    if (arr[i] > arr[i+1]) {
                        /*SWAPING CODE IS THIS */
                        val temp = arr[i]
                        arr[i] = arr[i + 1]
                        arr[i + 1] = temp
                    }
                }
            }
        }
    }
}