package com.example.paracetamol.nav


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.paracetamol.LandingScreen
import com.example.paracetamol.LoginScreen
import com.example.paracetamol.RegisterScreen
import com.example.paracetamol.screen.Screen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LandingScreen.route){
        composable(route = Screen.LandingScreen.route){
            LandingScreen(navController = navController)
        }
        composable(route =Screen.LoginScreen.route){
            LoginScreen(navController = navController)
        }
        composable(route = Screen.RegisterScreen.route){
            RegisterScreen(navController = navController)
        }
    }
}