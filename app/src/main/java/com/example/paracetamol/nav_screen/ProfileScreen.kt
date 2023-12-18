package com.example.paracetamol.nav_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.paracetamol.R


data class Profile(
    val name: String,
    val nim: String,
    val major: String,
    val email: String
)

@Composable
fun ProfileScreen(navController: NavController, onLoggedOut:() -> Unit) {

    //    val context = LocalContext.current

//    val userViewModel: UserViewModel = viewModel { UserViewModel(context) }

    // Local variable to store profile data
//    var profileData by rememberSaveable { mutableStateOf<Profile?>(null) }

    // LaunchedEffect to fetch profile data before building the UI
//    LaunchedEffect(userViewModel) {
//        // Fetch profile data
//        userViewModel.getProfile()
//    }

    // Observe the LiveData and update the local variable
//    userViewModel.profileData.observeAsState().value?.let {
//        profileData = it
//    }
// Local variable to store profile data

    val profile = Profile(
        name = "Joshua",
        nim = "56899",
        major = "Informatika (2021)",
        email = "joshua@gmail.com"
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 35.dp, start = 16.dp, end = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Profile",
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_profile),
                        contentDescription = "Profile Image",
                        modifier = Modifier
                            .size(150.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    Text(
                        text = "Biodata",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .padding(top = 8.dp, bottom = 8.dp)
                            .padding(horizontal = 4.dp)
                    )

                    ProfileItem(profile.name, profile.nim, profile.major, profile.email,)
//                    ProfileItem(profile.nim)
//                    ProfileItem(profile.major)
//                    ProfileItem(profile.email)
                }
            }

            Button(
                onClick = { /* Handle logout */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp),
                border = BorderStroke(1.dp, Color.Red),
                colors = ButtonDefaults.elevatedButtonColors(
                    contentColor = Color.White
                ),
            ) {
                Text(
                    text = "Logout",
                    color = Color.Black
                )
            }
        }
    }
}

@Composable
fun ProfileItem(name: String, nim: String, major: String, email: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .background(Color.White)
            .clip(RoundedCornerShape(8.dp))
            .border(1.dp, Color.Gray.copy(alpha = 0.8f), RoundedCornerShape(8.dp))
            .padding(10.dp) // Padding untuk memberi jarak dari border ke dalam
    ) {
        Text(
            text = name,
            fontSize = 16.sp,
            modifier = Modifier.padding(6.dp)
        )
        Divider(color = Color.Gray.copy(alpha = 0.8f), thickness = 1.dp)
        Text(
            text = nim,
            fontSize = 16.sp,
            modifier = Modifier.padding(6.dp)
        )
        Divider(color = Color.Gray.copy(alpha = 0.8f), thickness = 1.dp)
        Text(
            text = major,
            fontSize = 16.sp,
            modifier = Modifier.padding(6.dp)
        )
        Divider(color = Color.Gray.copy(alpha = 0.8f), thickness = 1.dp)
        Text(
            text = email,
            fontSize = 16.sp,
            modifier = Modifier.padding(6.dp)
        )
    }
}





@Composable
@Preview(showBackground = true)
fun ProfileScreenPreview() {
    val navController = rememberNavController()
    ProfileScreen(navController = navController, onLoggedOut = {})
}
