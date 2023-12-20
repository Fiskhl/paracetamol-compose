package com.example.paracetamol.api.data.denda.response

data class GetSpesifikDendaResponse(
    val status: Int,
    val message: String,
    val data: GetSpesifikDendaResponseData
)

data class GetSpesifikDendaResponseData(
    val data: DendaSpesifikItem
)

data class DendaSpesifikItem(
    val link: String
)