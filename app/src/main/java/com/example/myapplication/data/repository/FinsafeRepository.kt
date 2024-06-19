package com.example.myapplication.data.repository

import com.example.myapplication.data.pref.UserModel
import com.example.myapplication.data.pref.UserPreference
import com.example.myapplication.data.response.ResponseRegister
import com.example.myapplication.data.retrofit.ApiService
import kotlinx.coroutines.flow.Flow
import retrofit2.Call

class FinsafeRepository private constructor(
    private val apiService: ApiService,
    private val userPreference: UserPreference
){
    suspend fun saveSession(user: UserModel) {
        userPreference.saveSession(user)
    }

    fun getSession(): Flow<UserModel> {
        return userPreference.getSession()
    }

    suspend fun logout() {
        userPreference.logout()
    }

    fun signup(name: String, email: String, password: String): Call<ResponseRegister> {
        return apiService.register(name, email, password)
    }

    companion object {
        @Volatile
        private var instance: FinsafeRepository? = null
        fun getInstance(
            apiService: ApiService,
            userPreference: UserPreference
        ): FinsafeRepository =
            instance ?: synchronized(this) {
                instance ?: FinsafeRepository(apiService, userPreference)
            }.also { instance = it }
    }
}