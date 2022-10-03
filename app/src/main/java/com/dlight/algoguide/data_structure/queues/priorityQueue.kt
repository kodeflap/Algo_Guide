package com.dlight.algoguide.data_structure.queues

var size:Int =0

class PriorityQueue(){

    // Function to heapify the tree
    fun heapify(array: IntArray , size:Int, i:Int):Boolean {
        if (size == 1) {
            println("Single element in the heap")
        }
        else {
            // Find the largest among root, left child and right child
            var largest = i
            var l = 2 * i + 1
            var r = 2 * i + 2
            if (l < size && array[l] > array[largest]){
                largest = l
            }
            if (r < size && array[r] > array[largest]){
                largest = r
            }

            // Swap and continue heapifying if root is not largest
            if (largest != i) {
                array[i] = array[largest].also { array[largest] = array[i] }
                heapify(array, size, largest)
            }
        }
        return true
    }

    // Function to insert an element into the tree
    fun insert(array: IntArray,newNum: Int): Boolean {
        if (size == 0) {
            array[0] = newNum
            size += 1
        }
        else {
            array[size] = newNum;
            size += 1
            var x = size /2-1
            while(x >= 0){
                heapify(array, size, x)
                x -= 1
            }
        }

        return true
    }

    // Function to delete an element from the tree
    fun deleteRoot(array: IntArray,num: Int):Boolean {
        var y:Int = 0
        while(y< size){
            if (num == array[y])
                break
            y += 1
        }

        array[y] = array[size - 1].also { array[size - 1] = array[y] }

        size -= 1;

        y= size /2-1
        while(y>=0){
            heapify(array, size, y);
            y -= 1
        }
        return true
    }

    // Print the array
    fun printArray(array: IntArray,size:Int):Boolean {

        var z=0
        while(z < size){
            println(array[z])
            z += 1
        }
        return true
    }

}

fun main(){

    var p = PriorityQueue()
    val array = IntArray(10)

    p.insert(array, 3)
    p.insert(array, 3)
    p.insert(array, 4)
    p.insert(array, 9)
    p.insert(array, 5)
    p.insert(array, 2)

    println("Max-Heap array: ")
    p.printArray(array, size)

    p.deleteRoot(array, 4)

    println("After deleting an element: ")

    p.printArray(array, size)
}