package com.example.transport.Intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.transport.Data.AuthViewModel
import com.example.transport.R
import com.example.transport.navigation.ROUTE_LOGIN
import com.example.transport.navigation.ROUTE_REGISTER

@Composable
fun IntroScreen(navController: NavHostController) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var pass by remember { mutableStateOf(TextFieldValue("")) }
    var confirmpass by remember { mutableStateOf(TextFieldValue("")) }
    var context = LocalContext.current
    Box (modifier = Modifier.fillMaxSize())
    {
        Image(painter = painterResource(id = R.drawable.pixel),
            contentDescription ="Background Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize())
    }

    Column(
        modifier = Modifier.border(
            width = 2.dp,
            color = Color.White,
            shape = RoundedCornerShape(10.dp)
        )
    ) {

        // Spacer(modifier = Modifier.height(30.dp))

        Box ()
        {
            Image(painter = painterResource(id = R.drawable.logo_trial),
                contentDescription ="logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(100.dp)
                    //.width(90.dp)
                    .height(90.dp)
                    .wrapContentHeight(Alignment.Top))


            //TextComponents(value = "TransRev", size = 40.sp, colorValue = Color.Unspecified)
        }


        Spacer(modifier = Modifier.height(1.dp))

        Column(
            modifier = Modifier
                .padding(10.dp)
                .background(color = Color.Unspecified)
            // .border(
            //   width = 1.dp,
            // color = Color.Unspecified,
            //shape = RoundedCornerShape(10.dp)
            //)
        ) {
            TextComponents(value = "Welcome to TransReview", size = 30.sp, Color.White)
            TextComponents(value = "Rate the kenyan transport system so as to better our country", size =20.sp , colorValue = Color.White )
            TextComponents(value = "PLEASE REGISTER HERE", size = 30.sp, colorValue = Color.White)

            Button(
                onClick = {

                    val myregister = AuthViewModel(navController,context)
                    myregister.signup(email.text.trim(), pass.text.trim(), confirmpass.text.trim())
                    navController.navigate(ROUTE_REGISTER)
                },
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp)
            ) {
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = "Create an account",
                    color = Color.Black
                )
            }
            Button(
                onClick = { val myintro = AuthViewModel(navController,context)
                    myintro.signup(email.text.trim(), pass.text.trim(), confirmpass.text.trim())
                    navController.navigate(ROUTE_LOGIN)
                },
                colors = ButtonDefaults.buttonColors(Color.Black),
                modifier = Modifier.fillMaxWidth()

            ) {
                Text(
                    modifier = Modifier.padding(20.dp),
                    text = "Already have an account?",
                    color = Color.White
                )
            }
        }
    }
}




@Composable
fun TextComponents(value: String, size: TextUnit, colorValue: Color) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            //.wrapContentWidth(align = Alignment.Start)
            // .wrapContentHeight(align = Alignment.Top)
            .background(Color.Unspecified)
            .border(width = 2.dp, color = Color.Black)
            .padding(18.dp),

        text = value,
        fontSize = size,
        color = colorValue
    )
}
