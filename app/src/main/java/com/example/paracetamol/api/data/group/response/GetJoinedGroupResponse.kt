package com.example.paracetamol.api.data.group.response

data class GetJoinedGroupResponse(
    val status: Int,
    val message: String,
    val data: GetJoinedGroupResponseData
)

data class GetJoinedGroupResponseData(
    val groups: List<GroupItem>
)

data class GroupItem(
    val _id: String,
    val namaGroup: String,
    val desc: String,
    val refKey: String,
    val status: Boolean
)
