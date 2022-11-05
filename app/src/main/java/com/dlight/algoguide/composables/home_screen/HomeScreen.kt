package com.dlight.algoguide.composables.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .width(width = 375.dp)
            .height(height = 812.dp)
            .padding(start = 15.dp,
                end = 23.dp,
                top = 44.dp,
                bottom = 195.dp)
            .background(color = Color.White)
    ) {
        Component()
        Component()
        Component()
        Component()
        Component()
    }
}

@Composable
fun Component() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .width(width = 150.dp)
            .height(height = 181.dp)
    ) {
        Box(
            modifier = Modifier
                .size(size = 150.dp))
        Text(
            text = "          Tree",
            color = Color.Black,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold)
        )
        Box(
            modifier = Modifier
                .size(size = 100.dp)
                .background(color = Color(0xffd9d9d9)))
    }
}