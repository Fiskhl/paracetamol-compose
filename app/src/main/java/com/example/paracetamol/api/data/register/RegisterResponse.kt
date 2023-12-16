package com.example.paracetamol.api.data.register

data class RegisterResponseData(
    val memberId: String,
)

data class RegisterResponse(
    val message: String,
    val data: RegisterResponseData
)