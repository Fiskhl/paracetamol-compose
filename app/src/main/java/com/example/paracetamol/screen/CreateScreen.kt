package com.example.paracetamol.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Close
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.paracetamol.R
import com.example.paracetamol.ui.theme.poppinsFamily

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateScreen(navController: NavController) {

    val context = LocalContext.current

//    var fullName by rememberSaveable { mutableStateOf(TextFieldValue()) }
//    var organization by rememberSaveable { mutableStateOf(TextFieldValue()) }
//    var referralCode by rememberSaveable { mutableStateOf(TextFieldValue()) }
//
//    val isButtonEnabled by derivedStateOf {
//        fullName.text.isNotEmpty() && organization.text.isNotEmpty() && referralCode.text.isNotEmpty()
//    }
    var textState by rememberSaveable {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .width(100.dp)
            .background(Color(0xFFFFFFFF))
            .padding(horizontal = 16.dp)
            .padding(top = 23.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
        ) {
            val backButtonIcon: Painter =
                painterResource(id = R.drawable.ic_back) // back

            Image(
                painter = backButtonIcon,
                contentDescription = "Back",
                modifier = Modifier
                    .size(34.dp)
                    .padding(start = 17.dp)
                    .clickable { navController.navigateUp() }
            )

        }


        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFFFFFF))
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Create Room",
                fontSize = 32.sp,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.Black,
            )
            Text(
                "You can create your room and share it to your group",
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
                        text = "Organization Name",
                        fontSize = 16.sp,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF4B4B4B),
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(0xFFF1F8FF),
                    cursorColor = Color.Black,
                    disabledLabelColor = Color(0xFFF1F8FF),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(8.dp),
                singleLine = true,
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
                        text = "Description",
                        fontSize = 16.sp,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF4B4B4B),
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(0xFFF1F8FF),
                    cursorColor = Color.Black,
                    disabledLabelColor = Color(0xFFF1F8FF),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(8.dp),
                singleLine = true,
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
                    containerColor = Color(0xFFF1F8FF),
                    cursorColor = Color.Black,
                    disabledLabelColor = Color(0xFFF1F8FF),
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
//            enabled = isButtonEnabled,
                border = BorderStroke(2.dp, Color(0xFF47A7FF)),
                colors = ButtonDefaults.elevatedButtonColors(
                    contentColor = Color.White
                ),
            ) {
                Text(
                    "Create Room",
                    color = Color.DarkGray,
                    fontSize = 16.sp,
                    fontFamily = poppinsFamily,
                )
            }


        }
    }
}

@Composable
@Preview(showBackground = true)
fun CreateScreenPreview() {
    val context = LocalContext.current
    val navController = rememberNavController()
    CreateScreen(navController = navController)
}
