package com.example.paracetamol

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.paracetamol.component.showToast
import com.example.paracetamol.model.LoginViewModel
import com.example.paracetamol.screen.Screen
import com.example.paracetamol.ui.theme.poppinsFamily
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController, onLoggedIn: () -> Unit) {
    var emailTextState by rememberSaveable {
        mutableStateOf("")
    }

    var passwordTextState by rememberSaveable {
        mutableStateOf("")
    }

    val context = LocalContext.current

    val loginViewModel: LoginViewModel = viewModel { LoginViewModel(context) }

    val loginSuccess by loginViewModel.loginSuccess.observeAsState()
    loginSuccess?.let { success ->
        if (success) {
            onLoggedIn()
        }
    }

    val errorMessage by loginViewModel.errorMessage.observeAsState()
    errorMessage?.let {
        showToast(context, it)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
            .padding(horizontal = 48.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("CHAMPBERLAIN",
            fontSize = 32.sp,
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.Black,
        )
        Image(
            modifier = Modifier
                .width(150.dp)
                .height(150.dp),
            painter = painterResource(id = R.drawable.ic_mainscreen),
            contentDescription = stringResource(id = R.string.content_description),
        )
        Text("Log in to your Champberlain account",
            modifier = Modifier
                .padding(bottom = 30.dp),
            fontSize = 16.sp,
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            color = Color.Black,
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 14.dp),
            value = emailTextState,
            onValueChange = {
                emailTextState = it
            },
            placeholder = {
                Text(
                    text = "Email",
                    fontSize = 14.sp,
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
            trailingIcon = {
                if (emailTextState.isNotEmpty()) {
                    IconButton(onClick = { emailTextState = "" }) {
                        Icon(
                            imageVector = Icons.Outlined.Close,
                            contentDescription = null
                        )
                    }
                }
            }
        )

        var showPassword by remember { mutableStateOf(value = false) }

        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = passwordTextState,
            onValueChange = {
                passwordTextState = it
            },
            placeholder = {
                Text(
                    text = "Password",
                    fontSize = 14.sp,
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
            visualTransformation = if (showPassword) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                if (showPassword) {
                    IconButton(onClick = { showPassword = false }) {
                        Icon(
                            imageVector = Icons.Filled.Visibility,
                            contentDescription = "hide_password"
                        )
                    }
                } else {
                    IconButton(
                        onClick = { showPassword = true }) {
                        Icon(
                            imageVector = Icons.Filled.VisibilityOff,
                            contentDescription = "hide_password"
                        )
                    }
                }
            }
        )


        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
                .height(55.dp),
            border = BorderStroke(2.dp, Color(0xFF47A7FF)),
            colors = ButtonDefaults.elevatedButtonColors(
                contentColor = Color.White
            ),
            onClick = {
                if (emailTextState.isNotBlank() && passwordTextState.isNotBlank()) {
                    loginViewModel.login(emailTextState, passwordTextState)
                } else {
                    showToast(context, "Email or password cannot be empty.")
                }
            }
        ) {
            Text("Sign in",
                color = Color.DarkGray,
                fontSize = 16.sp,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
            )
        }
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Don’t have an account?",
                fontSize = 16.sp,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                color = Color(0xFF000000),
            )
            TextButton(
                modifier = Modifier,
                onClick = { navController.navigate(Screen.RegisterScreen.route) }
            ) {
                Text(
                    "Sign Up here",
                    fontSize = 16.sp,
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF47A7FF),
                )
            }
        }

    }
}