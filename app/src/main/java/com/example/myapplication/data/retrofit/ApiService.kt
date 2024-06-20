package com.example.myapplication.data.retrofit

import com.example.myapplication.data.response.LoginResponse
import com.example.myapplication.data.response.ResponseRegister
import com.example.myapplication.data.response.UserResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("register")
    @FormUrlEncoded
    fun register(
        @Field("nama") nama: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<ResponseRegister>

    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginResponse

    @GET("users")
    suspend fun users(
        @Query("serId") userId: Int,
        @Query("name")  Nama: String,
        @Query("emails") emailss: String
    ): UserResponse

}