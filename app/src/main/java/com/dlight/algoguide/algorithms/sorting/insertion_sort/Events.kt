package com.dlight.algoguide.algorithms.sorting.insertion_sort

sealed class Events {
    object slowDown : Events()
    object playPause : Events()
    object speedUp : Events()
    object previous : Events()
    object next : Events()
}