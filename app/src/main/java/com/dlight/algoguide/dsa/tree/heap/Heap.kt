package com.dlight.algoguide.dsa.tree.heap

import java.util.*

object MinHeap {
    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        print("Enter the Heap Capacity: ")
        val hCap: Int = sc.nextInt()
        val hp = Min_Heap(hCap)
        var flag = true
        var `val` = 0
        while (flag) {
            println()
            println("0. Exit")
            println("1 - Insert an Element")
            println("2 - Display the Heap")
            println("3 - Height of the Heap")
            println("4 - Current Heap Size")
            println("5 - minExtract()")
            println("6 - Delete Key")
            println("7 - Heap Sort")
            print("Enter Your Choice: ")
            val ch: Int = sc.nextInt()
            when (ch) {
                0 -> flag = false
                1 -> {
                    print("Enter Value to be Inserted: ")
                    `val` = sc.nextInt()
                    hp.insert(`val`)
                }
                2 -> hp.display()
                3 -> println(
                    "Height of Heap Tree = " + (Math.ceil(
                        Math.log((hp.hSize + 1).toDouble()) / Math.log(
                            2.0
                        )
                    ).toInt() - 1)
                )
                4 -> println("The Size of the Heap is = " + hp.hSize)
                5 -> println(hp.minExtract())
                6 -> {
                    print("Enter Key to be Deleted: ")
                    `val` = sc.nextInt()
                    hp.minDeleteKey(`val`)
                }
                7 -> {
                    hp.hSize = hp.hCap
                    println("Enter Elements of Unsorted Array:")
                    var i = 0
                    while (i < hp.hCap) {
                        hp.hArr[i] = sc.nextInt()
                        i++
                    }
                    hp.heapSort(hp.hArr)
                }
                else -> println("Invalid Choice")
            }
        }
    }
}

internal class Min_Heap(var hCap: Int) {
    var hArr: IntArray
    var hSize = 0

    init {
        hArr = IntArray(hCap)
    }

    fun parent(i: Int): Int {
        return (i - 1) / 2
    }

    fun left(i: Int): Int {
        return 2 * i + 1
    }

    fun right(i: Int): Int {
        return 2 * i + 2
    }

    fun swap(currI: Int, swI: Int) { // currentIndex, swapIndex
        val temp = hArr[currI]
        hArr[currI] = hArr[swI]
        hArr[swI] = temp
    }

    // START 1 - Insert an Element
    fun insert(`val`: Int) {
        if (hSize == hCap) {
            println("Heap Overflow")
            return
        }
        println("Value Inserted in Heap")
        hSize++
        var i = hSize - 1
        hArr[i] = `val`

        // if the new inserted node is less than its parent then swap them
        while (i != 0 && hArr[i] < hArr[parent(i)]) {
            swap(i, parent(i))
            i = parent(i)
        }
    }

    // END 1 - Insert an Element
    // START 2 - Display the Heap
    fun display() {
        for (i in 0 until hSize) print(hArr[i].toString() + " ")
    }

    // END 2 - Display the Heap
    // START 5 - minExtract()
    fun minExtract(): Int {
        if (hSize <= 0) {
            println("Empty heap")
            return -99999
        }
        if (hSize == 1) {
            hSize--
            return hArr[0]
        }
        val root = hArr[0]
        hArr[0] = hArr[hSize - 1]
        hSize--
        minHeapify(0)
        return root
    }

    fun minHeapify(i: Int) {
        val l = left(i)
        val r = right(i)
        var smallest = i
        if (l < hSize && hArr[l] < hArr[smallest]) smallest = l
        if (r < hSize && hArr[r] < hArr[smallest]) smallest = r
        if (smallest != i) {
            swap(i, smallest)
            minHeapify(smallest)
        }
    }

    // END 5 - minExtract()
    // START 6 - Delete Key
    fun minDeleteKey(i: Int) {
        if (i >= hSize) {
            println("Enter valid key")
            return
        }
        decreaseKey(i, Int.MIN_VALUE)
        minExtract()
        println("Value Deleted")
    }

    // this () will set the value in deletingIndex with minimum value than will keep
    // on swapping that deletingIndex value with its parents until it reaches root
    // then minExtract() will be called to remove the root(which is
    // Integer.MIN_VALUE) and heapify
    fun decreaseKey(i: Int, minVal: Int) {
        var i = i
        hArr[i] = minVal
        while (i != 0 && hArr[i] < hArr[parent(i)]) {
            swap(i, parent(i))
            i = parent(i)
        }
    }

    // END 6 - Delete Key
    // START 7 - Heap Sort
    fun heapSort(unsortedArr: IntArray) {
        System.out.println(
            """
                
                Unsorted Array = ${Arrays.toString(unsortedArr)}
                """.trimIndent()
        )

        // this will convert array into a min-heap array from bottom to top
        for (i in unsortedArr.size / 2 - 1 downTo 0) {
            minHeapify(i)
        }

        // actual heap sort starts
        val sortedArr = IntArray(unsortedArr.size)
        for (i in sortedArr.indices) {
            sortedArr[i] = minExtract()
        }
        System.out.println("Sorted Array = " + Arrays.toString(sortedArr))
    } // END 7 - Heap Sort
}