package com.example.transport.Info

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.transport.R
import com.example.transport.navigation.ROUTE_LOAD

@Composable
fun InfoScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        // First column - Background picture and Profile picture
        BackgroundWithProfilePicture()

        // Second column - Personal details
        PersonalDetailsColumn()

        // Stars for rating
        StarRating()

        // Third column - Description box
        DescriptionBox()

        // Submit button
        SubmitButton(navController = navController)
    }
}

@Composable
fun BackgroundWithProfilePicture() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.5f)
            .background(color = Color.Gray) // Replace with your background color or image
    ) {
        // Replace "R.drawable.background_picture" with your actual background drawable resource ID
        Image(
            painter = painterResource(id = R.drawable.driver),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Profile picture
        ProfilePicture(
            modifier = Modifier
                .align(Alignment.Center)
                .size(120.dp)
        )
    }
}

@Composable
fun ProfilePicture(modifier: Modifier = Modifier) {
    // Replace "R.drawable.profile_picture" with your actual drawable resource ID
    Image(
        painter = painterResource(id = R.drawable.person),
        contentDescription = null,
        modifier = modifier
            .clip(CircleShape),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun PersonalDetailsColumn(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text("Name: John Doe")
        Text("Age: 30")
        Text("Gender: Male")
        Text("I have 5years Experience as a driver and am currently the driver of home sacco vehicle number32")
        // Add other personal details here
    }
    Spacer(modifier = Modifier.height(40.dp))
}

@Composable
fun StarRating() {
    var rating by remember { mutableStateOf(0) }

    Row {
        repeat(5) { index ->
            Star(
                filled = index < rating,
                onStarClicked = { rating = index + 1 }
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun Star(filled: Boolean, onStarClicked: () -> Unit) {
    val starIcon = rememberVectorPainter(Icons.Default.Star)
    val color = if (filled) {
        when {
            //starIcon.painter.color == Color.Blue -> Color.Red
            //starIcon.painter.color == Color.Red -> Color.Yellow
            else -> Color.Yellow
        }
    } else {
        Color.Gray
    }

    Icon(
        painter = starIcon,
        contentDescription = null,
        modifier = Modifier
            .clickable { onStarClicked() },
        tint = color
    )
    Spacer(modifier = Modifier.height(50.dp))
}

@Composable
fun DescriptionBox(modifier: Modifier = Modifier) {
    var descriptionText by remember { mutableStateOf("") }

    TextField(
        value = descriptionText,
        onValueChange = { descriptionText = it },
        modifier = modifier
            .fillMaxWidth()
            .height(130.dp),
        label = { Text("Describe the persons Good attributes") },
        shape = RectangleShape
    )
    Spacer(modifier = Modifier.height(50.dp))

    TextField(
        value = descriptionText,
        onValueChange = { descriptionText = it },
        modifier = modifier
            .fillMaxWidth()
            .height(130.dp),
        label = { Text("Describe the persons Bad attributes") },
        shape = RectangleShape
    )
    Spacer(modifier = Modifier.height(30.dp))
}

@Composable
fun SubmitButton(navController: NavHostController) {

    Button(onClick = {navController.navigate(ROUTE_LOAD)
        //  Navigate to another destination
        // navController.navigate("")
    }) {
        Text("SUBMIT")
    }}
//        Box(
//            modifier = Modifier.fillMaxSize(),
//            contentAlignment = Alignment.Center
//        ) {
//