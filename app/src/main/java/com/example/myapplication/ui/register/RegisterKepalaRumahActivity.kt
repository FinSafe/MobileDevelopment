package com.example.myapplication.ui.register

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityRegisterKepalaRumahBinding

class RegisterKepalaRumahActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterKepalaRumahBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterKepalaRumahBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val kepala_rumahtangga = resources.getStringArray(R.array.informasi_kepala_keluarga)
        val status_perkawinan = resources.getStringArray(R.array.status_perkawinan)
        val pendidikan_terakhir = resources.getStringArray(R.array.pendidikan_kepala_rumah_tangga)
        val pendapatan_uttama = resources.getStringArray(R.array.sumber_pendapatan_utama)
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, kepala_rumahtangga)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)
        val arrayAdapter1 = ArrayAdapter(this, R.layout.dropdown_item, status_perkawinan)
        binding.autoCompleteTextView1.setAdapter(arrayAdapter1)
        val arrayAdapter2 = ArrayAdapter(this, R.layout.dropdown_item, pendidikan_terakhir)
        binding.autoCompleteTextView2.setAdapter(arrayAdapter2)
        val arrayAdapter3 = ArrayAdapter(this, R.layout.dropdown_item, pendapatan_uttama)
        binding.autoCompleteTextView3.setAdapter(arrayAdapter3)

        binding.registerButton.setOnClickListener {

            val intent = Intent(this, RegisterDomisiliActivity::class.java)
            startActivity(intent)
        }

    }
}