package com.example.paracetamol.nav_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.paracetamol.R
import com.example.paracetamol.api.data.profile.Profile
import com.example.paracetamol.model.UserViewModel
import com.example.paracetamol.ui.theme.poppinsFamily


@Composable
fun ProfileScreen(navController: NavController, onLoggedOut:() -> Unit) {
    val context = LocalContext.current

    val userViewModel: UserViewModel = viewModel { UserViewModel(context) }

    // Local variable to store profile data
    var profileData by rememberSaveable { mutableStateOf<Profile?>(null) }

    // LaunchedEffect to fetch profile data before building the UI
    LaunchedEffect(userViewModel) {
        // Fetch profile data
        userViewModel.getProfile()
    }

    // Observe the LiveData and update the local variable
    userViewModel.profileData.observeAsState().value?.let {
        profileData = it
    }

    if(profileData != null){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
        ) {
            Text(
                text = "Profile",
                fontSize = 36.sp,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
            // Profile Picture
            Image(
                painter = painterResource(id = R.drawable.profile_picture),
                contentDescription = null,
                modifier = Modifier
                    .size(240.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .padding(bottom = 16.dp)
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Crop
            )

            Text(
                text = "Biodata",
                fontWeight = FontWeight.Bold,
                fontFamily = poppinsFamily,
                fontSize = 32.sp,
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
            )

            // User Name
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    tint = Black,
                    modifier = Modifier
                        .size(30.dp)
                        .padding(end = 8.dp)
                )
                Text(
                    text = profileData!!.nama,
                    fontFamily = poppinsFamily,
                    fontSize = 18.sp,
                )
            }

            // Student ID
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_card),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                        .padding(end = 8.dp)
                )
                Text(
                    text = profileData!!.nim,
                    fontFamily = poppinsFamily,
                    fontSize = 18.sp,
                )
            }
            // Program and Year
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_college),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                        .padding(end = 8.dp)
                )
                Text(
                    text = "${profileData?.prodi} (${profileData?.angkatan})",
                    fontFamily = poppinsFamily,
                    fontSize = 18.sp,
                )
            }

            // Email
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null,
                    tint = Black,
                    modifier = Modifier
                        .size(30.dp)
                        .padding(end = 8.dp)
                )
                Text(
                    text = profileData!!.email,
                    fontFamily = poppinsFamily,
                    fontSize = 18.sp,
                )
            }

            // Logout Button
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 16.dp)
                    .height(55.dp),
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = Color(0xFF47A7FF),
                    contentColor = Color.White
                ),
                onClick = {
                    userViewModel.logout()
                    onLoggedOut()
                }
            ) {
                Icon(
                    imageVector = Icons.Default.ExitToApp,
                    contentDescription = null,
                    modifier = Modifier.padding(end = 4.dp)
                )
                Text(text = "Logout")
            }
        }
    }
}
