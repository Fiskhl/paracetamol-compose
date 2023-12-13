package com.example.paracetamol.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Archive
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.paracetamol.screen.Screen

data class NavItem(
    val icon: ImageVector,
    val label: String,
    val route: String,
)

val listOfNavItems = listOf(
    NavItem(
        icon = Icons.Default.Home,
        label = "Home",
        route = Screen.HomeScreen.route
    ) ,
    NavItem(
        icon = Icons.Default.Search,
        label = "Search",
        route = Screen.SearchScreen.route
    ),
    NavItem(
        icon = Icons.Default.Archive,
        label = "Archive",
        route = Screen.ArchiveScreen.route
    ),
    NavItem(
        icon = Icons.Default.Person,
        label = "Profile",
        route = Screen.ProfileScreen.route
    ),
)