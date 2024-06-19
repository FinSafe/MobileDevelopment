package com.example.myapplication.ui.Login

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.repository.FinsafeRepository

class LoginViewModel(private val finsafeRepository: FinsafeRepository) : ViewModel(){
    fun postLogin(email: String, password: String) = finsafeRepository.login(email, password)
}