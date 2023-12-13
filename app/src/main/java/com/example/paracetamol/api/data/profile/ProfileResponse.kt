package com.example.paracetamol.api.data.profile

data class ProfileResponse(
    val status: Int,
    val message: String,
    val data: ProfileResponseData
)

data class ProfileResponseData(
    val profile: Profile
)

data class Profile(
    val angkatan: String,
    val email: String,
    val nama: String,
    val nim: String,
    val prodi: String,
)


