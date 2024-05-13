package com.example.transport.Home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.transport.Data.AuthViewModel
import com.example.transport.Intro.TextComponents
import com.example.transport.navigation.ROUTE_INFO


val sacco = listOf("CITY SHUTTLE", "SUPER METRO", "LUXURY TRAVELERS", "2NK ","")
@Composable
//val sacco = listOf("CITY SHUTTLE", "SUPER METRO", "LUXURY TRAVELERS", "2NK ")

fun HomeScreen(navController: NavHostController){
    // val sacco = listOf("CITY SHUTTLE", "SUPER METRO", "LUXURY TRAVELERS", "2NK ")

    Column {
        TextComponents(value = "Welcome, Choose a sacco to review", size = 30.sp, colorValue = Color.White )

        LazyColumn(modifier = Modifier ) {
            // val sacco = listOf("CITY SHUTTLE", "SUPER METRO", "LUXURY TRAVELERS", "2NK ")

            items(items =sacco ) { index ->
                // Replace with your item content

                Column(modifier = Modifier){
                    // navController.navigate(ROUTE_HOME)


                    Button(
                        onClick = {

                            val myInfo = AuthViewModel(navController, navController.context)

                            navController.navigate(ROUTE_INFO)
                        },
                        colors = ButtonDefaults.buttonColors(Color.Black),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(30.dp)
                    ) {
                        Text(
                            modifier = Modifier.padding(10.dp),
                            text = "",
                            color = Color.White
                        )
                        Text(
                            modifier = Modifier.padding(10.dp),
                            text = "home sacco",
                            color = Color.White
                        )
                    }

                }
            }
        }
    }
}