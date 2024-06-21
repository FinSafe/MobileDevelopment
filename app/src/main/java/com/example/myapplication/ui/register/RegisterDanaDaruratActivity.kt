package com.example.myapplication.ui.register

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityDanaDaruratBinding
import com.example.myapplication.databinding.ActivityRegisterDanaDaruratBinding
import com.example.myapplication.databinding.ActivityRegisterDomisiliBinding

class RegisterDanaDaruratActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRegisterDanaDaruratBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterDanaDaruratBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val punya_danadarurat = resources.getStringArray(R.array.dana_darurat)
        val memiliki_hutang = resources.getStringArray(R.array.hutang)
        val arrayAdaptery = ArrayAdapter(this, R.layout.dropdown_item, punya_danadarurat)
        binding.autoCompletedanadarurat.setAdapter(arrayAdaptery)
        val arrayAdaptery2 = ArrayAdapter(this, R.layout.dropdown_item, memiliki_hutang)
        binding.autoCompletehutang.setAdapter(arrayAdaptery2)

        binding.registerButton.setOnClickListener {

            val intent = Intent(this, RegisterSuccessActivity::class.java)
            startActivity(intent)
        }
    }
}