package com.dlight.algoguide.dsa.graph.breadth_first_search

import java.util.LinkedList
import java.util.Queue

/**
 * BreadthFirstSearch
 *
 * A class carrying functionality to perform breadth first search
 *
 * @constructor Creates an instance of the BreadthFirstSearch class
 */
class BreadthFirstSearch {
    /**
     * Function to perform breadth first search
     * @param adj Adjacency list of the graph
     * @param target Value to be searched in the given graph
     * @return true if the target value is found otherwise false
     */
    fun breadthFirstSearch(adj : List<List<Int>>, target: Int): Boolean {

        // Array depicting whether a node is visited
        val visited = BooleanArray(adj.size) { false }

        // Queue to carry out breadth first search
        val queue: Queue<Int> = LinkedList()

        // Adding the first node 0 to queue and marking it as visited
        queue.add(0)
        visited[0] = true

        // Carrying out the search until the queue is empty
        while (queue.isNotEmpty()) {

            // Getting the element at the front of the queue
            val i = queue.remove()

            // If the element is equal to the target, we return true
            if (i == target)
                return true

            // We add the adjacents of the current node to the queue for further exploration
            for (j in adj[i]) {
                if (!visited[j]) {
                    visited[j] = true
                    queue.add(j)
                }
            }
        }

        // If the target is not found, return false
        return false
    }
}