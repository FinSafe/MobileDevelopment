package com.example.myapplication.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.myapplication.data.ViewModelFactory
import com.example.myapplication.data.pref.LoginPreference
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ui.register.RegisterActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var loginPreference: LoginPreference
    private lateinit var vmFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        getusername()
    }

    private fun setupViewModel(){
        vmFactory = ViewModelFactory.getInstance(binding.root.context)
    }

    private fun getusername(){
        loginPreference = LoginPreference(this)


    }
}