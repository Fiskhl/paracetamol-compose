package com.example.paracetamol

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.gson.Gson

@Composable
fun AdminMemberListScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
            .padding(horizontal = 48.dp)
            .padding(top = 20.dp, bottom = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .background(color = Color.Red)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "UMN ECO 2023", fontSize = 36.sp)
        }
        Row (
            modifier = Modifier
                .background(color = Color.Blue)
                .fillMaxWidth()
        ){
            TotalDendaSection()
            Spacer(modifier = Modifier.width(15.dp))
            AddDendaSection()
        }
        MembersSection()
    }
}

@Composable
fun TotalDendaSection() {
    Row(
        modifier = Modifier
            .background(color = Color.Yellow)
            .width(150.dp)
            .height(100.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .background(color = Color.LightGray)
                .size(150.dp, 50.dp)
                .clip(shape = RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))
        ){
            Column {
                Text(text = "Total denda")
                Text(text = "Rp. 100.000,00")
            }
        }
    }
}

@Composable
fun AddDendaSection() {
    Row(
        modifier = Modifier
            .background(color = Color.Cyan)
            .width(150.dp)
            .height(100.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .background(color = Color.LightGray)
                .size(80.dp, 50.dp)
                .clip(shape = RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))
        ){
            Column {
                Text(text = "Add denda")
            }
        }
    }
}

@Composable
fun MembersSection() {
    LazyColumn(
        modifier = Modifier
            .background(color = Color.Green)
            .fillMaxWidth()
            .fillMaxHeight()
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
            MemberCard(member = member)
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

data class Student(val name: String, val studentid: String)

data class MembersApiResponse(val members: List<Student>)

@Composable
fun MemberCard(member: Student) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* Handle card click if needed */ }
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = "Name: ${member.name}", fontWeight = FontWeight.Bold)
            Text(text = "Student ID: ${member.studentid}", Modifier.padding(top = 4.dp))
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
