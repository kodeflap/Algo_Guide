package com.dlight.algoguide.dsa.dynamic_programming.flloyd_warshall_algorithm


internal class FloydWarshall {
    // Implementing floyd warshall algorithm
    fun floydWarshall(graph: Array<IntArray>) {
        val matrix = Array(nV) {
            IntArray(
                nV
            )
        }
        var i: Int
        var j: Int
        i = 0
        while (i < nV) {
            j = 0
            while (j < nV) {
                matrix[i][j] = graph[i][j]
                j++
            }
            i++
        }

        // Adding vertices individually
        var k: Int = 0
        while (k < nV) {
            i = 0
            while (i < nV) {
                j = 0
                while (j < nV) {
                    if (matrix[i][k] + matrix[k][j] < matrix[i][j]) matrix[i][j] =
                        matrix[i][k] + matrix[k][j]
                    j++
                }
                i++
            }
            k++
        }
        printMatrix(matrix)
    }

    private fun printMatrix(matrix: Array<IntArray>) {
        for (i in 0 until nV) {
            for (j in 0 until nV) {
                if (matrix[i][j] == INF) print("INF ") else print(matrix[i][j].toString() + "  ")
            }
            println()
        }
    }

    companion object {
        const val INF = 9999
        const val nV = 4
        @JvmStatic
        fun main(args: Array<String>) {
            val graph = arrayOf(
                intArrayOf(0, 3, INF, 5),
                intArrayOf(2, 0, INF, 4),
                intArrayOf(INF, 1, 0, INF),
                intArrayOf(
                    INF, INF, 2, 0
                )
            )
            val a = FloydWarshall()
            a.floydWarshall(graph)
        }
    }
}