package com.example.paracetamol.nav_screen


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.paracetamol.api.data.profile.Profile
import com.example.paracetamol.model.UserViewModel
//import com.example.paracetamol.Student
import com.example.paracetamol.screen.Screen
import com.example.paracetamol.ui.theme.poppinsFamily
import androidx.compose.ui.Alignment

data class GroupData(val title: String, val description: String)

// ganti api
//val sampleItems = emptyList<GroupData>()
val sampleItems = listOf(
    GroupData("MAXIMA 2023", "Explore The World Reach New Potentials"),
//    GroupData("UMN ECO 2023", "We Act for The Better Ear.ue Spartan"),
    GroupData("STARLIGHT 2023", "With us you can be a Star"),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardItem(group: GroupData, navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp, vertical = 7.dp),
        border = BorderStroke(2.dp, Color(0xFF1F628E)),
        shape = RoundedCornerShape(12.dp),
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
    val context = LocalContext.current

    val userViewModel: UserViewModel = viewModel { UserViewModel(context) }
    val hasData = sampleItems.isNotEmpty()

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
            items(sampleItems) { item ->
                CardItem(group = item, navController = navController)
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
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            "Home",
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = 30.dp),
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
//        AppToolbar(navController = navController)
        ScrollContent(innerPadding = PaddingValues(16.dp), navController = navController)
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = NavController(LocalContext.current))
}
