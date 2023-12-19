package com.example.paracetamol.api.data.admin.response


data class GetAllMemberResponse(
    val status: Int,
    val message: String,
    val data: GetAllMemberResponseData
)

data class GetAllMemberResponseData(
    val members: List<Member>
)

data class Member(
    val _id: String,
    val nama: String,
)
