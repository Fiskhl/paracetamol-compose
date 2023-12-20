package com.example.paracetamol.api.data.denda.request

data class CreateDendaRequest(
    val id_group: String,
    val id_member: String,
    val title: String,
    val hari: String,
    val nominal: Int,
    val desc: String,
    val is_paid: Boolean,
)