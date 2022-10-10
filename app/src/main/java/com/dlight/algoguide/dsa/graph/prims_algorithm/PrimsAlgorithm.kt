package com.dlight.algoguide.dsa.graph.prims_algorithm

import java.util.LinkedList
import java.util.Arrays
import java.util.Comparator
import java.util.PriorityQueue
import kotlin.jvm.JvmStatic

class Node4 : Comparator<Node4> {
    var dest = 0
    var weight = 0

    constructor() {}
    constructor(d: Int, w: Int) {
        dest = d
        weight = w
    }

    override fun compare(o1: Node4, o2: Node4): Int {
        // TODO Auto-generated method stub
        if (o1.weight > o2.weight) {
            return 1
        }
        return if (o1.weight < o2.weight) {
            -1
        } else 0
    }
}

class PrimsAlgorithm internal constructor(var V: Int) {
    var ll: MutableList<LinkedList<Node4>>
    fun spanningTree(source: Int) {
        val key = IntArray(V)
        Arrays.fill(key, Int.MAX_VALUE)
        val visited = BooleanArray(V)
        Arrays.fill(visited, false)
        val parent = IntArray(V)
        parent[source] = -1
        val pq = PriorityQueue(Node4())
        pq.add(Node4(source, -1))
        while (!pq.isEmpty()) {
            val node = pq.poll()
            visited[node.dest] = true
            for (it in ll[node.dest]) {
                if (!visited[it.dest] && key[it.dest] > it.weight) {
                    pq.add(Node4(it.dest, it.weight))
                    key[it.dest] = it.weight
                    parent[it.dest] = node.dest
                }
            }
        }
        var sum = 0
        for (i in 1 until V) {
            sum += key[i]
            println(parent[i].toString() + " , " + i + " --> " + key[i])
        }
        print("Total weight of minimum spanning tree is : $sum")
    }

    fun addEdge(i: Int, j: Int, w: Int) {
        ll[i].add(Node4(j, w))
        ll[j].add(Node4(i, w))
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // TODO Auto-generated method stub
            val ob = PrimsAlgorithm(6)
            ob.addEdge(0, 1, 1)
            ob.addEdge(0, 2, 2)
            ob.addEdge(1, 2, 3)
            ob.addEdge(1, 4, 7)
            ob.addEdge(2, 4, 5)
            ob.addEdge(2, 3, 3)
            ob.addEdge(4, 5, 6)
            ob.addEdge(4, 3, 2)
            ob.addEdge(3, 5, 4)
            val source = 0
            ob.spanningTree(source)
            //ob.printGraph();
        }
    }

    init {
        ll = mutableListOf(LinkedList<Node4>())
        for (i in 0 until V) {
            ll.add(i, LinkedList<Node4>())
        }
    }
}
