package com.example.paracetamol.api.data.group.response

import java.io.Serializable

data class GetJoinedGroupResponse(
    val status: Int,
    val message: String,
    val data: GetJoinedGroupResponseData
): Serializable

data class GetJoinedGroupResponseData(
    val groups: List<GroupItem>
): Serializable

data class GroupItem(
    val _id: String,
    val namaGroup: String,
    val desc: String,
    val refKey: String,
    val status: Boolean
): Serializable
