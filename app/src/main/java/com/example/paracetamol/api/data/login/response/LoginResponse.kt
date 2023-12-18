package com.example.paracetamol.api.data.login.response

import java.io.Serializable

data class LoginResponse(
    val message: String,
    val token: String
): Serializable