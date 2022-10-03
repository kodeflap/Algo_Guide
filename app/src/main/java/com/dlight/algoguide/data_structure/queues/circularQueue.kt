package com.dlight.algoguide.data_structure.queues

import java.util.*;
const val DEFAULT_CAPACITY2 = 10

class CircularQueue (size: Int?) {

    private val maxCapacity = size ?: DEFAULT_CAPACITY2
    private var itemsCount = 0
    private val queue = IntArray(maxCapacity)
    private var last = -1
    private var first = -1


    fun enqueue(value: Int): Boolean {
        if (isFull()){
            print("queue is full")
            return false
        }

        itemsCount++
        if (first == -1){
            first = 0
        }
        last = (last + 1) % maxCapacity
        queue[last] = value
        return true
    }


    fun dequeue(): Int? {
        if (isEmpty()) {
            print("queue is empty")
            return null
        }

        val itemToReturn = queue[first]

        if (first == last) {
            first = -1;
            last = -1;
        }
        else{
            first = (first + 1) % maxCapacity
        }
        println("item deleted:"+ itemToReturn)
        itemsCount--
        return itemToReturn
    }

    fun printQueue():Boolean{

        if (isEmpty()) {
            print("queue is empty")
            return false
        }

        println("Elements of queue are:")
        var x = first
        while(x!=last) {
            println(queue[x])
            x = (x+1) % maxCapacity
        }
        println(queue[x])

        return true
    }


    fun peekFirst(): String = queue[first].toString()

    fun peekLast(): String = queue[last].toString()

    fun getSize(): Int = itemsCount

    private fun isFull(): Boolean{
        if ((first == last + 1) || (first == 0 && last == maxCapacity - 1)){
            return true
        }

        return false
    }

    private fun isEmpty(): Boolean {
        if (first == -1){
            return true
        }
        return false
    }
}

fun main(){

    //pass the size of the queue
    var q = CircularQueue(4)

    q.enqueue(7)
    q.enqueue(10)
    q.enqueue(50)
    q.enqueue(16)
    q.dequeue()
    q.dequeue()
    q.enqueue(1)
    q.enqueue(2)
    q.dequeue()
    q.printQueue()

}