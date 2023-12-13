package com.example.paracetamol.nav_screen


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.paracetamol.Student
import com.example.paracetamol.screen.Screen
import com.example.paracetamol.ui.theme.poppinsFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppToolbar(navController: NavController) {
    Scaffold() { innerPadding ->
        ScrollContent(innerPadding, navController)
    }
}


data class GroupData(val title: String, val description: String)

// ganti api
val sampleItems = listOf(
    GroupData("MAXIMA 2023", "Explore The World Reach New Potentials"),
    GroupData("UMN ECO 2023", "We Act for The Better Earth"),
    GroupData("UMN Festival 2023", "Devote Yourself to be a True Spartan"),
    GroupData("STARLIGHT 2023", "With us you can be a Star"),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardItem(group: GroupData, navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp, vertical = 7.dp),
        border = BorderStroke(2.dp, Color(0xFF8E99A2)),
        shape = RoundedCornerShape(12.dp),
        color = Color.White,
        onClick = {
            navController.navigate("${Screen.UserGroupScreen.route}/${group.title}/${group.description}")
        }

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(22.dp),
            verticalArrangement = Arrangement.Center,

            ) {
            Text(
                text = group.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp, start = 20.dp),
                color = Color.Black,
                textAlign = TextAlign.Start,
            )
            Text(
                text = group.description,
                fontSize = 14.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp),
                color = Color.Black,
                textAlign = TextAlign.Start,
            )
        }
    }
}





@Composable
fun ScrollContent(innerPadding: PaddingValues, navController: NavController) {
    LazyColumn(
        contentPadding = innerPadding,
        modifier = Modifier.fillMaxSize(),
    ) {
        items(sampleItems) { item ->
            CardItem(group = item, navController = navController)
        }
    }
}




@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            "HOME",
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = 35.dp),
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        AppToolbar(navController = navController)
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = NavController(LocalContext.current))
}
