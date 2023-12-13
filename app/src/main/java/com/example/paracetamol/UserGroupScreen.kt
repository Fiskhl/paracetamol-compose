package com.example.paracetamol

import android.app.ActivityManager.TaskDescription
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.paracetamol.nav_screen.ArchiveScreen
import com.example.paracetamol.nav_screen.HomeScreen
import com.example.paracetamol.screen.Screen
import com.google.gson.Gson


@Composable
fun UserGroupScreen(title: String, description: String, navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFFFFFFF))
        .padding(horizontal = 16.dp)
        .padding(top = 10.dp),
    ) {
        IconButton(
            onClick = { navController.navigateUp() }, // Back
            modifier = Modifier
                .padding(start = 1.dp),
        ) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ){
            Text(text = "$title",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ){
            Text(text = "Nama Profile",
                fontSize = 16.sp,
                textAlign = TextAlign.Center,)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
        ){
            Text(text = "$description", Modifier.padding(top = 4.dp), fontSize = 16.sp)
        }
        Spacer(modifier = Modifier.height(100.dp))

    }
}

@Composable
@Preview(showBackground = true)
fun UserGroupScreenPreview() {
    val navController = rememberNavController()
    UserGroupScreen(
        "MAXIMA 2023",
        "Explore The World Reach New Potentials",
        navController = navController
    )
}