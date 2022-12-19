package com.dlight.algoguide.dsa.sorting.bubble_sort.state

import androidx.compose.ui.graphics.Color

data class ListUiItem(
    val id: Int,
    val isCurrentlyCompared: Boolean,
    val value: Int,
    val color: Color
)