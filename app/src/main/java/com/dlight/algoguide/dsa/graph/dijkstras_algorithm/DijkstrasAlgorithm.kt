package com.dlight.algoguide.dsa.graph.dijkstras_algorithm

import java.util.*

class Node2 : Comparator<Node2> {
    var edge = 0
        private set
    var weight = 0
        private set

    constructor() {}
    constructor(edge: Int, weight: Int) {
        this.edge = edge
        this.weight = weight
    }

    override fun compare(o1: Node2, o2: Node2): Int {
        if (o1.weight > o2.weight) {
            return 1
        } else if (o1.weight < o2.weight) {
            return -1
        }
        return 0
    }
}

class DijkstrasAlgorithm internal constructor(var V: Int) {
    var ll: MutableList<LinkedList<Node2>>
    fun dijkstraAlgo(source: Int) {
        val arr = IntArray(V)
        Arrays.fill(arr, Int.MAX_VALUE)
        arr[source] = 0
        //Undirected Graph
        val pq = PriorityQueue(V, Node2())
        pq.add(Node2(source, 0))
        //All weights should be positive or else it does not work properly
        while (!pq.isEmpty()) {
            val curr = pq.poll()
            for (it in ll[curr.edge]) {
                if (arr[it.edge] > it.weight + arr[curr.edge]) {
                    arr[it.edge] = it.weight + arr[curr.edge]
                    pq.add(Node2(it.edge, arr[it.edge]))
                }
            }
        }
        for (i in 0 until V) {
            if (arr[i] == Int.MAX_VALUE) {
                print("INF ")
            } else {
                print(arr[i].toString() + " ")
            }
        }
    }

    fun addEdge(i: Int, j: Int, w: Int) {
        ll[i].add(Node2(j, w))
        ll[j].add(Node2(i, w))
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // TODO Auto-generated method stub
            val ob = DijkstrasAlgorithm(6)
            ob.addEdge(0, 1, 5)
            ob.addEdge(1, 2, 2)
            ob.addEdge(3, 4, 5)
            ob.addEdge(3, 2, 6)
            ob.addEdge(2, 4, 3)
            ob.addEdge(5, 3, 1)
            ob.addEdge(1, 5, 3)
            val i = 0
            print("Shortest Path from $i is : ")
            ob.dijkstraAlgo(i)
        }
    }

    init {
        ll = mutableListOf(LinkedList<Node2>())
        for (i in 0 until V) {
            ll.add(i, LinkedList<Node2>())
        }
    }
}
