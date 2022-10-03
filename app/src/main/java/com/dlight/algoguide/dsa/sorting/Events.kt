package com.dlight.algoguide.dsa.sorting

sealed class Events {
    object speedUp : Events()
    object slowDown : Events()
    object playPause : Events()
    object previous : Events()
    object next : Events()
}