package com.example.paracetamol.api.data.group.response

data class GetJoinedGroupResponse(
    val status: Int,
    val message: String,
    val data: GetJoinedGroupResponseData
)

data class GetJoinedGroupResponseData(
    val groups: List<String>
)