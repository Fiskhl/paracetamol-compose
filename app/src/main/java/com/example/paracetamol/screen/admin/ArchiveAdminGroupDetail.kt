package com.example.paracetamol.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun ArchiveAdminGroupDetail(
    title: String,
    description: String,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
            .padding(horizontal = 16.dp)
            .padding(top = 18.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(
                onClick = { navController.navigateUp() }, // Back
                modifier = Modifier
                    .padding(start = 1.dp),
            ) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
        }
        Text(
            text = title,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = description,
                modifier = Modifier.padding(top = 4.dp),
                fontSize = 16.sp
            )
        }
        Text(
            text = "Nama Profile",
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(100.dp))
    }
}



@Composable
@Preview(showBackground = true)
fun ArchiveAdminGroupDetailPreview() {
    val navController = rememberNavController()
    ArchiveAdminGroupDetail(
        "UMN Festival 2021",
        "Devote Yourself to be a True Spartan",
        navController = navController
    )
}