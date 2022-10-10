package com.dlight.algoguide.dsa.dynamic_programming.knapsack_algorithm

internal object Knapsack {
    // A utility function that returns
    // maximum of two integers
    fun max(a: Int, b: Int): Int {
        return if (a > b) a else b
    }

    // Returns the maximum value that can
    // be put in a knapsack of capacity W
    fun knapSack(
        W: Int, wt: IntArray,
        `val`: IntArray, n: Int
    ): Int {
        var i: Int
        var w: Int
        val K = Array(n + 1) {
            IntArray(
                W + 1
            )
        }

        // Build table K[][] in bottom up manner
        i = 0
        while (i <= n) {
            w = 0
            while (w <= W) {
                if (i == 0 || w == 0) K[i][w] = 0 else if (wt[i - 1] <= w) K[i][w] = max(
                    `val`[i - 1]
                            + K[i - 1][w - wt[i - 1]],
                    K[i - 1][w]
                ) else K[i][w] = K[i - 1][w]
                w++
            }
            i++
        }
        return K[n][W]
    }

    // Driver code
    @JvmStatic
    fun main(args: Array<String>) {
        val `val` = intArrayOf(60, 100, 120)
        val wt = intArrayOf(10, 20, 30)
        val W = 50
        val n = `val`.size
        println(knapSack(W, wt, `val`, n))
    }
}