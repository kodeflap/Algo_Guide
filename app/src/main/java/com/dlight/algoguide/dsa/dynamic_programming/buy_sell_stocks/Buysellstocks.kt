package com.dlight.algoguide.dsa.dynamic_programming.buy_sell_stocks

object buysellstocks {
    @JvmStatic
    fun main(args: Array<String>) {
        val prices = intArrayOf(7, 1, 5, 3, 6, 4)
        println(maxProfit(prices))
    }

    private fun maxProfit(prices: IntArray): Int {
        var buy = Int.MAX_VALUE
        var maxprofit = 0
        for (i in prices.indices) {
            buy = Math.min(buy, prices[i])
            maxprofit = Math.max(maxprofit, prices[i] - buy)
        }
        return maxprofit
    }
}