package com.example.transport.car


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun CarScreen(navController: NavHostController){
    LazyColumn {
        items(1) { index ->
            Column {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        //.height(20.dp)
                        .padding(50.dp)
                        .aspectRatio(1.5f),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(10.dp)
                )

                {

                    Box(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center,
                    )
                    {

                        Text(text = "MINIBUS", color = Color.Black)
                    }

                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        //.height(20.dp)
                        .padding(50.dp)
                        .aspectRatio(1.5f),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(10.dp)
                )

                {

                    Box(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center,
                    )
                    {


                        Text(text = "BUS", color = Color.Black)
                    }

                }
            }


        }

    }

}