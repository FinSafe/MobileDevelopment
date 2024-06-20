package com.example.myapplication.ui.register

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.repository.FinsafeRepository
import com.example.myapplication.data.response.ResponseRegister
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterViewModel(private val repository: FinsafeRepository): ViewModel() {

    private val _isLoadingSignup = MutableLiveData<Boolean>()
    val isLoadingSignUp: LiveData<Boolean> = _isLoadingSignup

    private val _signupStatus = MutableLiveData<String>()
    val signupStatus: LiveData<String> = _signupStatus

    private val _success = MutableLiveData<Boolean>()
    val success: LiveData<Boolean> = _success

    var errorSignup: Boolean = false

    fun signup(name: String, email: String, password: String) {
        _isLoadingSignup.value = true
        val client = repository.signup(name,email,password)
        client.enqueue(object: Callback<ResponseRegister>{
            override fun onResponse(
                call: Call<ResponseRegister>,
                response: Response<ResponseRegister>
            ) {
                _isLoadingSignup.value = false
                if (response.isSuccessful) {
                    errorSignup = false
                    _signupStatus.value = "Akun berhasil dibuat"
                    _success.value = true
                } else {
                    errorSignup = true
                    _signupStatus.value = when(response.code()){
                        409 -> "Email sudah ada"
                        else -> response.message()
                    }
                    Log.e(TAG, "onFailure : ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ResponseRegister>, t: Throwable) {
                _isLoadingSignup.value = false
                errorSignup = true
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })

    }
}