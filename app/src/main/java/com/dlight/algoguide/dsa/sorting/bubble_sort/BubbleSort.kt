package com.dlight.algoguide.dsa.sorting.bubble_sort

class BubbleSort {
    suspend fun bubbleSort(
        arr: IntArray
    ){
        while (1 < arr.size) {
            var swap = true
            while (swap) {
                swap = false
                for (i in 0 until arr.size - 1) {
                    if (arr[i] > arr[i+1]) {
                        val temp = arr[i]
                        arr[i] = arr[i + 1]
                        arr[i + 1] = temp
                    }
                }
            }
        }
    }
}