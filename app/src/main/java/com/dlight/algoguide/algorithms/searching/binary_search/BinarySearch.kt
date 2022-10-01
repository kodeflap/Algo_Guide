package com.dlight.algoguide.algorithms.searching.binary_search

class BinarySearch {
    // Returns the index of the target value or -1, if the value does not exist in the given array
    suspend fun binarySearch(arr: IntArray, target: Int) : Int {
        // Initially setting l to the start of the array and r to the end of the array
        var l = 0
        var r = arr.size - 1

        while(l <= r) {

            // Calculating the middle index
            val mid = l + (r - l) / 2

            // If the value at the middle index is equal to the target, we return the index
            if (arr[mid] == target)
                return mid
            // If it is greater than the target, then target can't lie on the right half, so we move to the left half
            else if(arr[mid] > target)
                r = mid - 1
            // If it is less than the target, then target can't lie on the left half, so we move to the right half
            else
                l = mid + 1
        }

        // If the target wasn't found in the given array, return -1
        return -1
    }
}