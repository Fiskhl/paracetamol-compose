package com.example.paracetamol.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Group
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.paracetamol.nav_screen.ArchiveScrollContent
import com.example.paracetamol.nav_screen.CardArchiveItem
import com.example.paracetamol.ui.theme.poppinsFamily
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


data class DendaData(val title: String, val description: String, val status: Int, val total: Int, val due: Date)

val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

val dendaItem = listOf(
    DendaData("Salah Rici", "Salah Rici", 1, 30000, dateFormat.parse("2024-12-05")),
    DendaData("Rici yang Salah", "Karena ada rici", 0, 5000, dateFormat.parse("2024-09-15")),
    DendaData("Semua karena rici", "Rici nomor 1", 0, 50000, dateFormat.parse("2024-01-25")),
    DendaData("Rici kamu jahat", "Tanggung jawab rici", 0, 150000, dateFormat.parse("2024-04-05")),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardDenda(denda: DendaData, navController: NavController) {
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
            }

            // Kolom Tengah
            Spacer(modifier = Modifier.weight(1f))

            // Kolom Kanan
            Column(
                modifier = Modifier.width(180.dp)
                    .padding(end = 0.dp), // Padding di kanan diatur menjadi 0.dp
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
                val buttonText = if (denda.status == 1) "Paid" else "Pay"
                val buttonEnabled = denda.status == 0

                Button(
                    onClick = { /* */ },
                    enabled = buttonEnabled,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp, bottom = 5.dp)
                        .height(30.dp),
                    border = if (denda.status == 1) null else BorderStroke(1.dp, Color.Blue),
                    colors = ButtonDefaults.elevatedButtonColors(
                        contentColor = Color.White
                    ),
                ) {
                    Text(buttonText,
                        color = Color.DarkGray,
                        fontSize = 10.sp,
                        fontFamily = poppinsFamily,)
                }
                Text(
                    text = "Due: ${dateFormat.format(denda.due)}",
                    fontSize = 10.sp,
                    color = Color.Black,
                    textAlign = TextAlign.End,
                )
            }
        }
    }
}



@Composable
fun DendaScrollContent(innerPadding: PaddingValues, navController: NavController) {
    val context = LocalContext.current

    val hasData = dendaItem.isNotEmpty()

//    // Observe the LiveData and update the local variable
//    userViewModel.profileData.observeAsState().value?.let {
//        profileData = it
//    }

    LazyColumn(
        contentPadding = innerPadding,
        modifier = Modifier.fillMaxSize(),
    ) {
        if (hasData) {
            items(dendaItem) { item ->
                CardDenda(denda = item, navController = navController)
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
fun UserGroupScreen(
    titleA: String,
    descriptionA: String,
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
            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                onClick = {
                    navController.navigate("${Screen.MemberGroupScreen.route}/${titleA}/${descriptionA}")
                },
                modifier = Modifier
                    .padding(end = 1.dp),
            ) {
            Icon(Icons.Default.Group, contentDescription = "Group")
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
                text = descriptionA,
                modifier = Modifier.padding(top = 4.dp),
                fontSize = 12.sp
            )
        }
        DendaScrollContent(innerPadding = PaddingValues(16.dp), navController = navController)
    }
}



@Composable
@Preview(showBackground = true)
fun UserGroupScreenPreview() {
    val navController = rememberNavController()
    UserGroupScreen(
        "MAXIMA 2023",
        "Explore The World Reach New Potentials",
        navController = navController
    )
}