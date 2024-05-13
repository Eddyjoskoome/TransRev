//@file:JvmName("RouterKt")

package com.example.transport.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.transport.Home.HomeScreen
import com.example.transport.Info.InfoScreen
import com.example.transport.Intro.IntroScreen
import com.example.transport.Load.LoadingScreen
import com.example.transport.Login.LoginScreen
import com.example.transport.Register.registerScreen
import com.example.transport.car.CarScreen


@Composable
fun AppNavHost(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController(), startDestination: String= ROUTE_INTRO) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination
    ) {
        composable(ROUTE_INTRO) {
            IntroScreen(navController)
        }
        composable(ROUTE_REGISTER) {
            registerScreen(navController)
        }

        composable(ROUTE_LOGIN) {
            LoginScreen(navController)
        }
        composable(ROUTE_HOME) {
            HomeScreen(navController)
        }
        composable(ROUTE_CAR) {
            CarScreen(navController)
        }
        composable(ROUTE_INFO) {
            InfoScreen(navController)
        }
        composable(ROUTE_LOAD) {
            LoadingScreen(navController)
        }
//        composable(ROUTE_NAV) {
//            NavScreen(navController)
//        }
//        composable(ROUTE_INFO) {
//            // Composable for Settings screen
//            // Include NavigationBar passing navController
//            NavScreen(navController)
//        }
//
//        composable(ROUTE_HOME) {
//            // Composable for Home screen
//            // Include NavigationBar passing navController
//            NavScreen(navController)
//        }
    }
}
