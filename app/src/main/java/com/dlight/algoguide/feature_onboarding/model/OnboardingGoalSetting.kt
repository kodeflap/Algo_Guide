package com.dlight.algoguide.feature_onboarding.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.FocusRequesterFactory.component12
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dlight.algoguide.R

@Composable
fun OnboardingGoalSetting() {
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .width(width = 375.dp)
            .height(height = 812.dp)
            .padding(start = 35.dp,
                end = 36.dp,
                top = 70.dp,
                bottom = 34.dp)
            .background(color = Color.White)
    ) {
        Text(
            text = " Daily remainder",
            color = Color.Black,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold)
        )
        Text(
            text = "Set a daily Goal",
            color = Color.Black,
            style = TextStyle(
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold))
        Component()
        Component()
        Box(
            modifier = Modifier
                .width(width = 279.dp)
                .height(height = 67.dp)
                .background(color = Color(0xff17a1fa)))
        Text(
            text = "Get Started >>",
            color = Color.Black,
            style = TextStyle(
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold))
        Component()
        Component()
        Image(
            painter = painterResource(id = R.drawable.ic_play),
            contentDescription = "Component 12",
            modifier = Modifier
                .width(width = 70.dp)
                .height(height = 30.dp))
    }
}

@Composable
fun Component() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .width(width = 136.dp)
            .height(height = 200.dp)
    ) {
        Box(
            modifier = Modifier
                .width(width = 136.dp)
                .height(height = 200.dp)
                .background(color = Color(0xffd9d9d9)))
        Text(
            text = "min /day",
            color = Color.Black,
            style = TextStyle(
                fontSize = 25.sp))
        Text(
            text = "20",
            color = Color.Black,
            style = TextStyle(
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold))
    }
}