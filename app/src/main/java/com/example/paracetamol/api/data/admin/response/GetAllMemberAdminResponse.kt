package com.example.paracetamol.api.data.admin.response

import java.io.Serializable

data class GetAllMemberAdminResponse(
    val status: Int,
    val message: String,
    val data: GetAllMemberAdminResponseData
): Serializable

data class GetAllMemberAdminResponseData(
    val data: List<MemberDataAdmin>
): Serializable

data class MemberDataAdmin(
    val _id: String,
    val nama: String,
    val is_allowed: Boolean,
    val is_admin: Boolean
): Serializable