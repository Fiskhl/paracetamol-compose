package com.example.paracetamol.screen

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
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



data class MemberGroupAdmin(val Name: String, val total: Int)


val memberItemsAdmin = listOf(
    MemberGroupAdmin("Joshua", 100000),
    MemberGroupAdmin("Kafi", 1000000),
    MemberGroupAdmin("Jaya", 50000),
    MemberGroupAdmin("Muhammad", 10000),
    MemberGroupAdmin("Gre", 70000),
    MemberGroupAdmin("Rici", 35000),
    MemberGroupAdmin("Kalyana", 15000),
    MemberGroupAdmin("Joshua", 100000),
    MemberGroupAdmin("Kafi", 1000000),
    MemberGroupAdmin("Jaya", 50000),
    MemberGroupAdmin("Muhammad", 10000),
    MemberGroupAdmin("Gre", 70000),
    MemberGroupAdmin("Rici", 35000),
    MemberGroupAdmin("Kalyana", 15000),
    MemberGroupAdmin("Joshua", 100000),
    MemberGroupAdmin("Kafi", 1000000),
    MemberGroupAdmin("Jaya", 50000),
    MemberGroupAdmin("Muhammad", 10000),
    MemberGroupAdmin("Gre", 70000),
    MemberGroupAdmin("Rici", 35000),
    MemberGroupAdmin("Kalyana", 15000),
    MemberGroupAdmin("Joshua", 100000),
    MemberGroupAdmin("Kafi", 1000000),
    MemberGroupAdmin("Jaya", 50000),
    MemberGroupAdmin("Muhammad", 10000),
    MemberGroupAdmin("Gre", 70000),
    MemberGroupAdmin("Rici", 35000),
    MemberGroupAdmin("Kalyana", 15000),
)

@Composable
fun CardTotal(memberItems: List<MemberGroupAdmin>) {
    val totalSum = memberItemsAdmin.sumOf { it.total }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp, vertical = 7.dp),
        border = BorderStroke(1.5f.dp, Color.Red),
        shape = RoundedCornerShape(10.dp),
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
                    text = "Total :",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.Start,
                )
            }

            // Kolom Tengah
            Spacer(modifier = Modifier.weight(1f))

            // Kolom Kanan
            Column(
                modifier = Modifier.width(180.dp)
                    .padding(end = 0.dp)
                    .padding(8.dp), // Padding di kanan diatur menjadi 0.dp
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End
            ) {
                val formattedTotal = NumberFormat.getCurrencyInstance(Locale("id", "ID")).format(totalSum)
                Text(
                    text = formattedTotal,
                    fontSize = 10.sp,
                    color = Color.Black.copy(alpha = 0.5f),
                    textAlign = TextAlign.End,
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardMemberAdmin(member: MemberGroupAdmin, navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp, vertical = 7.dp),
        border = BorderStroke(1.5f.dp, Color.Red),
        shape = RoundedCornerShape(10.dp),
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
                    text = member.Name,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.Start,
                )
            }

            // Kolom Tengah
            Spacer(modifier = Modifier.weight(1f))

            // Kolom Kanan
            Column(
                modifier = Modifier.width(180.dp)
                    .padding(end = 0.dp)
                    .padding(8.dp), // Padding di kanan diatur menjadi 0.dp
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End
            ) {
                val formattedTotal = NumberFormat.getCurrencyInstance(Locale("id", "ID")).format(member.total)
                Text(
                    text = "Total: $formattedTotal",
                    fontSize = 10.sp,
                    color = Color.Black.copy(alpha = 0.5f),
                    textAlign = TextAlign.End,
                )
            }
        }
    }
}


@Composable
fun MemberScrollContentAdmin(innerPadding: PaddingValues, navController: NavController) {
    val hasData = memberItemsAdmin.isNotEmpty()

    LazyColumn(
        contentPadding = innerPadding,
        modifier = Modifier.fillMaxSize(),
    ) {
        if (hasData) {
            items(memberItemsAdmin) { item ->
                CardMemberAdmin(member = item, navController = navController)
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
                        "No Members",
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
fun AdminMemberListScreen(
    title: String,
    description: String,
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
                onClick = { navController.navigateUp() },
                modifier = Modifier
                    .padding(end = 1.dp),
            ) {
                Icon(Icons.Default.Group, contentDescription = "Group")
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
//        MemberScrollContentAdmin(innerPadding = PaddingValues(16.dp), navController = navController)

        //Floating Button
        val fabSize = 56.dp
        val fabMargin = 16.dp

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomEnd
        ) {
//            CardTotal(memberItemsAdmin)

            MemberScrollContentAdmin(innerPadding = PaddingValues(16.dp), navController = navController)

            FloatingActionButton(
                onClick = { /* Action saat tombol ditekan */ },
                modifier = Modifier
                    .padding(fabMargin)
                    .size(fabSize)
                    .shadow(8.dp, CircleShape)
                    .background(Color.White)
                    .align(Alignment.BottomEnd),
                content = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            tint = Color.Gray
                        )
                    }
                }
            )
        }

    }
}


@Composable
@Preview(showBackground = true)
fun AdminMemberListScreenPreview() {
    val navController = rememberNavController()
    AdminMemberListScreen(
        "MAXIMA 2023",
        "Explore The World Reach New Potentials",
        navController = navController
    )
}