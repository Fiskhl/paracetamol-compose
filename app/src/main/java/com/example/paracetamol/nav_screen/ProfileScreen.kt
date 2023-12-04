package com.example.paracetamol.nav_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.paracetamol.R
import com.example.paracetamol.screen.Screen
import com.example.paracetamol.ui.theme.poppinsFamily


@Composable
fun ProfileScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
    ) {
        Text(
            text = "Profile",
            fontSize = 36.sp,
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        // Profile Picture
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = null,
            modifier = Modifier
                .size(240.dp)
                .clip(MaterialTheme.shapes.medium)
                .padding(bottom = 16.dp)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Crop
        )

        Text(
            text = "Biodata",
            fontWeight = FontWeight.Bold,
            fontFamily = poppinsFamily,
            fontSize = 32.sp,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        )

        // User Name
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                tint = Black,
                modifier = Modifier
                    .size(30.dp)
                    .padding(end = 8.dp)
            )
            Text(
                text = "Kafijaya",
                fontFamily = poppinsFamily,
                fontSize = 18.sp,
            )
        }

        // Student ID
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_card),
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .padding(end = 8.dp)
            )
            Text(
                text = "00000061651",
                fontFamily = poppinsFamily,
                fontSize = 18.sp,
            )
        }
        // Program and Year
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_college),
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .padding(end = 8.dp)
            )
            Text(
                text = "Informatika (2021)",
                fontFamily = poppinsFamily,
                fontSize = 18.sp,
            )
        }

        // Email
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = null,
                tint = Black,
                modifier = Modifier
                    .size(30.dp)
                    .padding(end = 8.dp)
            )
            Text(
                text = "kafijaya@student.umn.ac.id",
                fontFamily = poppinsFamily,
                fontSize = 18.sp,
            )
        }

        // Logout Button
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
                .height(55.dp),
            colors = ButtonDefaults.elevatedButtonColors(
                containerColor = Color(0xFF47A7FF),
                contentColor = androidx.compose.ui.graphics.Color.White
            ),
            onClick = {
                navController.navigate(Screen.LoginScreen.route)
            }
        ) {
            Icon(
                imageVector = Icons.Default.ExitToApp,
                contentDescription = null,
                modifier = Modifier.padding(end = 4.dp)
            )
            Text(text = "Logout")
        }
    }
}
