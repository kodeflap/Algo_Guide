package com.dlight.algoguide.algorithms.sorting.insertion_sort.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.dlight.algoguide.R

@Composable
fun Visualizer(
    modifier: Modifier = Modifier,
    playPauseClick: () -> Unit,
    slowDownClick: () -> Unit,
    speedUpClick: () -> Unit,
    previousClick: () -> Unit,
    nextClick: () -> Unit,
    isPlaying: Boolean = false
) {
    BottomAppBar(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IconButton(onClick = slowDownClick) {
                Icon(
                    painter = painterResource(id = androidx.core.R.drawable.notification_bg),
                    contentDescription = "Slow down",
                    tint = MaterialTheme.colors.onSurface
                )
            }

            IconButton(onClick = playPauseClick) {
                Icon(
                    painter = painterResource(
                        id = if (!isPlaying) R.drawable.ic_launcher_background else R.drawable.ic_launcher_foreground
                    ),
                    contentDescription = "Play Pause",
                    tint = MaterialTheme.colors.onSurface
                )
            }

            IconButton(onClick = speedUpClick) {
                Icon(
                    painter = painterResource(
                        id = if (!isPlaying) R.drawable.ic_launcher_background else R.drawable.ic_launcher_foreground
                    ),
                    contentDescription = "Speed Up",
                    tint = MaterialTheme.colors.onSurface
                )
            }

            IconButton(onClick = previousClick) {
                Icon(
                    painter = painterResource(
                        id = if (!isPlaying) R.drawable.ic_launcher_background else R.drawable.ic_launcher_foreground
                    ),
                    contentDescription = "Previous",
                    tint = MaterialTheme.colors.onSurface
                )
            }

            IconButton(onClick = nextClick) {
                Icon(
                    painter = painterResource(
                        id = if (!isPlaying) R.drawable.ic_launcher_background else R.drawable.ic_launcher_foreground
                    ),
                    contentDescription = "next",
                    tint = MaterialTheme.colors.onSurface
                )
            }

        }
    }
}