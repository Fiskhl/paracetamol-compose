package com.example.paracetamol.preferences

import android.content.Context
import android.content.Context.MODE_PRIVATE

object PreferenceManager {
    private const val PREF_NAME = "user_prefs"
    private const val KEY_MEMBER_ID = "member_id"
    private const val KEY_USER_TOKEN = "user_token"
    private const val KEY_IS_LOGGED_IN = "is_logged_in"

    fun saveMemberID(context: Context, memberID: String){
        val sharedPreferences = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)
        sharedPreferences.edit().putString(KEY_MEMBER_ID, memberID).apply()
    }

    fun getMemberID(context: Context): String? {
        val sharedPreferences = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)
        return sharedPreferences.getString(KEY_MEMBER_ID, null)
    }

    fun saveIsLoggedIn(context: Context){
        val sharedPreferences = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)
        sharedPreferences.edit().putBoolean(KEY_IS_LOGGED_IN, true).apply()
    }

    fun getIsLoggedIn(context: Context): Boolean {
        val sharedPreferences = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)
        return sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false)
    }

    fun saveToken(context: Context, token: String) {
        val sharedPreferences = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)
        sharedPreferences.edit().putString(KEY_USER_TOKEN, token).apply()
    }

    fun getToken(context: Context): String? {
        val sharedPreferences = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)
        return sharedPreferences.getString(KEY_USER_TOKEN, null)
    }

    fun clearPreferences(context: Context) {
        val sharedPreferences = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)
        sharedPreferences.edit().clear().apply()
    }
}
