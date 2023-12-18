package com.example.paracetamol.api.data.register

import java.io.Serializable

data class RegisterResponseData(
    val memberId: String,
): Serializable

data class RegisterResponse(
    val message: String,
    val data: RegisterResponseData
): Serializable