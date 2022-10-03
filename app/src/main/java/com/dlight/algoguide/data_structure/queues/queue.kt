package com.dlight.algoguide.data_structure.queues

const val DEFAULT_CAPACITY = 10

class Queue (size: Int?) {

    private val maxCapacity = size ?: DEFAULT_CAPACITY
    private var itemsCount = 0
    private val queue = IntArray(maxCapacity)
    private var last = -1
    private var first = 0


    fun enqueue(value: Int): Boolean {
        if (isFull()){
            print("queue is full")
            return false
        }

        itemsCount++

        last = (last + 1) % maxCapacity
        queue[last] = value
        return true
    }


    fun dequeue(): Int? {
        if (isEmpty()) {
            print("queue is empty")
            return null
        }

        //println("item removed:" + queue[first])
        val itemToReturn = queue[first]
        first = (first + 1) % maxCapacity

        itemsCount--

        return itemToReturn
    }

    fun printQueue():Boolean{

        println("Elements of queue are:")
        for (i in first..queue.size-1){
            println(queue[i])
        }

        return true
    }


    fun peekFirst(): String = queue[first].toString()

    fun peekLast(): String = queue[last].toString()

    fun getSize(): Int = itemsCount

    private fun isFull(): Boolean = itemsCount == maxCapacity

    private fun isEmpty(): Boolean = itemsCount == 0
}

fun main(){

    //pass the size of the queue
    var q = Queue(4)

    q.enqueue(7)
    q.enqueue(10)
    q.enqueue(50)
    q.enqueue(16)
    print(q.peekFirst())
    q.dequeue()
    q.dequeue()
    q.printQueue()

}
