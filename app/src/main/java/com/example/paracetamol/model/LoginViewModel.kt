package com.example.paracetamol.model

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.paracetamol.api.ApiService
import com.example.paracetamol.api.data.login.LoginRequest
import com.example.paracetamol.preferences.PreferenceManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(private val context: Context): ViewModel() {
    private val _loginSuccess = MutableLiveData(false)
    val loginSuccess: LiveData<Boolean> get() = _loginSuccess

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    private fun setLoginSuccess() {
        _loginSuccess.postValue(true)
    }

    fun login(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val loginRequest = LoginRequest(email, password)
            try {
                val response = ApiService.create().login(loginRequest)
                Log.d("LoginViewModel", response.toString())
                if (response.isSuccessful) {
                    Log.d("LoginViewModelSuccess", response.body().toString())
                    val token = response.body()!!.token
                    Log.d("Token", token)
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

    private fun saveToken(token: String) {
        PreferenceManager.saveToken(context, token)
    }

    private fun saveSession(){
        PreferenceManager.saveIsLoggedIn(context)
    }

    private fun handleErrorResponse(responseCode: Int) {
        when (responseCode) {
            400 -> _errorMessage.postValue("Bad Request")
            404 -> _errorMessage.postValue("Not Found")
            else -> _errorMessage.postValue("Login failed")
        }
    }
}
