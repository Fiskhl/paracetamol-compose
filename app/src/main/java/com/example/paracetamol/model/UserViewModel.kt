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

class UserViewModel(private val context: Context): ViewModel() {
    private val _registerSuccess = MutableLiveData<Boolean?>()
    val registerSuccess: LiveData<Boolean?> get() = _registerSuccess

    private val _loginSuccess = MutableLiveData<Boolean?>()
    val loginSuccess: LiveData<Boolean?> get() = _loginSuccess

    private val _profileData = MutableLiveData<Profile?>()
    val profileData: LiveData<Profile?> get() = _profileData

    private val _joinedGroups = MutableLiveData<GetJoinedGroupResponseData?>()
    val joinedGroups: LiveData<GetJoinedGroupResponseData?> get() = _joinedGroups

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    private fun setLoginSuccess() {
        _loginSuccess.postValue(true)
    }

    private fun setRegisterSuccess() {
        _registerSuccess.postValue(true)
    }

    private fun setProfileData(data: Profile) {
        _profileData.postValue(data)
    }

    private fun setJoinedGroups(groups: GetJoinedGroupResponseData){
        _joinedGroups.postValue(groups)
    }

    fun register(
        nama: String,
        nim: String,
        password: String,
        email: String,
        prodi: String,
        angkatan: String
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            val registerRequest = RegisterRequest(nama,nim, password, email, prodi, angkatan)
            try {
                val response = ApiService.create().register(registerRequest)
                Log.d(model_ref, response.toString())
                if (response.isSuccessful) {
                    Log.d(model_ref, response.body().toString())
                    setRegisterSuccess()
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
                    val token = response.body()!!.token
                    Log.d(model_ref, token)
                    saveToken(token)
                    saveSession()
                    setLoginSuccess()
                } else {
                    handleErrorResponse(response.code())
                }
            } catch (e: Exception) {
                _errorMessage.postValue("Login failed")
            }
        }
    }

    fun getProfile() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val token = PreferenceManager.getToken(context)
                Log.d(model_ref, token!!)
                val response = ApiService.create().getProfile("Bearer $token")
                Log.d(model_ref, response.toString())
                if (response.isSuccessful) {
                    Log.d(model_ref, response.body().toString())
                    val profileData = response.body()?.data?.profile
                    if (profileData != null) {
                        Log.d(model_ref, profileData.toString())
                        setProfileData(profileData)
                    } else {
                        _errorMessage.postValue("Profile data is null")
                    }
                } else {
                    handleErrorResponse(response.code())
                }
            } catch (e: Exception) {
                _errorMessage.postValue("Failed to get profile")
            }
        }
    }

    fun getJoinedGroup(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val token = PreferenceManager.getToken(context)
                Log.d(model_ref, token!!)
                val response = ApiService.create().getJoinedGroup("Bearer $token")
                Log.d(model_ref, response.toString())
                if (response.isSuccessful) {
                    Log.d(model_ref, response.body()?.string() ?: "No Response")
//                    val profileData = response.body()?.data?.profile
//                    if (profileData != null) {
//                        Log.d(model_ref, profileData.toString())
//                        setProfileData(profileData)
//                    } else {
//                        _errorMessage.postValue("Profile data is null")
//                    }
                } else {
                    handleErrorResponse(response.code())
                }
            } catch (e: Exception) {
                _errorMessage.postValue("Failed to get profile")
            }
        }
    }

    fun logout() {
        clearPreferences()
    }

    private fun saveMemberID(memberID: String) {
        PreferenceManager.saveMemberID(context, memberID)
    }

    private fun saveSession(){
        PreferenceManager.saveIsLoggedIn(context)
    }

    private fun saveToken(token: String) {
        PreferenceManager.saveToken(context, token)
    }

    private fun clearPreferences() {
        PreferenceManager.clearPreferences(context)
    }

    private fun handleErrorResponse(responseCode: Int) {
        when (responseCode) {
            400 -> _errorMessage.postValue("Bad Request")
            404 -> _errorMessage.postValue("Not Found")
            else -> _errorMessage.postValue("Login failed")
        }
    }

    companion object {
        val model_ref = "UserViewModel"
    }
}
