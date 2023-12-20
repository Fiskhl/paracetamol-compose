package com.example.paracetamol.api.data.group.response

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.MutableStateFlow
import java.io.Serializable


data class GetAllMemberResponse(
    val status: Int,
    val message: String,
    val data: GetAllMemberResponseData
): Serializable

data class GetAllMemberResponseData(
    val data: List<Member>
): Serializable

data class Member(
    val _id: String,
    val nama: String,
    val is_admin: Boolean,
    private val _totalDenda: MutableStateFlow<Int> = MutableStateFlow(0)
) {
    val totalDenda: MutableStateFlow<Int> get() = _totalDenda

    fun updateTotalDenda(newTotalDenda: Int) {
        _totalDenda.value = newTotalDenda
    }
}