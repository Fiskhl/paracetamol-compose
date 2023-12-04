package com.example.paracetamol.api.data


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("token") val token: String,
    // Add other properties based on the actual response structure
)
