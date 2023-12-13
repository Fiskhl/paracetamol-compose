package com.example.paracetamol.api

import com.example.paracetamol.api.data.login.LoginRequest
import com.example.paracetamol.api.data.login.LoginResponse
import com.example.paracetamol.api.data.register.RegisterRequest
import com.example.paracetamol.api.data.register.RegisterResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/member/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST("/member")
    suspend fun register(@Body registerRequest: RegisterRequest): Response<RegisterResponse>

    companion object {
        private const val BASE_URL = "https://mobapp-backend-production.up.railway.app/"
        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}