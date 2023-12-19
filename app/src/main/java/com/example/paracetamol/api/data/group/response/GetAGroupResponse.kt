package com.example.paracetamol.api.data.group.response

import java.io.Serializable

data class GetAGroupResponse(
    val status: Int,
    val message: String,
    val data: GetAGroupResponseData
): Serializable

data class GetAGroupResponseData(
    val data: GroupItem
): Serializable