package com.example.myapplication.ui.register

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityRegisterTelevisiBinding
import com.example.myapplication.databinding.ActivityRegisterTipeRumahTanggaBinding

class RegisterTelevisiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterTelevisiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterTelevisiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val televisi = resources.getStringArray(R.array.television)
        val kulkas = resources.getStringArray(R.array.kulkas)
        val komputer = resources.getStringArray(R.array.komputer)
        val AC = resources.getStringArray(R.array.air_conditioner)
        val mesin_cuci = resources.getStringArray(R.array.mesin_cuci)
        val arrayAdapte = ArrayAdapter(this, R.layout.dropdown_item, televisi)
        binding.autoCompletetelevisi.setAdapter(arrayAdapte)
        val arrayAdapte2 = ArrayAdapter(this, R.layout.dropdown_item, kulkas)
        binding.autoCompletekulkas.setAdapter(arrayAdapte2)
        val arrayAdapte3 = ArrayAdapter(this, R.layout.dropdown_item, komputer)
        binding.autoCompletekomputer.setAdapter(arrayAdapte3)
        val arrayAdapte4 = ArrayAdapter(this, R.layout.dropdown_item, AC)
        binding.autoCompleteac.setAdapter(arrayAdapte4)
        val arrayAdapte5 = ArrayAdapter(this, R.layout.dropdown_item, mesin_cuci)
        binding.autoCompletemesincuci.setAdapter(arrayAdapte5)

        binding.registerButton.setOnClickListener {

            val intent = Intent(this, RegisterDanaDaruratActivity::class.java)
            startActivity(intent)
        }
    }
}