package com.example.myapplication.ui.register

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
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, kepala_rumahtangga)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)
    }
}