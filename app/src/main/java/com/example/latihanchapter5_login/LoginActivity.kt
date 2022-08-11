package com.example.latihanchapter5_login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.latihanchapter5_login.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val userName = "herimohamad"
    private val password = "herimohamad27"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            toHomePage()
        }

    }

    private fun toHomePage() {
        val wrongEmailUsername = "Email atau Username yang Anda masukkan tidak terdaftar!"
        val wrongPassword = "Password yang Anda masukkan salah!"
        val inputUserName = binding.etEmail
        val inputPassword = binding.etPassword
        val inputName = binding.etEmail.text.toString()
        val homePage = Intent(this, MainActivity::class.java)
        val validUserName = inputUserName.text.toString()
        val validPassword = inputPassword.text.toString()
        binding.apply {
            if (validUserName != userName && validPassword == password) {
                inputUserName.error = wrongEmailUsername
                inputUserName.requestFocus()
            } else if (validUserName == userName && validPassword != password) {
                inputPassword.error = wrongPassword
                inputPassword.requestFocus()
            } else if (validUserName != userName && validPassword != password) {
                inputUserName.error = wrongEmailUsername
                inputUserName.requestFocus()
                inputPassword.error = wrongPassword
                inputPassword.requestFocus()
            } else {
                homePage.putExtra("KEY_NAME", inputName)
                startActivity(homePage)
                finish()
            }
        }


    }
}