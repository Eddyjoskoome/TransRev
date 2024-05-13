package com.example.transport.Register

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.transport.Data.AuthViewModel
import com.example.transport.R
import com.example.transport.navigation.ROUTE_HOME
import com.example.transport.navigation.ROUTE_LOGIN


@Composable
fun registerScreen(navController: NavHostController) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var pass by remember { mutableStateOf(TextFieldValue("")) }
    var confirmpass by remember { mutableStateOf(TextFieldValue("")) }
    var context = LocalContext.current
    Image(
        painter = painterResource(id = R.drawable.car),
        contentDescription = "Background Image",
        contentScale = ContentScale.FillBounds,
        //  modifier = Modifier.matchParentSize())
    )
    Column {
        Text(
            text = "Register here",
            color = Color.Cyan,
            fontFamily = FontFamily.Cursive,
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(20.dp))

        Column (modifier = Modifier){
            OutlinedTextField(
                value = email, onValueChange = { email = it },
                label = { Text(text = "Enter Email") },

                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))


        Box {
            OutlinedTextField(
                value = pass, onValueChange = { pass = it },
                label = { Text(text = "Enter password") },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        Box(modifier = Modifier) {
            OutlinedTextField(
                value = confirmpass, onValueChange = {
                    confirmpass = it
                },
                label = { Text(text = "Enter Confirm Pass") },

                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                val myregister = AuthViewModel(navController, navController.context)
                myregister.signup(
                    email.text.trim(),
                    pass.text.trim(),
                    confirmpass.text.trim()
                )
                navController.navigate(ROUTE_HOME)
            },
            colors = ButtonDefaults.buttonColors(Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)
        ) {
            Text(
                modifier = Modifier.padding(10.dp),
                text = "Create an account",
                color = Color.White
            )
        }

        Button(
            onClick = { val myintro = AuthViewModel(navController,context)
                myintro.signup(email.text.trim(), pass.text.trim(), confirmpass.text.trim())
                navController.navigate(ROUTE_LOGIN)
            },
            colors = ButtonDefaults.buttonColors(Color.Unspecified),
            modifier = Modifier.fillMaxWidth()

        ) {
            Text(
                modifier = Modifier.padding(20.dp),
                text = "Already have an account?",
                color = Color.Black
            )
        }
    }

}

