package com.example.paracetamol.screen.admin

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Group
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.example.paracetamol.nav_screen.Profile
import com.example.paracetamol.nav_screen.ProfileItem
import com.example.paracetamol.screen.AdminViewMember
import com.example.paracetamol.screen.DendaScrollContent
import com.example.paracetamol.screen.Screen

data class Profile(
    val nim: String,
    val major: String,
    val email: String
)

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
fun AdminProfileUserScreen(
    name: String,
    status: Int,
    navController: NavController
) {

    val profile = Profile(
        nim = "56899",
        major = "Informatika (2021)",
        email = "joshua@gmail.com"
    )

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
        }
        Text(
            text = if (status == 1) "Admin" else "Member",
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

                ProfileItem(name, profile.nim, profile.major, profile.email,)
            }
        }

        when (status) {
            0 -> {
                // Jika status adalah 0 (Member)
                Button(
                    onClick = { /* Handle give admin */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .padding(horizontal = 25.dp),
                    border = BorderStroke(1.dp, Color.Black),
                    colors = ButtonDefaults.elevatedButtonColors(
                        contentColor = Color.White
                    ),
                ) {
                    Text(
                        text = "Give Admin",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp),
                        color = Color.Black,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                }

                Button(
                    onClick = { /* Handle kick member */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .padding(horizontal = 25.dp),
                    border = BorderStroke(1.dp, Color.Black),
                    colors = ButtonDefaults.elevatedButtonColors(
                        contentColor = Color.White
                    ),
                ) {
                    Text(
                        text = "Kick Member",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp),
                        color = Color.Black,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            1 -> {
                // Jika status adalah 1 (Admin)
                Button(
                    onClick = { /* Handle revoke admin */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .padding(horizontal = 25.dp),
                    border = BorderStroke(1.dp, Color.Black),
                    colors = ButtonDefaults.elevatedButtonColors(
                        contentColor = Color.White
                    ),
                ) {
                    Text(
                        text = "Revoke Admin",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp),
                        color = Color.Black,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            else -> {

            }
        }

    }
}

@Composable
@Preview(showBackground = true)
fun AdminProfileUserScreenPreview() {
    val navController = rememberNavController()
    AdminProfileUserScreen(
        "Joshua Hot Banget",
        1,
        navController = navController
    )
}