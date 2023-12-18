package com.example.paracetamol.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Group
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.paracetamol.ui.theme.poppinsFamily


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PayScreen(
    titleA: String,
    descriptionA: String,
    navController: NavController
) {

    var proofLink by remember { mutableStateOf("") }

    // Mengecek apakah nilai TextField tidak kosong
    val isProofLinkNotEmpty by remember {
        derivedStateOf {
            proofLink.isNotEmpty()
        }
    }

    val buttonLabel = if (isProofLinkNotEmpty) "Edit" else "Send"

    Column(
        modifier = Modifier
            .fillMaxSize()
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
                text = "Send Proof",
                modifier = Modifier.padding(top = 4.dp),
                fontSize = 12.sp
            )
        }
        TextField(
            value = proofLink,
            onValueChange = { proofLink = it },
            label = { Text("Proof Link") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 35.dp, bottom = 5.dp)
                .padding(horizontal = 35.dp)
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
            onClick = { /* ISI SENDIRI WOI */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp, bottom = 16.dp)
                .padding(horizontal = 35.dp)
                .height(55.dp),
            border = BorderStroke(2.dp, Color.Red),
            colors = ButtonDefaults.elevatedButtonColors(
                contentColor = Color.White
            ),
        ) {
            Text(
                buttonLabel,
                color = Color.DarkGray,
                fontSize = 16.sp,
                fontFamily = poppinsFamily,
            )
        }
    }
}



@Composable
@Preview(showBackground = true)
fun PayScreenPreview() {
    val navController = rememberNavController()
    PayScreen(
        "STARLIGHT 2023",
        "Explore The World Reach New Potentials",
        navController = navController
    )
}