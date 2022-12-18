package com.dlight.algoguide.dsa.sorting.topological_sort

import java.util.*

class TopologicalSort {
    inner class Vertex(val value: Any) {
        val neighbors = mutableListOf<Vertex>()
    }

    inner class Edge(val from: Vertex, val to: Vertex)
    
    suspend fun topologicalSort(vertices: List<Vertex>, edges: List<Edge>): List<Vertex> {
        val sortedVertices = mutableListOf<Vertex>()
        val indegrees = mutableMapOf<Vertex, Int>()
        val queue = LinkedList<Vertex>()

        // Initialize indegree of each vertex
        for (vertex in vertices) {
            indegrees[vertex] = 0
        }

        // Populate indegree of each vertex by counting the number of edges coming into it
        for (edge in edges) {
            indegrees[edge.to] = indegrees[edge.to]!! + 1
        }

        // Add all vertices with 0 indegree to the queue
        for (vertex in vertices) {
            if (indegrees[vertex] == 0) {
                queue.offer(vertex)
            }
        }

        // Process vertices in the queue
        while (queue.isNotEmpty()) {
            val vertex = queue.poll()
            if (vertex != null) {
                sortedVertices.add(vertex)
            }

            // Decrement indegree of each neighbor
            if (vertex != null) {
                for (neighbor in vertex.neighbors) {
                    indegrees[neighbor] = indegrees[neighbor]!! - 1
                    if (indegrees[neighbor] == 0) {
                        queue.offer(neighbor)
                    }
                }
            }
        }

        // If sortedVertices.size is not equal to the number of vertices, then there was a cycle and the graph is not a DAG
        return if (sortedVertices.size == vertices.size) sortedVertices else emptyList()
    }

}