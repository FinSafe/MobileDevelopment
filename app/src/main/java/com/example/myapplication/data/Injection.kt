package com.example.myapplication.data

import android.content.Context
import com.example.myapplication.data.pref.UserPreference
import com.example.myapplication.data.pref.dataStore
import com.example.myapplication.data.retrofit.ApiConfig

object Injection {
    fun provideRepository(context: Context): FinsafeRepository {
        val pref = UserPreference.getInstance(context.dataStore)
        val apiService = ApiConfig.getApiService()
        return FinsafeRepository.getInstance(apiService, pref)
    }
}