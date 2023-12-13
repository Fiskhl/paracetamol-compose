package com.example.paracetamol.model

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.paracetamol.api.ApiService
import com.example.paracetamol.api.data.register.RegisterRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterViewModel(private val context: Context): ViewModel() {
    private val _registerSuccess = MutableLiveData<Boolean?>()
    val registerSuccess: LiveData<Boolean?> get() = _registerSuccess


    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    private fun setRegisterSuccess() {
        _registerSuccess.postValue(true)
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
                Log.d("RegisterViewModel", response.toString())
                if (response.isSuccessful) {
                    Log.d("RegisterViewModel", response.body().toString())
                    setRegisterSuccess()
                } else {
                    handleErrorResponse(response.code())
                }
            } catch (e: Exception) {
                Log.e("RegisterViewModel", "Login failed: ${e.message}")
                _errorMessage.postValue("Login failed")
            }
        }
    }

    private fun handleErrorResponse(responseCode: Int) {
        when (responseCode) {
            401 -> _errorMessage.postValue("Unauthorized")
            404 -> _errorMessage.postValue("Not Found")
            else -> _errorMessage.postValue("Unexpected error: $responseCode")
        }
    }
}
