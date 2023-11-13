package com.example.paracetamol

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.paracetamol.screen.Screen
import com.example.paracetamol.ui.theme.poppinsFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var nim by remember { mutableStateOf("") }
    var prodi by remember { mutableStateOf("") }
    var angkatan by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var repassword by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                "Register Account",
                fontSize = 32.sp,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.Black,
            )
            // TextFields for user input
            TextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Your Name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp)
                    .height(55.dp),
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
                value = nim,
                onValueChange = { nim = it },
                label = { Text("NIM") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp)
                    .height(55.dp),
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
                value = prodi,
                onValueChange = { prodi = it },
                label = { Text("Prodi") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp)
                    .height(55.dp),
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
                value = angkatan,
                onValueChange = { angkatan = it },
                label = { Text("Angkatan") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp)
                    .height(55.dp),
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
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp)
                    .height(55.dp),
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
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp)
                    .height(55.dp),
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
                value = repassword,
                onValueChange = { repassword = it },
                label = { Text("Re-enter Password") },
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp)
                    .height(55.dp),
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
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 16.dp)
                    .height(55.dp),
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = Color(0xFF47A7FF),
                    contentColor = Color.White
                ),
                onClick = { /*TODO*/ }
            ) {
                Text(
                    "Sign up",
                    fontSize = 24.sp,
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                )
            }
            TextButton(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = { navController.navigate(Screen.LoginScreen.route) }
            ) {
                Text("Already have an account?",
                    fontSize = 16.sp,
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF000000),
                )
            }
        }
    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
    RegisterScreen(navController = NavController(LocalContext.current))
}