package com.dlight.algoguide.dsa.sorting.merge_sort
/**
 * Insertion sort
 *
 * @constructor Create empty Insertion sort
 */
class MergeSort {
    suspend fun mergeSort(
        arr: List<Int>
    ): List<Int> {
        /*Function which returns an int array 
        Calculating the mid point 
        left of the array
        and right of the array
         */
        val middle = arr.size / 2
        var left = arr.subList(0, middle)
        var right = arr.subList(middle, arr.size)
    /*Calling merge function recursively to merge the array */
        return merge(mergeSort(left), mergeSort(right))
    }

    private fun merge(left: List<Int>, right: List<Int>): List<Int> {
        var indexLeft = 0
        var indexRight = 0
        var newList: MutableList<Int> = mutableListOf()
        /*Copying the elements of the array into the  new list into
         a sorted form*/
        while (indexLeft < left.count() && indexRight < right.count()) {
            if (left[indexLeft] <= right[indexRight]) {
                newList.add(left[indexLeft])
                indexLeft++
            } else {
                newList.add(right[indexRight])
                indexRight++
            }
        }
        /*If any element left in the array belonging to either right or left side of array then
        insert into the array */
        //THIS THE LEFT SIDE        
        while (indexLeft < left.size) {
            newList.add(left[indexLeft])
            indexLeft++
        }
        //THIS IS THE RIGHT SIDE OF THE ARRAY
        while (indexRight < right.size) {
            newList.add(right[indexRight])
            indexRight++
        }
        return newList
    }
}