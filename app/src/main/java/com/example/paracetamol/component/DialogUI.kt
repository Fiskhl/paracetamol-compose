package com.example.paracetamol.component

import androidx.compose.foundation.background
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.example.paracetamol.R

@Composable
fun DialogUI(title: String, desc: String) {
    val shouldShowDialog = remember { mutableStateOf(true) }

    if(shouldShowDialog.value) {
        AlertDialog(
            onDismissRequest = {
                shouldShowDialog.value = false
            },
            title = {
                Text(text = title)
            },
            text = {
                Text(text = desc)
            },
            confirmButton = {
                Button(
                    onClick = { shouldShowDialog.value = false },
                    modifier = Modifier.background(color = colorResource(id = R.color.purple_200))
                ){
                    Text(text = "Close")
                }
            }
        )
    }
}