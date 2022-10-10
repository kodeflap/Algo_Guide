package com.dlight.algoguide.dsa.dynamic_programming.Longest_Common_Subsequence

import java.util.*

object lcs {
    @JvmStatic
    fun main(args: Array<String>) {
        val s1 = "abcde"
        val s2 = "ace"
        println("The Length of Longest Common Subsequence is " + longestCommonSubsequence(s1, s2))
    }

    private fun longestCommonSubsequence(s1: String, s2: String): Int {
        val n = s1.length
        val m = s2.length
        val dp = Array(n + 1) {
            IntArray(
                m + 1
            )
        }
        for (rows in dp) {
            Arrays.fill(rows, -1)
        }
        for (i in 0..n) {
            dp[i][0] = 0
        }
        for (i in 0..m) {
            dp[0][i] = 0
        }
        for (ind1 in 0..n) {
            for (ind2 in 0..m) {
                if (s1[ind1] == s2[ind2]) {
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1]
                } else {
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1])
                }
            }
        }
        return dp[n][m]
    }
}
