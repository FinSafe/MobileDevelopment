package com.example.myapplication.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.myapplication.data.ViewModelFactory
import com.example.myapplication.data.pref.LoginPreference
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ui.Login.LoginViewModel
import com.example.myapplication.databinding.RekomendasiDanadaruratBinding
import com.example.myapplication.ui.Prediksi_pengeluaran
import com.example.myapplication.ui.danadarurat.DanaDaruratActivity
import com.example.myapplication.ui.profile.ProfileActivity
import com.example.myapplication.ui.tabunganidealku.TabunganIdealkuActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var loginPreference: LoginPreference
    private lateinit var vmFactory: ViewModelFactory
    private val loginViewModel: LoginViewModel by viewModels { vmFactory }
    private val viewModel by viewModels<MainViewModel> {
        ViewModelFactory.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }


        binding.tabunganIdealku.setOnClickListener {
            val intent = Intent(this, TabunganIdealkuActivity::class.java)
            startActivity(intent)
        }

        binding.
        setupViewModel()
        getusername()
        getPrediksi_pengeluaran()
        getDana_darurat()
    }

    private fun setupViewModel(){
        vmFactory = ViewModelFactory.getInstance(binding.root.context)
    }

    private fun getusername() {
        loginPreference = LoginPreference(this)
//        val UserData = loginPreference.getLogin()
//        binding.username.text = UserData.

    }
    private fun getPrediksi_pengeluaran(){
        binding.btnDetailPrediksiPengeluaran.setOnClickListener {
            val intent = Intent(this, Prediksi_pengeluaran::class.java)
            startActivity(intent)
        }
    }

    private fun getDana_darurat(){
        binding.btnDetailDanaDarurat.setOnClickListener {
            val intent = Intent(this, DanaDaruratActivity::class.java)
            startActivity(intent)
        }
    }


}