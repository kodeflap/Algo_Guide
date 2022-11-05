package com.dlight.algoguide.composables.chapter_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dlight.algoguide.R

@Composable
fun ChapterScreen() {
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .width(width = 375.dp)
            .height(height = 812.dp)
            .padding(bottom = 37.dp)
            .background(color = Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_pause),
            contentDescription = "Ellipse 7",
            modifier = Modifier
                .width(width = 460.dp)
                .height(height = 281.dp))
        Box(
            modifier = Modifier
                .size(size = 50.dp)
                .background(color = Color(0xff74f823)))
        Box(
            modifier = Modifier
                .size(size = 50.dp)
                .background(color = Color(0xff74f823)))
        Box(
            modifier = Modifier
                .size(size = 50.dp)
                .background(color = Color(0xffd9d9d9)))
        Box(
            modifier = Modifier
                .size(size = 50.dp)
                .background(color = Color(0xffd9d9d9)))
        Box(
            modifier = Modifier
                .size(size = 50.dp)
                .background(color = Color(0xffd9d9d9)))
        Box(
            modifier = Modifier
                .size(size = 50.dp)
                .background(color = Color(0xffd9d9d9)))
        Box(
            modifier = Modifier
                .size(size = 50.dp)
                .background(color = Color(0xffd9d9d9)))
        Text(
            text = "Introduction",
            color = Color.Black,
            style = TextStyle(
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold)
        )
        Text(
            text = "Loreum ipsum",
            color = Color.Black,
            style = TextStyle(
                fontSize = 25.sp,
                fontWeight = FontWeight.Medium))
        Text(
            text = "Loreum ipsum",
            color = Color.Black,
            style = TextStyle(
                fontSize = 25.sp,
                fontWeight = FontWeight.Medium))
        Text(
            text = "Loreum ipsum",
            color = Color.Black,
            style = TextStyle(
                fontSize = 25.sp,
                fontWeight = FontWeight.Medium))
        Text(
            text = "What is ds",
            color = Color.Black,
            style = TextStyle(
                fontSize = 25.sp,
                fontWeight = FontWeight.Medium))
        Text(
            text = "Loreum ipsum",
            color = Color.Black,
            style = TextStyle(
                fontSize = 25.sp,
                fontWeight = FontWeight.Medium))
        Text(
            text = "Loreum ipsum",
            color = Color.Black,
            style = TextStyle(
                fontSize = 25.sp,
                fontWeight = FontWeight.Medium))
        Text(
            text = "Loreum ipsum",
            color = Color.Black,
            style = TextStyle(
                fontSize = 25.sp,
                fontWeight = FontWeight.Medium))
    }
}