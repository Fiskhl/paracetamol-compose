package com.example.paracetamol.nav


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.paracetamol.screen.admin.AdminMemberListScreen
import com.example.paracetamol.screen.admin.AdminMemberDetailsScreen
import com.example.paracetamol.nav_screen.HomeScreen
import com.example.paracetamol.screen.LoginScreen
import com.example.paracetamol.nav_screen.ProfileScreen
import com.example.paracetamol.screen.RegisterScreen
import com.example.paracetamol.nav_screen.SearchScreen
import com.example.paracetamol.screen.Screen
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import com.example.paracetamol.screen.UserGroupScreen
import com.example.paracetamol.screen.CreateScreen
import com.example.paracetamol.screen.JoinScreen
import com.example.paracetamol.nav_screen.ArchiveScreen
import com.example.paracetamol.preferences.PreferenceManager
import com.example.paracetamol.screen.ArchiveAdminGroupDetail
import com.example.paracetamol.screen.MemberGroupScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation() {
    val navController = rememberNavController()
    val context = LocalContext.current
    var isLoggedIn by rememberSaveable{ mutableStateOf(false) }
    val sessionExist = PreferenceManager.getIsLoggedIn(context)

    if(sessionExist == true) isLoggedIn = true

    Scaffold(
        bottomBar = {
            if(isLoggedIn){
                NavigationBar {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination

                    listOfNavItems.forEach { navItem ->
                        NavigationBarItem(
                            selected = currentDestination?.hierarchy?.any() {it.route == navItem.route} == true,
                            onClick = {
                                navController.navigate(navItem.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            icon = {
                                Icon(
                                    imageVector = navItem.icon,
                                    contentDescription = null
                                )
                            },
                            label = {
                                Text(text = navItem.label)
                            }
                        )
                    }
                }
            }

        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination =
                if(isLoggedIn) Screen.HomeScreen.route
                else Screen.LoginScreen.route,
            modifier = Modifier.padding(paddingValues)
        ){
            composable(route = Screen.LoginScreen.route){
                LoginScreen(navController = navController){
                    isLoggedIn = true
                }
            }
            composable(route = Screen.RegisterScreen.route){
                RegisterScreen(navController = navController)
            }
            composable(route = Screen.HomeScreen.route){
                HomeScreen(navController = navController)
            }
            composable(route = Screen.SearchScreen.route){
                SearchScreen(navController = navController)
            }
            composable(route = Screen.ArchiveScreen.route){
                ArchiveScreen(navController = navController)
            }
            composable(route = Screen.ProfileScreen.route){
                ProfileScreen(navController = navController){
                    isLoggedIn = false
                }
            }
            composable(route = Screen.AdminMemberListScreen.route){
                AdminMemberListScreen(navController = navController)
            }
            composable(route = Screen.CreateScreen.route){
                CreateScreen(navController = navController)
            }
            composable(route = Screen.JoinScreen.route){
                JoinScreen(navController = navController)
            }
            composable(route = Screen.MemberGroupScreen.route + "/{title}/{description}") { navBackStackEntry ->
                val title = navBackStackEntry.arguments?.getString("title") ?: ""
                val description = navBackStackEntry.arguments?.getString("description") ?: ""
                MemberGroupScreen(navController = navController, title = title, description = description)
            }
            composable(route = Screen.AdminMemberDetailScreen.route + "/{name}/{studentId}") { navBackStackEntry ->
                val name = navBackStackEntry.arguments?.getString("name") ?: ""
                val studentId = navBackStackEntry.arguments?.getString("studentId") ?: ""
                AdminMemberDetailsScreen(navController = navController, name = name, studentId = studentId)
            }
            composable(route = Screen.UserGroupScreen.route + "/{title}/{description}") { navBackStackEntry ->
                val title = navBackStackEntry.arguments?.getString("title") ?: ""
                val description = navBackStackEntry.arguments?.getString("description") ?: ""
                UserGroupScreen(navController = navController, titleA = title, descriptionA = description)
            }
            composable(route = Screen.ArchiveAdminGroupDetail.route + "/{title}/{description}") { navBackStackEntry ->
                val title = navBackStackEntry.arguments?.getString("title") ?: ""
                val description = navBackStackEntry.arguments?.getString("description") ?: ""
                ArchiveAdminGroupDetail(navController = navController, title = title, description = description)
            }

        }
    }

}
