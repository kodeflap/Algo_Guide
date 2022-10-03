package com.dlight.algoguide.dsa.sorting.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun VisualizerSection(
    modifier: Modifier = Modifier,
    arr: IntArray
) {
    BoxWithConstraints(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ) {
        val maxHeight = maxHeight - 75.dp
        val itemWidth = remember {
            maxWidth / arr.size - 2.dp
        }

        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom,
        ) {
            arr.forEach {
                Box(
                    modifier = modifier
                        .height(if (it.dp > maxHeight) maxHeight else it.dp)
                        .width(itemWidth)
                        .background(MaterialTheme.colors.onBackground)
                )
            }
        }
    }
}