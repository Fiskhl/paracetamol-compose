package com.example.paracetamol.nav


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.paracetamol.AdminMemberListScreen
import com.example.paracetamol.AdminMemberDetailsScreen
import com.example.paracetamol.LandingScreen
import com.example.paracetamol.LoginScreen
import com.example.paracetamol.RegisterScreen
import com.example.paracetamol.screen.Screen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LoginScreen.route){
        composable(route = Screen.LandingScreen.route){
            LandingScreen(navController = navController)
        }
        composable(route =Screen.LoginScreen.route){
            LoginScreen(navController = navController)
        }
        composable(route = Screen.RegisterScreen.route){
            RegisterScreen(navController = navController)
        }
        composable(route = Screen.AdminMemberListScreen.route){
            AdminMemberListScreen(navController = navController)
        }
        composable(route = Screen.AdminMemberDetailScreen.route + "/{name}/{studentId}") { navBackStackEntry ->
            val name = navBackStackEntry.arguments?.getString("name") ?: ""
            val studentId = navBackStackEntry.arguments?.getString("studentId") ?: ""
            AdminMemberDetailsScreen(navController = navController, name = name, studentId = studentId)
        }
    }
}