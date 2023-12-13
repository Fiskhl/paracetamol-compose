package com.example.paracetamol.nav_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.paracetamol.CreateScreen
import com.example.paracetamol.screen.Screen
import com.example.paracetamol.ui.theme.poppinsFamily


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
            .padding(horizontal =  48.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Create or Join",
            fontSize = 30.sp,
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.Black,
        )
        Text("Come get your room to your organization",
            fontSize = 18.sp,
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            color = Color.Black,
        )
//        Button(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(top = 16.dp, bottom = 16.dp)
//                .height(55.dp),
//            colors = ButtonDefaults.elevatedButtonColors(
//                containerColor = Color(0xFF47A7FF),
//                contentColor = Color.White
//            ),
//            onClick = {
//
//            }
//        ) {
//            Text("Sign in",
//                fontSize = 24.sp,
//                fontFamily = poppinsFamily,
//                fontWeight = FontWeight.SemiBold,
//                textAlign = TextAlign.Center,
//                color = Color.White,
//            )
//        }

        Button(
            onClick = {
                navController.navigate(Screen.JoinScreen.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
                .height(55.dp),
            border = BorderStroke(2.dp, Color.Red),
//            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
            colors = ButtonDefaults.elevatedButtonColors(
                contentColor = Color.White
            ),
        ) {
            Text("Join Organization",
                color = Color.DarkGray,
                fontSize = 16.sp,
                fontFamily = poppinsFamily,)
        }


        Button(
            onClick = {
                navController.navigate(Screen.CreateScreen.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
                .height(55.dp),
            border = BorderStroke(2.dp, Color(0xFF47A7FF)),
//            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
            colors = ButtonDefaults.elevatedButtonColors(
                contentColor = Color.White
            ),
        ) {
            Text("Create Organization",
                color = Color.DarkGray,
                fontSize = 16.sp,
                fontFamily = poppinsFamily,)
        }




        }

}


@Composable
@Preview(showBackground = true)
fun SearchScreenPreview() {
    val context = LocalContext.current
    val navController = rememberNavController()
    SearchScreen(navController = navController)
}
