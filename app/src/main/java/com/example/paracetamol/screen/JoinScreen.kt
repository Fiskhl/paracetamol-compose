package com.example.paracetamol.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
import com.example.paracetamol.ui.theme.poppinsFamily

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JoinScreen(navController: NavController) {

    val context = LocalContext.current

    var textState by rememberSaveable {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
            .padding(horizontal =  48.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Join Room",
            fontSize = 32.sp,
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.Black,
        )
        Text("Give me your code and i will give your group",
            fontSize = 20.sp,
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 30.dp)
        )


        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            value = textState,
            onValueChange = {
                textState = it
            },
            placeholder = {
                Text(
                    text = "Referral Code",
                    fontSize = 16.sp,
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF4B4B4B),
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFFFF1F1),
                cursorColor = Color.Black,
                disabledLabelColor = Color(0xFFFFF1F1),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(8.dp),
            singleLine = true,
        )


        Button(
            onClick = {
                navController.navigate(Screen.SearchScreen.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
                .height(55.dp),
            border = BorderStroke(2.dp, Color.Red),
            colors = ButtonDefaults.elevatedButtonColors(
                contentColor = Color.White
            ),
        ) {
            Text("Join Room",
                color = Color.DarkGray,
                fontSize = 16.sp,
                fontFamily = poppinsFamily,)
        }


    }
}

@Composable
@Preview(showBackground = true)
fun JoinScreenPreview() {
    val context = LocalContext.current
    val navController = rememberNavController()
    JoinScreen(navController = navController)
}
