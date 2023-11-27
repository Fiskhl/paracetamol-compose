package com.example.paracetamol.screen

sealed class Screen(val route: String) {
    object LandingScreen : Screen("landing_screen")
    object LoginScreen : Screen("login_screen")
    object RegisterScreen : Screen("register_screen")
    object AdminMemberListScreen : Screen("admin_member_list")
}