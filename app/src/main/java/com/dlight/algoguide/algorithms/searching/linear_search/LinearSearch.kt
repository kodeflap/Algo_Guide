package com.dlight.algoguide.algorithms.searching.linear_search

class LinearSearch {
     suspend fun linearSearch(arr: IntArray, target: Int, isFound: (Boolean) -> Unit){
        for(i in arr){
            if(i == target) {
                isFound(true)
                break
            }
            isFound(false)
        }
    }
}

