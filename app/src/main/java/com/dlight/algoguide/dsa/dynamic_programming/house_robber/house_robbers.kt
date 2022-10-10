package com.dlight.algoguide.dsa.dynamic_programming.house_robber

object house_robbers {
    @JvmStatic
    fun main(args: Array<String>) {
        val data = intArrayOf(2, 7, 9, 3, 1)
        println(rob(data))
    }

    fun rob(num: IntArray): Int {
        var rob = 0 //max monney can get if rob current house
        var notrob = 0 //max money can get if not rob current house
        for (i in num.indices) {
            val currob = notrob + num[i] //if rob current value, previous house must not be robbed
            notrob = Math.max(
                notrob,
                rob
            ) //if not rob ith house, take the max value of robbed (i-1)th house and not rob (i-1)th house
            rob = currob
        }
        return Math.max(rob, notrob)
    }
}