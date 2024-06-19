package com.example.myapplication.ui.Login

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.ui.MainActivity
import com.example.myapplication.ui.register.RegisterActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var progressBar: ProgressBar

    //  private lateinit var vmFactory: ViewModelFactory
//    private val loginViewModel: LoginViewModel by viewModels {vmFactory}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        progressBar = binding.progressBar

        loginBtnClick()
        backActivity()
        moveToRegister()
    }

    private fun loginBtnClick() {
        binding.btnLogin.setOnClickListener {
            val username = binding.loginUsername.text.toString().trim()
            val Password = binding.loginPassword.text.toString().trim()

            if (username.isEmpty() || Password.isEmpty() || Password.length < 8) {
                Toast.makeText(this, R.string.fill_data, Toast.LENGTH_SHORT).show()
            } else {
//                login(username, Password)
                moveToMainActivity()
            }
        }
    }

//    private fun login(username: String, Password: String) {
//      loginViewModel.postLogin(username, Password).observe(this@LoginActivity){ result ->
//    if (result != null) {
//        when(result) {
//            is com.farisafra.dicodingstory.data.repository.Result.Loading -> {
//                progressBar.visibility = View.VISIBLE
//            }
//                progressBar.visibility = View.GONE
//                errorResponse()
//            }
//            is com.farisafra.dicodingstory.data.repository.Result.Success -> {
//                progressBar.visibility = View.GONE
//                successLoginHandler(result.data)
//            }
//        }
//    }
//      }
//    }
//}

//    private fun successLoginHandler(loginResponse: LoginResponse) {
//        saveData(loginResponse)
//        Toast.makeText(this, R.string.login_success, Toast.LENGTH_SHORT).show()
    //       moveToMainActivity()
//    }

//    private fun saveData(response: LoginResponse) {
//        val loginPreference = LoginPreference(this)
//        loginPreference.setLogin(response.loginResult?.name ?: "", response.loginResult?.userId ?: "", response.loginResult?.token ?: "")
//    }

//    private fun errorResponse() {
//        ResponseView(this, R.string.error_message, R.drawable.symbols_error).show()
//    }

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