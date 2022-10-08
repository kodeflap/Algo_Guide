package com.dlight.algoguide.dsa.searching.linear_search

class LinearSearch {
     suspend fun linearSearch(arr: IntArray, target: Int, isFound: (Boolean) -> Unit){
        /*Finding element in the array while iterating over the array if found then break */
        for(i in arr){
            if(i == target) {
                isFound(true)
                break
            }
            isFound(false)
        }
    }
}

