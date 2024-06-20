package com.example.myapplication.data.pref

import android.content.Context
import android.content.SharedPreferences

class LoginPreference(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    companion object{
        const val PREFS_NAME = "user_prefs"
        const val KEY_TOKEN = "token"
    }

    fun setLogin(token: String){
        val editor = sharedPreferences.edit()
        editor.putString(KEY_TOKEN, token)
        editor.apply()
    }

    fun getLogin(): String? {
        return sharedPreferences.getString(KEY_TOKEN, null)
    }

    fun clearLogin(){
        val editor = sharedPreferences.edit().clear()
        editor.apply()
    }
}