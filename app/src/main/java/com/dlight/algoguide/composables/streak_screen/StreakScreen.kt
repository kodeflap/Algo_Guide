package com.dlight.algoguide.composables.streak_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dlight.algoguide.R

@Composable
fun StreakCount() {
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .width(width = 375.dp)
            .height(height = 812.dp)
            .padding(start = 34.dp,
                end = 27.dp,
                top = 50.dp,
                bottom = 64.dp)
            .background(color = Color.White)
    ) {
        Box(
            modifier = Modifier
                .width(width = 146.dp)
                .height(height = 136.dp)
                .background(color = Color(0xffd9d9d9)))
        Box(
            modifier = Modifier
                .width(width = 300.dp)
                .height(height = 36.dp)
                .background(color = Color(0xffd9d9d9)))
        Box(
            modifier = Modifier
                .width(width = 100.dp)
                .height(height = 36.dp)
                .background(color = Color(0xff74f823)))
        Box(
            modifier = Modifier
                .width(width = 314.dp)
                .height(height = 150.dp)
                .background(color = Color(0xffd9d9d9)))
        Text(
            text = "Daily Progress",
            color = Color.Black,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold)
        )
        CalendarMonthJanuary()
        Text(
            text = "        5\n   Topics",
            color = Color.Black,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold))
        Image(
            painter = painterResource(id = R.drawable.ic_play),
            contentDescription = "Open Book",
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .width(width = 96.dp)
                .height(height = 50.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_pause),
            contentDescription = "Local fire department",
            modifier = Modifier
                .size(size = 150.dp))
        Text(
            text = "20 days",
            color = Color.Black,
            style = TextStyle(
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold))
        Box(
            modifier = Modifier
                .width(width = 146.dp)
                .height(height = 136.dp)
                .background(color = Color(0xffd9d9d9)))
        Text(
            text = "      10\nChapters",
            color = Color.Black,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold))
        Image(
            painter = painterResource(id = R.drawable.ic_pause),
            contentDescription = "Paper",
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .width(width = 96.dp)
                .height(height = 50.dp))
    }
}

@Composable
fun CalendarMonthJanuary() {
    Box(
        contentAlignment = Alignment.BottomStart,
        modifier = Modifier
            .width(width = 284.dp)
            .height(height = 230.dp)
            .padding(bottom = 20.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .height(height = 120.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .width(width = 284.dp)
            ) {
                repeat(5) {
                    ItemsWeekDeyWeekendNoActiveYesFillNoStrokNo()
                }

                ItemsWeekDeyWeekendYesActiveYesFillNoStrokNo()
                ItemsWeekDeyWeekendYesActiveYesFillNoStrokNo()
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .width(width = 284.dp)
            ) {
                repeat(5) {
                    ItemsNamberDeyWeekendNoActiveNoFillNoStrokNo()
                }

                ItemsNamberDeyWeekendYesActiveYesFillNoStrokNo()
                ItemsNamberDeyWeekendYesActiveYesFillNoStrokNo()
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .width(width = 284.dp)
            ) {
                repeat(5) {
                    ItemsNamberDeyWeekendNoActiveYesFillNoStrokNo()
                }

                ItemsNamberDeyWeekendYesActiveYesFillNoStrokNo()
                ItemsNamberDeyWeekendYesActiveYesFillNoStrokNo()
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .width(width = 284.dp)
            ) {
                repeat(5) {
                    ItemsNamberDeyWeekendNoActiveYesFillNoStrokNo()
                }

                ItemsNamberDeyWeekendYesActiveYesFillNoStrokNo()
                ItemsNamberDeyWeekendYesActiveYesFillNoStrokNo()
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .width(width = 284.dp)
            ) {
                repeat(5) {
                    ItemsNamberDeyWeekendNoActiveYesFillNoStrokNo()
                }

                ItemsNamberDeyWeekendYesActiveYesFillNoStrokNo()
                ItemsNamberDeyWeekendYesActiveYesFillNoStrokNo()
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .width(width = 284.dp)
            ) {
                repeat(5) {
                    ItemsNamberDeyWeekendNoActiveYesFillNoStrokNo()
                }

                ItemsNamberDeyWeekendYesActiveYesFillNoStrokNo()
                ItemsNamberDeyWeekendYesActiveYesFillNoStrokNo()
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .width(width = 284.dp)
            ) {
                repeat(4) {
                    ItemsNamberDeyWeekendNoActiveNoFillNoStrokNo()
                }

                ItemsNamberDeyWeekendYesActiveNoFillNoStrokNo()
                ItemsNamberDeyWeekendYesActiveNoFillNoStrokNo()
            }
        }
    }
}

@Composable
fun ItemsWeekDeyWeekendNoActiveYesFillNoStrokNo() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(size = 22.dp)
    ) {
        Text(
            text = "Tu",
            color = Color(0xffb3b3b3),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 11.sp))
    }
}

@Composable
fun ItemsWeekDeyWeekendYesActiveYesFillNoStrokNo() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(size = 22.dp)
    ) {
        Text(
            text = "Su",
            color = Color(0xff17a1fa),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 11.sp))
    }
}

@Composable
fun ItemsNamberDeyWeekendNoActiveNoFillNoStrokNo() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(size = 22.dp)
    ) {
        Text(
            text = "2",
            color = Color(0xff616161),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 11.sp))
    }
}

@Composable
fun ItemsNamberDeyWeekendYesActiveYesFillNoStrokNo() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(size = 22.dp)
    ) {
        Text(
            text = "30",
            color = Color(0xff17a1fa),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 11.sp))
    }
}

@Composable
fun ItemsNamberDeyWeekendNoActiveYesFillNoStrokNo() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(size = 22.dp)
    ) {
        Text(
            text = "25",
            color = Color(0xffb3b3b3),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 11.sp))
    }
}

@Composable
fun ItemsNamberDeyWeekendYesActiveNoFillNoStrokNo() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(size = 22.dp)
    ) {
        Text(
            text = "6",
            color = Color(0xff1270b0),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 11.sp))
    }
}