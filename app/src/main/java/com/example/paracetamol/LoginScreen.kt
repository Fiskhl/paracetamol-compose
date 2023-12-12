package com.example.paracetamol

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current

    val loginViewModel: LoginViewModel = viewModel { LoginViewModel(context) }

    var emailTextState by rememberSaveable {
        mutableStateOf("")
    }

    var passwordTextState by rememberSaveable {
        mutableStateOf("")
    }

    val loginResult by loginViewModel.loginSuccess.observeAsState()
    loginResult?.let { success ->
        if (success) {
            navController.navigate(Screen.HomeScreen.route)
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
        Text("Login here",
            fontSize = 32.sp,
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.Black,
        )
        Text("It's good to see you again! Welcome back!",
            fontSize = 20.sp,
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            color = Color.Black,
        )
        Image(
            modifier = Modifier
                .padding(top = 30.dp, bottom = 30.dp)
                .width(200.dp)
                .height(200.dp),
            painter = painterResource(id = R.drawable.ic_mainscreen),
            contentDescription = stringResource(id = R.string.content_description),
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            value = emailTextState,
            onValueChange = {
                emailTextState = it
            },
            placeholder = {
                Text(
                    text = "Email",
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
            visualTransformation = PasswordVisualTransformation(),
            trailingIcon = {
                if (passwordTextState.isNotEmpty()) {
                    IconButton(onClick = { passwordTextState = "" }) {
                        Icon(
                            imageVector = Icons.Outlined.Close,
                            contentDescription = null
                        )
                    }
                }
            }
        )

        TextButton(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = { /*TODO*/ }
        ) {
            Text("Forgot password?",
                modifier = Modifier
                    .fillMaxWidth(),
                fontSize = 16.sp,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.End,
                color = Color(0xFF000000),
            )
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
                .height(55.dp),
            colors = ButtonDefaults.elevatedButtonColors(
                containerColor = Color(0xFF47A7FF),
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
            onClick = { navController.navigate(Screen.RegisterScreen.route) }
        ) {
            Text("Create new account",
                fontSize = 16.sp,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                color = Color(0xFF000000),
            )
        }
    }
}