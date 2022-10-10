package com.dlight.algoguide.dsa.graph.floyds_algorithm

import kotlin.jvm.JvmStatic

class FloydsAlgorithm  {
    var V = 4
    val INF = 99999
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            // TODO Auto-generated method stub
            val ob = FloydsAlgorithm()
            val arr = arrayOf(
                intArrayOf(0, 3, ob.INF, 7),
                intArrayOf(8, 0, 2, ob.INF),
                intArrayOf(5, ob.INF, 0, 1),
                intArrayOf(2, ob.INF, ob.INF, 0)
            )
            ob.shortestPath(arr)
        }
    }

    fun shortestPath(arr: Array<IntArray>) {
        for (k in 0 until V) {
            for (i in 0 until V) {
                for (j in 0 until V) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j]
                    }
                }
            } //DIRECT AND UNDIRECT GRAPH BOTH APPLICABLE
        } //BUT THE WEIGHTS OF EDGES SHOULD BE POSITIVE
        for (i in 0 until V) {
            print("Shortest Path From $i : ")
            for (j in 0 until V) {
                if (arr[i][j] == INF) {
                    print("INF ")
                } else {
                    print(arr[i][j].toString() + " ")
                }
            }
            println()
        }
    }
}
