package com.dlight.algoguide.dsa.sorting.bubble_sort.domain.model

data class SortModel(
    val currentItem: Int,
    val shouldSwap: Boolean,
    val hasNoEffect: Boolean
)
