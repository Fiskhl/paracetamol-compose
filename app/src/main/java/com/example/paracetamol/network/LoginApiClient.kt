package com.example.paracetamol.network

import com.example.paracetamol.api.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun createApiService(): ApiService {
    val retrofit = Retrofit.Builder()
        .baseUrl("your_base_url_here") // Replace with your actual API base URL
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    return retrofit.create(ApiService::class.java)
}
