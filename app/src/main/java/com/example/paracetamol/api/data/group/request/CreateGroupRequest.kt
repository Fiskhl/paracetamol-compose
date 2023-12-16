package com.example.paracetamol.api.data.group.request

data class CreateGroupRequest(
    val namaGroup: String,
    val refKey: String,
    val desc: String,
    val status: Boolean,
)