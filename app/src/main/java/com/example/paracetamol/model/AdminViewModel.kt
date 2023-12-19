package com.example.paracetamol.model

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.paracetamol.api.ApiService
import com.example.paracetamol.api.data.admin.response.Member
import com.example.paracetamol.api.data.denda.request.PayDendaRequest
import com.example.paracetamol.api.data.denda.response.DendaItem
import com.example.paracetamol.api.data.group.request.CreateGroupRequest
import com.example.paracetamol.api.data.group.response.GroupItem
import com.example.paracetamol.api.data.login.request.LoginRequest
import com.example.paracetamol.api.data.profile.Profile
import com.example.paracetamol.api.data.register.RegisterRequest
import com.example.paracetamol.preferences.PreferenceManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject

class AdminViewModel(private val context: Context): ViewModel() {
    private val _groupMembersData = MutableLiveData<List<Member?>?>()
    val groupMembersData: LiveData<List<Member?>?> get() = _groupMembersData

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> get() = _errorMessage

    private fun setGroupMembersData(data: List<Member>) {
        _groupMembersData.postValue(data)
    }

    private fun clearErrorMessage(){
        _errorMessage.postValue(null);
    }

    fun getMembersGroupData(groupRef: String){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val token = PreferenceManager.getToken(context)
                val response = ApiService.create().getAllMember(groupRef, "Bearer $token")
                if (response.isSuccessful) {
                    clearErrorMessage()
                    setGroupMembersData(response.body()?.data!!.members)
                } else {
                    handleErrorResponse(response.code())
                }
            } catch (e: Exception) {
                _errorMessage.postValue("Failed to get all fines")
            }
        }
    }



    private fun handleErrorResponse(responseCode: Int) {
        when (responseCode) {
            400 -> _errorMessage.postValue("Bad Request")
            404 -> _errorMessage.postValue("Not Found")
            409 -> _errorMessage.postValue("Already Joined/Registered")
            500 -> _errorMessage.postValue("Server Error")
            else -> _errorMessage.postValue("Error Code: $responseCode")
        }
    }

    companion object {
        val model_ref = "AdminViewModel"
    }
}
