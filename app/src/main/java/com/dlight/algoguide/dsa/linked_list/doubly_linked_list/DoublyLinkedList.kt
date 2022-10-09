package com.dlight.algoguide.dsa.linked_list.doubly_linked_list

import java.util.*


object Doubly_Linked_List {
    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val list = Linkedlists()
        var flag = true
        var valu: Int
        var posi = 0
        while (flag) {
            println()
            println("1. Add item to the list at start")
            println("2. Add item to the list at last")
            println("3. Add item to the list at position")
            println("4. Delete First node")
            println("5. Delete last node")
            println("6. Delete node at position")
            println("7. Update node at position")
            println("8. Display Backward/Reverse link list")
            println("9. View List")
            println("10. Exit")
            println("Enter Choice")
            val choice: Int = sc.nextInt()
            when (choice) {
                1 -> {
                    println("Enter value")
                    valu = sc.nextInt()
                    list.insertAtFirst(valu)
                }
                2 -> {
                    println("Enter value")
                    valu = sc.nextInt()
                    list.insertAtLast(valu)
                }
                3 -> {
                    println("Enter value")
                    valu = sc.nextInt()
                    println("Enter position")
                    posi = sc.nextInt()
                    list.insertAtPos(valu, posi)
                }
                4 -> list.deleteFirst()
                5 -> list.deleteLast()
                6 -> {
                    println("Enter position")
                    posi = sc.nextInt()
                    list.deleteAtPos(posi)
                }
                7 -> {
                    println("Enter value")
                    valu = sc.nextInt()
                    println("Enter position")
                    posi = sc.nextInt()
                    list.updateData(valu, posi)
                }
                8 -> list.reverseList()
                9 -> list.viewList()
                10 -> flag = false
                else -> println("invalid choice")
            }
        }
    }
}


internal class Linkedlists {
    internal inner class Node {
        var data = 0
        private var next: Node? = null
        private var prev: Node? = null

        fun setNext(n: Node?) {
            next = n
        }

        fun setPrev(n: Node?) {
            prev = n
        }

        fun getNext(): Node {
            return next!!
        }

        fun getPrev(): Node {
            return prev!!
        }
    }

    private var start: Node? = null
    var listSize = 0
        private set
    private var tail: Node? = null

    //reversing link list
    fun reverseList() {
        if (isEmpty) {
            println("Empty List")
            return
        }
        var t = tail
        while (t != null) {
            print(t.data.toString() + "|___|" + "-->")
            t = t.getPrev()
        }
        print("null")
    }

    val isEmpty: Boolean
        get() = if (start == null) true else false

    fun viewList() {
        if (isEmpty) {
            println("Empty List")
            return
        }
        var t = start
        while (t != null) {
            print(t.data.toString() + "|___|" + "-->")
            t = t.getNext()
        }
        print("null")
    }

    fun insertAtFirst(`val`: Int) {
        val n: Node = Node()
        n.data = `val`
        if (isEmpty) tail = n else start!!.setPrev(n)
        n.setNext(start)
        start = n
        listSize++
    }

    fun insertAtLast(`val`: Int) {
        val t = start
        val n: Node = Node()
        n.data = `val`
        if (t == null) start = n //if list is null
        else tail!!.setNext(n)
        n.setPrev(tail)
        tail = n
        listSize++
    }

    fun insertAtPos(`val`: Int, pos: Int) {
        if (start == null) {
            println("Empty list, Try Again")
            return
        }
        var t: Node = start as Node
        val n: Node = Node()
        n.data = `val`
        for (i in 1 until pos - 1) {
            t = t.getNext()
        }
        n.setNext(t.getNext())
        t.getNext().setPrev(n)
        t.setNext(n)
        n.setPrev(t)
        listSize++
    }

    fun updateData(`val`: Int, pos: Int) {
        if (isEmpty || pos > listSize || pos < 1) {
            println("Updation not possible")
            return
        }
        var t = start
        for (i in 1 until pos) {
            t = t!!.getNext()
        }
        t!!.data = `val`
    }

    fun deleteFirst() {
        if (start == null) {
            println("list is empty")
            return
        } else {
            val t: Node = start as Node
            start = start!!.getNext()
            t.setNext(null)
            t.setPrev(null)
            start!!.setPrev(null)
            listSize--
        }
    }

    fun deleteLast() {
        if (start == null) {
            println("list is empty")
            return
        } else {
            val t = tail
            tail = start!!.getPrev()
            t!!.setNext(null)
            t.setPrev(null)
            tail!!.setPrev(null)
            listSize--
        }
    }

    fun deleteAtPos(pos: Int) {
        if (isEmpty || pos > listSize || pos < 1) {
            println("Deletetion not possible")
            return
        } else {
            var t = start
            val t1: Node
            for (i in 1 until pos - 1) {
                t = t!!.getNext()
            }
            t1 = t!!.getNext()
            t.setNext(t1.getNext())
            t1.getNext().setPrev(t)
            t1.setNext(null)
            t1.setPrev(null)
            listSize--
        }
    }
}