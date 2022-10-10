package com.dlight.algoguide.dsa.dynamic_programming.unique_paths

object Unique_Paths {
    @JvmStatic
    fun main(args: Array<String>) {
        val m = 3
        val n = 2
        println(uniquePaths(m, n))
    }

    fun uniquePaths(m: Int, n: Int): Int {
        val grid = Array(m) {
            IntArray(
                n
            )
        }
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (i == 0 || j == 0) grid[i][j] = 1 else grid[i][j] =
                    grid[i][j - 1] + grid[i - 1][j]
            }
        }
        return grid[m - 1][n - 1]
    }
}