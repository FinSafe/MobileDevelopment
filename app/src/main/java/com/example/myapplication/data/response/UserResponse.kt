package com.example.myapplication.data.response

import com.google.gson.annotations.SerializedName

data class UserResponse(

	@field:SerializedName("password")
	val password: String,

	@field:SerializedName("nama")
	val nama: String,

	@field:SerializedName("user_id")
	val userId: Int,

	@field:SerializedName("email")
	val email: String
)
