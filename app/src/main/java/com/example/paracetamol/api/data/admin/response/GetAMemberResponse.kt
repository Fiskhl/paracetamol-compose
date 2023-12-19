package com.example.paracetamol.api.data.admin.response

import com.example.paracetamol.api.data.profile.Profile
import java.io.Serializable


data class GetAMemberResponse(
    val status: Int,
    val message: String,
    val data: GetAMemberResponseData
): Serializable

data class GetAMemberResponseData(
    val data: Profile
): Serializable