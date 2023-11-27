package com.example.paracetamol

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.gson.Gson

@Composable
fun AdminMemberDetailsScreen(name: String, studentId: String, navController: NavController) {
    // Your details screen UI
    // You can use the received name and studentId to display details
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFFFFFFF))
        .padding(horizontal = 48.dp)
        .padding(top = 20.dp, bottom = 20.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ){
            Text(text = "$name", fontSize = 30.sp)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Green)
        ){
            Text(text = "$studentId", Modifier.padding(top = 4.dp), fontSize = 15.sp)
        }
        Spacer(modifier = Modifier.height(100.dp))
        DetailDendaMember()
        TotalDendaDetail()
    }
}

@Composable
fun TotalDendaDetail() {
    val jsonString = """
        {
            "members": [
                {"hari": "John Doe", "desc": "12345", "nominal" : "15000"},
                {"hari": "John Doe", "desc": "12345", "nominal" : "15000"},
                {"hari": "John Doe", "desc": "12345", "nominal" : "15000"},
                {"hari": "John Doe", "desc": "12345", "nominal" : "15000"},
                {"hari": "John Doe", "desc": "12345", "nominal" : "15000"},
                {"hari": "John Doe", "desc": "12345", "nominal" : "15000"},
                {"hari": "John Doe", "desc": "12345", "nominal" : "15000"},
            ]
        }
    """.trimIndent()

    val detailDenda = Gson().fromJson(jsonString, DendasApiResponse::class.java).members

    Row(
        modifier = Modifier
            .background(color = Color.Red)
            .fillMaxWidth()
    ) {
//        // Check if detailDenda is not null
//        if (detailDenda != null) {
//            // Calculate total nominal only if detailDenda is not null and not empty
//            if (detailDenda.isNotEmpty()) {
//                // Calculate total nominal
//                val totalNominal = detailDenda.sumOf { it.nominal.toIntOrNull() ?: 0 }
//
//                // Display the total nominal
//                Text(text = "Total Nominal: $totalNominal")
//            } else {
//                // Handle the case where detailDenda is empty
//                Text(text = "Detail Denda is empty")
//            }
//        } else {
//            // Handle the case where detailDenda is null
//            Text(text = "Detail Denda is null")
//        }
        Text(text = "total dendanya segini mas")
    }
}
@Composable
fun DetailDendaMember(){
    LazyColumn(
        modifier = Modifier
            .background(color = Color.Green)
            .fillMaxWidth()
            .height(500.dp)
            .padding(horizontal = 16.dp)
    ) {
        val jsonString = """
                    {
                        "members": [
                            {"hari": "hari1", "desc": "12345", "nominal" : "15000"},
                            {"hari": "hari2", "desc": "12345", "nominal" : "15000"},
                            {"hari": "hari3", "desc": "12345", "nominal" : "15000"},
                            {"hari": "hari4", "desc": "12345", "nominal" : "15000"},
                            {"hari": "hari4", "desc": "12345", "nominal" : "15000"},
                            {"hari": "hari5", "desc": "12345", "nominal" : "15000"},
                            {"hari": "hari5", "desc": "12345", "nominal" : "15000"},
                        ]
                    }
                """.trimIndent()
        val detailDenda = Gson().fromJson(jsonString, DendasApiResponse::class.java).members

        items(detailDenda) { denda ->
            DendaCard(denda = denda)
            Spacer(modifier = Modifier.height(3.dp))
        }
    }
}

data class Denda(val hari: String, val desc: String, val nominal: String)

data class DendasApiResponse(val members: List<Denda>)
@Composable
fun DendaCard(denda: Denda?) {
    if (denda != null) {
        // Display details for each member in a card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { /* Handle card click if needed */ }
                .padding(5.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(text = "Hari: ${denda.hari}")
                Text(text = "Description: ${denda.desc}")
                Text(text = "Nominal: ${denda.nominal}")

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    // Eye icon
                    Icon(
                        Icons.Filled.Search,
                        contentDescription = null,
                        modifier = Modifier
                            .size(28.dp)
                            .padding(end = 8.dp)
                    )

                    // Trash icon
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp)
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    device = "id:pixel_7_pro"
)
fun AdminMemberDetailScreenPreview() {
    AdminMemberDetailsScreen(name = "John Doe", studentId = "29382190",navController = NavController(LocalContext.current))
}