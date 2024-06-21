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
import com.example.myapplication.databinding.ActivityRegisterTipeRumahTanggaBinding

class RegisterTipeRumahTanggaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterTipeRumahTanggaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterTipeRumahTanggaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tipe_rt = resources.getStringArray(R.array.tipe_rt)
        val jumlah_anak = resources.getStringArray(R.array.anak)
        val banyak_kendaraan_mobil = resources.getStringArray(R.array.mobil)
        val banyakk_kendaraan_motor = resources.getStringArray(R.array.motor)
        val arrayAdapterr = ArrayAdapter(this, R.layout.dropdown_item, tipe_rt)
        binding.autoCompletetipert.setAdapter(arrayAdapterr)
        val arrayAdapterr2 = ArrayAdapter(this, R.layout.dropdown_item, jumlah_anak)
        binding.autoCompleteanak.setAdapter(arrayAdapterr2)
        val arrayAdapterr3 = ArrayAdapter(this, R.layout.dropdown_item, banyak_kendaraan_mobil)
        binding.autoCompletemobil.setAdapter(arrayAdapterr3)
        val arrayAdapterr4 = ArrayAdapter(this, R.layout.dropdown_item, banyakk_kendaraan_motor)
        binding.autoCompletemotor.setAdapter(arrayAdapterr4)

        binding.registerButton.setOnClickListener {

            val intent = Intent(this, RegisterTelevisiActivity::class.java)
            startActivity(intent)
        }

    }
}