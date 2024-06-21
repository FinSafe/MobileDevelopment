package com.example.myapplication.ui.register

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityRegisterDomisiliBinding
import com.example.myapplication.databinding.ActivityRegisterKepalaRumahBinding

class RegisterDomisiliActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterDomisiliBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterDomisiliBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val domisili = resources.getStringArray(R.array.provinsi_domisili)
        val bangunan_rumah = resources.getStringArray(R.array.tipe_bangunan)
        val listrik = resources.getStringArray(R.array.listrik)
        val status_kepemilikan = resources.getStringArray(R.array.status_tempat_tinggal)
        val arrayAdapterss = ArrayAdapter(this, R.layout.dropdown_item, domisili)
        binding.autoCompletedomisili.setAdapter(arrayAdapterss)
        val arrayAdapterss2 = ArrayAdapter(this, R.layout.dropdown_item, bangunan_rumah)
        binding.autoCompletebangunan.setAdapter(arrayAdapterss2)
        val arrayAdapterss3 = ArrayAdapter(this, R.layout.dropdown_item, listrik)
        binding.autoCompletelistik.setAdapter(arrayAdapterss3)
        val arrayAdapterss4 = ArrayAdapter(this, R.layout.dropdown_item, status_kepemilikan)
        binding.autoCompletekepemilikan.setAdapter(arrayAdapterss4)

        binding.registerButton.setOnClickListener {

            val intent = Intent(this, RegisterTipeRumahTanggaActivity::class.java)
            startActivity(intent)
        }
    }
}