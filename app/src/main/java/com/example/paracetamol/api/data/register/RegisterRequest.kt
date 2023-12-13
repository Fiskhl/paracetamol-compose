package com.example.paracetamol.api.data.register

data class RegisterRequest(
    val nama: String,
    val nim: String,
    val password: String,
    val email: String,
    val prodi: String,
    val angkatan: String,
)