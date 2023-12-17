package com.example.paracetamol.nav_screen


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.paracetamol.model.UserViewModel
//import com.example.paracetamol.Student
import com.example.paracetamol.screen.Screen
import com.example.paracetamol.ui.theme.poppinsFamily
import androidx.compose.ui.Alignment

data class ArchiveGroupData(val title: String, val description: String)

// ganti api
//val archiveSampleItems = emptyList<ArchiveGroupData>()
val archiveSampleItems = listOf(
    ArchiveGroupData("MAXIMA 2021", "Explore The World Reach New Potentials"),
    ArchiveGroupData("UMN ECO 2021", "We Act for The Better Earth"),
    ArchiveGroupData("UMN Festival 2021", "Devote Yourself to be a True Spartan"),
    ArchiveGroupData("STARLIGHT 2021", "With us you can be a Star"),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardArchiveItem(group: ArchiveGroupData, navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp, vertical = 7.dp),
        border = BorderStroke(2.dp, Color(0xFF8E99A2)),
        shape = RoundedCornerShape(12.dp),
        color = Color.White.copy(alpha = 0.7f),
        onClick = {
            navController.navigate("${Screen.ArchiveAdminGroupDetail.route}/${group.title}/${group.description}")
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
                color = Color.Black.copy(alpha = 0.7f),
                textAlign = TextAlign.Start,
            )
            Text(
                text = group.description,
                fontSize = 14.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp),
                color = Color.Black.copy(alpha = 0.7f),
                textAlign = TextAlign.Start,
            )
        }
    }
}





@Composable
fun ArchiveScrollContent(innerPadding: PaddingValues, navController: NavController) {
    val context = LocalContext.current

    val userViewModel: UserViewModel = viewModel { UserViewModel(context) }
    val hasData = archiveSampleItems.isNotEmpty()

    // Local variable to store profile data
//    var groupList by rememberSaveable { mutableStateOf<Profile?>(null) }

    // LaunchedEffect to fetch profile data before building the UI
    LaunchedEffect(userViewModel) {
        // Fetch profile data
        userViewModel.getJoinedGroup()
    }

//    // Observe the LiveData and update the local variable
//    userViewModel.profileData.observeAsState().value?.let {
//        profileData = it
//    }

    LazyColumn(
        contentPadding = innerPadding,
        modifier = Modifier.fillMaxSize(),
    ) {
        if (hasData) {
            items(archiveSampleItems) { item ->
                CardArchiveItem(group = item, navController = navController)
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
                        "No Group",
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
fun ArchiveScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            "Archive",
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = 30.dp),
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        ArchiveScrollContent(innerPadding = PaddingValues(16.dp), navController = navController)
    }
}

@Preview(showBackground = true)
@Composable
fun ArchiveScreenPreview() {
    ArchiveScreen(navController = NavController(LocalContext.current))
}
