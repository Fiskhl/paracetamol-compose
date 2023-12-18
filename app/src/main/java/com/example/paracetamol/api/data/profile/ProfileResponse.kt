package com.example.paracetamol.api.data.profile

import java.io.Serializable

data class ProfileResponse(
    val status: Int,
    val message: String,
    val data: ProfileResponseData
): Serializable

data class ProfileResponseData(
    val profile: Profile
): Serializable


data class Profile(
    val angkatan: String,
    val email: String,
    val nama: String,
    val nim: String,
    val prodi: String,
    val id: String
): Serializable


