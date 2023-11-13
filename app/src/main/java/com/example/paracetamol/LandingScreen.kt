package com.example.paracetamol

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.paracetamol.screen.Screen
import com.example.paracetamol.ui.theme.poppinsFamily


@Composable
fun LandingScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
            .padding(horizontal =  48.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Let's join us and Take Control of Your Fines Better!",
            fontSize = 32.sp,
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.Black,
        )
        Image(
            modifier = Modifier
                .padding(top = 32.dp, bottom = 32.dp)
                .fillMaxWidth(),
            painter = painterResource(id = R.drawable.ic_mainscreen),
            contentDescription = stringResource(id = R.string.content_description),
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp),
            colors = ButtonDefaults.elevatedButtonColors(
                containerColor = Color(0xFF001E2C),
                contentColor = Color.White
            ),
            onClick = {
                navController.navigate(Screen.LoginScreen.route)}
        ) {
            Text("Start now!",
                fontSize = 24.sp,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                color = Color.White,
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun LandingScreenPreview() {
    LandingScreen(navController = NavController(LocalContext.current))
}