package com.example.paracetamol.screen.admin

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.paracetamol.screen.CardTotal
import com.example.paracetamol.screen.DendaScrollContent
import com.example.paracetamol.screen.MemberScrollContentAdmin
import com.example.paracetamol.screen.Screen
import com.example.paracetamol.ui.theme.poppinsFamily
import com.google.gson.Gson
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class DendaDataUser(val title: String, val description: String, val status: Int, val total: Int, val due: Date)

val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

val dendaItem = listOf(
    DendaDataUser("Salah Rici", "Salah Rici", 1, 30000, dateFormat.parse("2024-12-05")),
    DendaDataUser("Rici yang Salah", "Karena ada rici", 0, 5000, dateFormat.parse("2024-09-15")),
    DendaDataUser("Semua karena rici", "Rici nomor 1", 0, 50000, dateFormat.parse("2024-01-25")),
    DendaDataUser("Rici kamu jahat", "Tanggung jawab rici", 0, 150000, dateFormat.parse("2024-04-05")),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardDendaUser(denda: DendaDataUser, navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp, vertical = 7.dp),
        border = BorderStroke(2.dp, Color.Red),
        shape = RoundedCornerShape(12.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Kolom Kiri
            Column(
                modifier = Modifier.width(180.dp), // Lebar tetap untuk kolom kiri
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    text = denda.title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.Start,
                )
                Text(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    text = denda.description,
                    fontSize = 11.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Start,
                )
                Text(
                    text = "Due: ${dateFormat.format(denda.due)}",
                    modifier = Modifier.padding(horizontal = 10.dp),
                    fontSize = 10.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Start,
                )
            }

            // Kolom Tengah
            Spacer(modifier = Modifier.weight(1f))

            // Kolom Kanan
            Column(
                modifier = Modifier.width(180.dp)
                    .padding(end = 0.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End
            ) {
                val formattedTotal = NumberFormat.getCurrencyInstance(Locale("id", "ID")).format(denda.total)
                Text(
                    text = "Total: $formattedTotal",
                    fontSize = 10.sp,
                    color = Color.Black.copy(alpha = 0.7f),
                    textAlign = TextAlign.End,
                )
                // Button pakai status
                val buttonText = if (denda.status == 1) "Done" else "Pending"
                val buttonEnabled = true

                Button(
                    onClick = {  },
                    enabled = buttonEnabled,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp, bottom = 5.dp)
                        .height(30.dp),
                    border = BorderStroke(1.dp, if (denda.status == 1) Color.Black else Color.Blue), // Warna border berdasarkan status
                    colors = ButtonDefaults.elevatedButtonColors(
                        contentColor = Color.White
                    ),
                ) {
                    Text(
                        buttonText,
                        color = if (denda.status == 1) Color.Black else Color.DarkGray, // Warna teks tombol berdasarkan status
                        fontSize = 10.sp,
                        fontFamily = poppinsFamily,
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth().padding(top = 2.dp),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit",
                        tint = Color.Black,
                        modifier = Modifier
                            .size(20.dp) // Ukuran untuk ikon Edit
                            .clickable { navController.navigate(Screen.PayScreen.route) }
                    )

                    Spacer(modifier = Modifier.width(15.dp))

                    Icon(
                        imageVector = Icons.Default.Visibility,
                        contentDescription = "See",
                        tint = Color.Black,
                        modifier = Modifier
                            .size(20.dp) // Ukuran untuk ikon Edit
                            .clickable { navController.navigate(Screen.AdminPaidScreen.route) }
                    )
                }

            }
        }
    }
}



@Composable
fun DendaUserScrollContent(innerPadding: PaddingValues, navController: NavController) {
    val context = LocalContext.current

    val hasData = dendaItem.isNotEmpty()

    LazyColumn(
        contentPadding = innerPadding,
        modifier = Modifier.fillMaxSize(),
    ) {
        if (hasData) {
            items(dendaItem) { item ->
                CardDendaUser(denda = item, navController = navController)
            }
        } else {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        "No Fines",
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = 280.dp),
                        fontSize = 14.sp,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                    )
                }
            }
        }
    }
}


@Composable
fun AdminMemberDetailScreen(
    title: String,
    description: String,
    name: String,
    navController: NavController
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
            text = title,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Fine Information",
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
                text = name,
                modifier = Modifier.padding(top = 4.dp),
                fontSize = 12.sp
            )
        }
        DendaUserScrollContent(innerPadding = PaddingValues(16.dp), navController = navController)
    }
}


@Composable
@Preview(showBackground = true)
fun AdminMemberDetailScreenPreview() {
    val navController = rememberNavController()
    AdminMemberDetailScreen(
        "MAXIMA 2023",
        "Explore The World Reach New Potentials",
        "Joshua",
        navController = navController
    )
}