package com.dlight.algoguide.dsa.sorting.heap_sort

class HeapSort {

    var heapSize = 0

    fun heapSort(arr: Array<Int>) {
        buildMaxHeap(arr)
    }

    private fun buildMaxHeap(arr: Array<Int>) {
        heapSize = arr.size
        for (i in heapSize / 2 downTo 0)
            max_heapify(arr,i)
    }

    private fun max_heapify(arr: Array<Int>, i: Int) {
        var left = left(i)
        var right = right(i)
        var largest: Int

        if ((left <= heapSize - 1) && (arr[left] > arr[right]))
            largest = left
        else
            largest = i
        if ((right <= heapSize - 1) && (arr[right] > arr[left]))
            largest = right
        if (largest != i) {
            swap(arr, i, largest)
            max_heapify(arr, largest)
        }
    }

    private fun swap(arr: Array<Int>, i: Int, largest: Int) {
        var temp = arr[i]
        arr[i] = arr[largest]
        arr[largest] = temp
    }

    private fun right(i: Int): Int {
        return 2 * i + 1
    }

    private fun left(i: Int): Int {
        return 2 * i
    }
}