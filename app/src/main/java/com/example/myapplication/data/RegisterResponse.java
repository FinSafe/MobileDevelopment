package com.example.myapplication.data;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse {

	@SerializedName("password")
	private String password;

	@SerializedName("nama")
	private String nama;

	@SerializedName("email")
	private String email;

	public String getPassword(){
		return password;
	}

	public String getNama(){
		return nama;
	}

	public String getEmail(){
		return email;
	}
}