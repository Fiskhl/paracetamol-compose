package com.example.paracetamol.api.data.denda.response

import java.io.Serializable

data class GetUserDendaResponse(
    val status: Int,
    val message: String,
    val data: GetUserDendaResponseData
): Serializable

data class GetUserDendaResponseData(
    val dendas: List<DendaItem>
): Serializable

data class DendaItem(
    val _id: String,
    val id_member: String,
    val id_group: String,
    val title: String,
    val hari: String,
    val nominal: Int,
    val desc: String,
    val is_paid: Boolean
): Serializable