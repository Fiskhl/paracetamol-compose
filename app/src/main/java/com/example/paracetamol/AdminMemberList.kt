package com.example.paracetamol

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.paracetamol.ui.theme.poppinsFamily
import com.google.gson.Gson

@Composable
fun AdminMemberListScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
            .padding(horizontal = 25.dp)
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
//            Text(text = "UMN ECO 2023", fontSize = 36.sp)
            Text("UMN ECO 2023",
                fontSize = 32.sp,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 30.dp)
            )
        }
        TotalDendaSection()
        MembersSection(navController)
    }
}

@Composable
fun TotalDendaSection() {
    Row(
        modifier = Modifier
//            .background(color = Color.Yellow)
            .fillMaxWidth()
            .height(50.dp),
        verticalAlignment = Alignment.Bottom,
    ) {
        Box(
            modifier = Modifier
//                .background(color = Color.LightGray)
                .size(150.dp, 50.dp)
        ){
            Column {
                Text("Total denda",
                    fontSize = 14.sp,
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                )
                Text("Rp. 100.000,00",
                    fontSize = 14.sp,
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                )

            }
        }
    }
}

@Composable
fun AddDendaSection() {
    SmallFloatingActionButton(
        onClick = {},
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
        contentColor = MaterialTheme.colorScheme.secondary
    ) {
        Icon(Icons.Filled.Add, "Small floating action button.")
    }
}

@Composable
fun MembersSection(navController: NavController) {
    LazyColumn(
        modifier = Modifier
//            .background(color = Color.Green)
            .fillMaxWidth()
            .height(680.dp)
            .padding(horizontal = 16.dp)
    ) {
        val jsonString = """
                    {
                        "members": [
                            {"name": "John Doe", "studentid": "12345"},
                            {"name": "Jane Doe", "studentid": "67890"},
                            {"name": "Gregory Kurniawan", "studentid": "12345"},
                            {"name": "Kafijaya", "studentid": "67890"},
                            {"name": "Bryan Richie", "studentid": "12345"},
                            {"name": "Joshua Hotama", "studentid": "67890"},
                            {"name": "wkwkwk", "studentid": "12345"},
                            {"name": "heheh", "studentid": "67890"}
                        ]
                    }
                """.trimIndent()
        val members = Gson().fromJson(jsonString, MembersApiResponse::class.java).members

        items(members) { member ->
            MemberCard(member = member, navController = navController)
            Spacer(modifier = Modifier.height(3.dp))
        }
    }
    AddDendaSection()
}

data class Student(val name: String, val studentid: String)

data class MembersApiResponse(val members: List<Student>)

@Composable
fun MemberCard(member: Student, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                navController.navigate("admin_member_detail/${member.name}/${member.studentid}")
            }
            .padding(5.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFFFF1))
                .padding(16.dp)
        ) {
            Text(text = "Name: ${member.name}",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = poppinsFamily)
            Text(text = "Student ID: ${member.studentid}",
                Modifier.padding(top = 4.dp),
                fontSize = 14.sp,
                fontFamily = poppinsFamily)
        }
    }
}

@Composable
@Preview(showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    device = "id:pixel_7_pro"
)
fun AdminMemberListScreenPreview() {
    AdminMemberListScreen(navController = NavController(LocalContext.current))
}
