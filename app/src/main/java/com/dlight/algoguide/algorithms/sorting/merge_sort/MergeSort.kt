package com.dlight.algoguide.algorithms.sorting.merge_sort

class MergeSort {
    suspend fun mergeSort(
        arr: List<Int>
    ): List<Int> {
        val middle = arr.size / 2
        var left = arr.subList(0, middle)
        var right = arr.subList(middle, arr.size)

        return merge(mergeSort(left), mergeSort(right))
    }

    private fun merge(left: List<Int>, right: List<Int>): List<Int> {
        var indexLeft = 0
        var indexRight = 0
        var newList: MutableList<Int> = mutableListOf()

        while (indexLeft < left.count() && indexRight < right.count()) {
            if (left[indexLeft] <= right[indexRight]) {
                newList.add(left[indexLeft])
                indexLeft++
            } else {
                newList.add(right[indexRight])
                indexRight++
            }
        }

        while (indexLeft < left.size) {
            newList.add(left[indexLeft])
            indexLeft++
        }

        while (indexRight < right.size) {
            newList.add(right[indexRight])
            indexRight++
        }

        return newList
    }
}