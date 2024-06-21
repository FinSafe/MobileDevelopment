package com.example.myapplication.ui.Login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.data.ViewModelFactory
import com.example.myapplication.data.pref.LoginPreference
import com.example.myapplication.data.response.LoginResponse
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.ui.customview.ResponView
import com.example.myapplication.ui.home.MainActivity
import com.example.myapplication.ui.register.RegisterActivity
import com.example.myapplication.ui.register.RegisterKepalaRumahActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var progressBar: ProgressBar
    private lateinit var vmFactory: ViewModelFactory
    private val loginViewModel: LoginViewModel by viewModels { vmFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        progressBar = binding.progressBar

        loginBtnClick()
        backActivity()
        moveToRegister()
        setupViewModel()
    }

    private fun setupViewModel() {
        vmFactory = ViewModelFactory.getInstance(binding.root.context)
    }

    private fun loginBtnClick() {
        binding.btnLogin.setOnClickListener {
            val email = binding.loginEmails.text.toString().trim()
            val Password = binding.loginPassword.text.toString().trim()

            if (email.isEmpty() || Password.isEmpty() || Password.length < 8 || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, R.string.fill_data, Toast.LENGTH_SHORT).show()
            } else {
                login(email, Password)
            }
        }
    }

    private fun login(email: String, Password: String) {
        loginViewModel.postLogin(email, Password).observe(this@LoginActivity) { result ->
            if (result != null) {
                when (result) {
                    is com.example.myapplication.data.repository.Result.Loading -> {
                        progressBar.visibility = View.VISIBLE
                    }

                    is com.example.myapplication.data.repository.Result.Error -> {
                        progressBar.visibility = View.GONE
                        errorResponse()
                    }

                    is com.example.myapplication.data.repository.Result.Success -> {
                        progressBar.visibility = View.GONE
                        successLoginHandler(result.data)
                    }
                }
            }
        }
    }

    private fun successLoginHandler(loginResponse: LoginResponse) {
        saveData(loginResponse)
        Toast.makeText(this, R.string.login_success, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, RegisterKepalaRumahActivity::class.java)
        startActivity(intent)
           moveToMainActivity()
    }

    private fun saveData(response: LoginResponse) {
        val loginPreference = LoginPreference(this)
        loginPreference.setLogin(response.token?: "")
    }

    private fun errorResponse() {
        ResponView(this, R.string.error_message, R.drawable.baseline_error_outline_24).show()
    }

    private fun moveToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun moveToRegister() {
        binding.btnRegis.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun backActivity() {
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}