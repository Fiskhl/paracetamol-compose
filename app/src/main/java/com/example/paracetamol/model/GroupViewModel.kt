package com.example.paracetamol.model

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.paracetamol.api.ApiService
import com.example.paracetamol.api.data.group.response.GetJoinedGroupResponseData
import com.example.paracetamol.api.data.login.request.LoginRequest
import com.example.paracetamol.api.data.profile.Profile
import com.example.paracetamol.api.data.register.RegisterRequest
import com.example.paracetamol.preferences.PreferenceManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GroupViewModel(private val context: Context): ViewModel() {
    private val _joinGroupSuccess = MutableLiveData<Boolean?>()
    val joinedGroupSuccess: LiveData<Boolean?> get() = _joinGroupSuccess

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    private fun setJoinGroupSuccess() {
        _joinGroupSuccess.postValue(true)
    }

    fun joinGroup(referralCode: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val token = PreferenceManager.getToken(context)
                Log.d(model_ref, token!!)
                val response = ApiService.create().joinGroup(referralCode, "Bearer $token")
                Log.d(model_ref, response.toString())
                if (response.isSuccessful) {
                    Log.d(model_ref, response.body().toString())
                    setJoinGroupSuccess()
                } else {
                    handleErrorResponse(response.code())
                }
            } catch (e: Exception) {
                _errorMessage.postValue("Register failed")
            }
        }
    }

    fun login(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val loginRequest = LoginRequest(email, password)
            try {
                val response = ApiService.create().login(loginRequest)
                Log.d(model_ref, response.toString())
                if (response.isSuccessful) {
                    Log.d(model_ref, response.body().toString())
                } else {
                    handleErrorResponse(response.code())
                }
            } catch (e: Exception) {
                _errorMessage.postValue("Login failed")
            }
        }
    }


    private fun handleErrorResponse(responseCode: Int) {
        when (responseCode) {
            400 -> _errorMessage.postValue("Bad Request")
            404 -> _errorMessage.postValue("Not Found")
            else -> _errorMessage.postValue("Login failed")
        }
    }

    companion object {
        val model_ref = "GroupViewModel"
    }
}
