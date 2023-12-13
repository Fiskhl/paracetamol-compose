package com.example.paracetamol.api

import com.example.paracetamol.api.data.denda.request.CreateDendaRequest
import com.example.paracetamol.api.data.denda.request.DeleteDendaRequest
import com.example.paracetamol.api.data.denda.request.PayDendaRequest
import com.example.paracetamol.api.data.group.request.CreateGroupRequest
import com.example.paracetamol.api.data.group.response.CreateGroupResponse
import com.example.paracetamol.api.data.login.request.LoginRequest
import com.example.paracetamol.api.data.login.response.LoginResponse
import com.example.paracetamol.api.data.profile.ProfileResponse
import com.example.paracetamol.api.data.register.RegisterRequest
import com.example.paracetamol.api.data.register.RegisterResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {
    // User
    @POST("/member/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>
    @POST("/member")
    suspend fun register(@Body registerRequest: RegisterRequest): Response<RegisterResponse>
    @GET("/getProfile")
    suspend fun getProfile(@Header("Authorization") token: String): Response<ProfileResponse>
    @PUT("/members/edit/{memberID}")
    suspend fun editProfile(
        @Path("memberID") memberID: String,
        @Header("Authorization") token: String,
        @Body registerRequest: RegisterRequest
    ): Response<ResponseBody>
    @DELETE("/member/{memberID}")
    suspend fun deleteProfile(@Path("memberID") memberID: String): Response<ResponseBody>

    // Group
    @POST("/group")
    suspend fun createGroup(
        @Header("Authorization") token: String,
        @Body createGroupRequest: CreateGroupRequest
    ): Response<CreateGroupResponse>
    @POST("/group/join/{referralCode}")
    suspend fun joinGroup(
        @Path("referralCode") referralCode: String,
        @Header("Authorization") token: String
    ): Response<ResponseBody>
    @GET("/allJoinedGroup")
    suspend fun getJoinedGroup(@Header("Authorization") token: String): Response<ResponseBody>
    @DELETE("/group/deactivate/{groupID}")
    suspend fun deactivateGroup(
        @Path("groupID") groupID: String,
        @Header("Authorization") token: String
    ): Response<ResponseBody>
    @PUT("/group/activate/{groupID}")
    suspend fun reactivateGroup(
        @Path("groupID") groupID: String,
        @Header("Authorization") token: String
    ): Response<ResponseBody>

    // Denda
    @POST("/addDenda")
    suspend fun createDenda(
        @Header("Authorization") token: String,
        @Body createDendaRequest: CreateDendaRequest
    ): Response<ResponseBody>
    @POST("/payDenda")
    suspend fun payDenda(
        @Header("Authorization") token: String,
        @Body payDendaRequest: PayDendaRequest
    ): Response<ResponseBody>
    @DELETE("/deleteDenda")
    suspend fun deleteDenda(
        @Header("Authorization") token: String,
        @Body deleteDendaRequest: DeleteDendaRequest
    ): Response<ResponseBody>

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