package com.dlight.algoguide.dsa.dynamic_programming.pascals_triangle

object pascal_triangle {
    @JvmStatic
    fun main(args: Array<String>) {
        val numRows = 5
        println(generate(numRows))
    }

    fun generate(numRows: Int): List<List<Int>> {
        val res: MutableList<List<Int>> = ArrayList()
        var pre: List<Int>? = null
        for (i in 0 until numRows) {
            val row: MutableList<Int> = ArrayList()
            for (j in 0..i) {
                if (j == 0 || j == i) row.add(1) else {
                    row.add(pre!![j - 1] + pre[j])
                }
            }
            pre = row
            res.add(row)
        }
        return res
    }
}
