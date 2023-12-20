package com.example.paracetamol.api.data.admin.response

data class GetListMemberWithDendaResponse(
    val status: Int,
    val message: String,
    val data: GetListMemberWithDendaResponseData
)

data class GetListMemberWithDendaResponseData(
    val members: List<MemberWithDenda>
)

data class MemberWithDenda(
    val id: String,
    val name: String,
    val nominal: Int
)