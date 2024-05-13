package com.example.transport.Load

import android.widget.Toast
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.transport.navigation.ROUTE_INFO
import com.example.transport.navigation.ROUTE_REGISTER
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoadingScreen(navController: NavHostController) {
    val context = LocalContext.current.applicationContext

    androidx.compose.material3.TopAppBar(title = { Text(text = "TransRev") },
        navigationIcon = { IconButton(onClick = { Toast.makeText(context,"You have clicked to go back",
            Toast.LENGTH_SHORT).show() }) {
            //navController.navigate(ROUTE_INFO)
            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "menu", tint = Color.White)

        }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White
        ),
        actions = {
            IconButton(onClick = { navController.navigate(ROUTE_INFO) }) {
                //navController.navigate(ROUTE_HOME)
                Icon(imageVector = Icons.Filled.Home, contentDescription = "My profile", tint = Color.White)

            }

            var animatedProgress by remember { mutableStateOf(0f) }
            val infiniteTransition = rememberInfiniteTransition()

            val color by infiniteTransition.animateColor(
                initialValue = Color.White,
                targetValue = Color.Green,
                animationSpec = infiniteRepeatable(
                    animation = tween(2000),
                    repeatMode = RepeatMode.Reverse
                )
            )

            val scale by infiniteTransition.animateFloat(
                initialValue = 1.0f,
                targetValue = 1.5f,
                animationSpec = infiniteRepeatable(
                    animation = keyframes {
                        durationMillis = 1000
                        1.0f at 500
                    },
                    repeatMode = RepeatMode.Reverse
                )
            )

            LaunchedEffect(key1 = true) {
                delay(500)
                animatedProgress = 1f
            }

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "You have successfully submitted your review ",
                    style = TextStyle(
                        color = color,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        // letterSpacing = animatedProgress * 4
                    ),
                    modifier = Modifier.scale(scale)
                )

            }
        })}