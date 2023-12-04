package com.example.paracetamol.api

import com.example.paracetamol.api.data.LoginRequest
import com.example.paracetamol.api.data.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login") // Replace with your actual API endpoint
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>
}