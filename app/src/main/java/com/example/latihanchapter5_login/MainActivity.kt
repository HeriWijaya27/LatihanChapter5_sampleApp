package com.example.latihanchapter5_login

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.latihanchapter5_login.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    companion object{
        const val USERNAME = "KEY_NAME"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showSnackbar()
        val userName = intent.getStringExtra(USERNAME)
        val welcomeName = "Hello, $userName"

        binding.apply {
            tvNameDisplayTop.text = welcomeName
            tvNameDisplayBottom.text = userName
            Glide.with(this@MainActivity)
                .load("https://images.pexels.com/photos/1704488/pexels-photo-1704488.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500")
                .circleCrop()
                .into(ivPhotoProfile)
        }
    }

    private fun showSnackbar() {
        val welcomeName = intent.getStringExtra(USERNAME)
        binding.llMainActivity.let {
            Snackbar.make(
                it,
                "Selamat Datang $welcomeName",
                Snackbar.LENGTH_LONG
            ).apply {
                view.setBackgroundResource(R.color.orange)
                setTextColor(Color.WHITE)
                setAction("DISMISS"){
                    dismiss()
                }
                setActionTextColor(Color.WHITE)


                show()
            }
        }
    }
}