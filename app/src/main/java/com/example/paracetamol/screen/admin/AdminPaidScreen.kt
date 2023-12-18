package com.example.paracetamol.screen.admin

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
fun AdminPaidScreen(
    titleA: String,
    descriptionA: String,
    navController: NavController
) {

    var proofLink by remember { mutableStateOf("Di sini ada link nanti ya muehehehehehhe") }

    // Mengecek apakah nilai TextField tidak kosong
    val isProofLinkNotEmpty by remember {
        derivedStateOf {
            proofLink.isNotEmpty()
        }
    }



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
        Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
        ) {
        Text(
            text = "Name Profile",
            modifier = Modifier.padding(top = 4.dp),
            fontSize = 12.sp
        )
        }
        TextField(
            value = proofLink,
            onValueChange = {  },
            label = { Text("Proof Link") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 35.dp, bottom = 5.dp)
                .padding(horizontal = 35.dp)
                .height(55.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFF1F8FF),
                cursorColor = Color.Black,
                disabledLabelColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            shape = RoundedCornerShape(8.dp),
            singleLine = true,
            enabled = false
        )
    }
}



@Composable
@Preview(showBackground = true)
fun AdminPaidScreenPreview() {
    val navController = rememberNavController()
    AdminPaidScreen(
        "STARLIGHT 2023",
        "Explore The World Reach New Potentials",
        navController = navController
    )
}