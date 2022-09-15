package com.dlight.algoguide.algorithms.sorting

sealed class Events {
    object speedUp : Events()
    object slowDown : Events()
    object playPause : Events()
    object previous : Events()
    object next : Events()
}