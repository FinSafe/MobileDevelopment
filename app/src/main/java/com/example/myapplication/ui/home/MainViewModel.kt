package com.example.myapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.myapplication.data.pref.UserModel
import com.example.myapplication.data.repository.FinsafeRepository

class MainViewModel (private val repository: FinsafeRepository): ViewModel() {
    private val _isLoadingMain = MutableLiveData<Boolean>()
    val isLoadingMain: LiveData<Boolean> = _isLoadingMain

    fun getSession(): LiveData<UserModel> {
        return repository.getSession().asLiveData()
    }
}