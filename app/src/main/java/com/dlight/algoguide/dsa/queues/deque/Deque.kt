package com.dlight.algoguide.dsa.queues
import java.util.Deque
import java.util.LinkedList

//over here we'll be using built-in func to perform deque operations
fun main() {

    val studentQueue: Deque<String> = LinkedList<String>(mutableListOf("Agni", "Bob", "Chris", "David", "Emily"))

    //adds at the end of the queue
    studentQueue.add("Felix")

    //adds at the start of the queue
    studentQueue.addFirst("Afra")

    //adds at the end of the queue
    studentQueue.addLast("Geek")

    //prints the queue
    println("queue:" +studentQueue)

    //removes element at the first
    val removeFirst = studentQueue.removeFirst()
    println("elem removed:" +removeFirst)

    //removes element at the end
    val removeLast = studentQueue.removeLast()
    println("elem removed:" +removeLast)

    //to get the element
    val res = studentQueue.peek()
    println(res + " : " +studentQueue)
}