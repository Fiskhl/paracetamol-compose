package com.example.paracetamol.screen.admin

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.paracetamol.component.DialogUI
import com.example.paracetamol.component.showToast
import com.example.paracetamol.model.UserViewModel
import com.example.paracetamol.screen.AdminMemberListScreen
import com.example.paracetamol.screen.Screen
import com.example.paracetamol.ui.theme.poppinsFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminNewDendaScreen(
    titleA: String,
    descriptionA: String,
    navController: NavController
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var due by remember { mutableStateOf("") }
    var value by remember { mutableStateOf("") }
    var assign by remember { mutableStateOf("") }

    val context = LocalContext.current

    val userViewModel: UserViewModel = viewModel { UserViewModel(context) }

    val registerSuccess by userViewModel.registerSuccess.observeAsState()
    registerSuccess?.let { success ->
        if (success) {
            Log.d("RegisterScreen", "Register Success!")
            DialogUI(
                title = "Registration Successful",
                desc = "Your account has been successfully registered."
            )
        }
    }

    val errorMessage by userViewModel.errorMessage.observeAsState()
    errorMessage?.let {
        showToast(context, it)
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
//            .padding(horizontal = 16.dp)
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
                text = titleA,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Add Fine",
                    modifier = Modifier.padding(top = 4.dp),
                    fontSize = 12.sp
                )
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 25.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                TextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Title") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 35.dp, bottom = 5.dp)
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
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Description") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp, bottom = 5.dp)
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
                    value = due,
                    onValueChange = { due = it },
                    label = { Text("Due Date") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp, bottom = 5.dp)
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
                    value = value,
                    onValueChange = { value = it },
                    label = { Text("Value") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp, bottom = 5.dp)
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
                    value = assign,
                    onValueChange = { assign = it },
                    label = { Text("Assign") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp, bottom = 5.dp)
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
                    border = BorderStroke(2.dp, Color(0xFF47A7FF)),
                    colors = ButtonDefaults.elevatedButtonColors(
                        contentColor = Color.White
                    ),
                    onClick = { /* Isi disini */ }
                ) {
                    Text(
                        "Add Fine",
                        fontSize = 16.sp,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center,
                        color = Color.DarkGray,
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun AdminNewDendaScreenPreview() {
    val navController = rememberNavController()
    AdminNewDendaScreen(
        "MAXIMA 2023",
        "Explore The World Reach New Potentials",
        navController = navController
    )
}