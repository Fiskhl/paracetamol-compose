package com.example.paracetamol.api.data.group.response

import java.io.Serializable


data class GetAllMemberResponse(
    val status: Int,
    val message: String,
    val data: GetAllMemberResponseData
): Serializable

data class GetAllMemberResponseData(
    val data: List<Member>
): Serializable

data class Member(
    val _id: String,
    val nama: String,
    val is_admin: Boolean
): Serializable