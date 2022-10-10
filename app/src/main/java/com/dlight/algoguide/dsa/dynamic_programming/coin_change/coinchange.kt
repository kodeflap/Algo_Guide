package com.dlight.algoguide.dsa.dynamic_programming.coin_change

object CoinChange {
    @JvmStatic
    fun main(args: Array<String>) {
        val coins = intArrayOf(1, 2, 5)
        val amount = 11
        println(coinChange(coins, amount))
    }

    private fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1)
        for (i in 1 until dp.size) {
            dp[i] = dp.size
            for (c in coins) {
                if (i >= c) {
                    dp[i] = Math.min(dp[i], dp[i - c] + 1)
                }
            }
        }
        return if (dp[amount] == dp.size) -1 else dp[amount]
    }
}