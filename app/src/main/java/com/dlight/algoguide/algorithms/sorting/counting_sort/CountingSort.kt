package com.dlight.algoguide.algorithms.sorting.counting_sort

class CountingSort{
    fun countingSort(A: Array<Int>, max: Int) {
        // Array in which result will store
        var b = Array(A.size) { 0 }
        // count array
        var c = Array(max) { 0 }
        for (i in A.indices) {
            //count the no. of occurrence of a
            //particular element store in count array
            c[A[i] - 1] = c[A[i] - 1] + 1
        }
        for (i in 1 until c.size) {
            // calculate commutative sum
            c[i] = c[i] + c[i - 1]
        }
        for (i in A.size - 1 downTo 0) {
            // place the element at its position
            b[c[A[i] - 1] - 1] = A[i]
            // decrease the occurrence of the element by 1
            c[A[i] - 1] = c[A[i] - 1] - 1
        }
        println("After sorting :")
        for (i in b) {
            print("$i ")
        }

    }
}

