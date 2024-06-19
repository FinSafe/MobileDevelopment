package com.example.myapplication.data.retrofit

import com.example.myapplication.data.response.ResponseRegister
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    @POST("register")
    @FormUrlEncoded
    fun register(
        @Field("nama") nama: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<ResponseRegister>
}