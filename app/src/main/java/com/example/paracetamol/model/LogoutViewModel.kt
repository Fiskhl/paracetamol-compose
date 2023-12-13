package com.example.paracetamol.model

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.paracetamol.preferences.PreferenceManager

class LogoutViewModel(private val context: Context): ViewModel() {
    fun logout() {
        clearPreferences()
    }

    private fun clearPreferences() {
        PreferenceManager.clearPreferences(context)
    }
}
