package com.example.myapplication.register

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.ViewModelFactory
import com.example.myapplication.databinding.ActivityRegisterBinding
import com.example.myapplication.ui.informationUser.LoginActivity
import com.google.android.material.snackbar.Snackbar

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var viewModel: RegisterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(application)

        viewModel = ViewModelProvider(this, factory).get(RegisterViewModel::class.java)

        viewModel.isLoadingSignUp.observe(this){
            showLoading(it)
        }

        viewModel.signupStatus.observe(this){ signupStatus ->
            val error = viewModel.errorSignup
            if (error) {
                Snackbar.make(binding.root, signupStatus, Snackbar.LENGTH_SHORT).show()
            }
        }

        viewModel.success.observe(this){
            if (it) {
                AlertDialog.Builder(this).apply {
                    setTitle("Selamat!")
                    setMessage("Kamu berhasil registrasi")
                    setPositiveButton("Lanjut") { _,_ ->
                        val intent = Intent(context, LoginActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                        startActivity(intent)
                        finish()
                    }
                    create()
                    show()
                }
            }
        }

        binding.registerButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            viewModel.signup(name, email, password)

        }
        setupView()
    }

    private fun setupView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading){
            binding.progressBarSignup.visibility = View.VISIBLE
        } else {
            binding.progressBarSignup.visibility = View.GONE
        }
    }
}