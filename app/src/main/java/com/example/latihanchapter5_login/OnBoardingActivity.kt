package com.example.latihanchapter5_login

import android.content.Intent
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.latihanchapter5_login.adapter.ViewPagerAdapter
import com.example.latihanchapter5_login.databinding.ActivityOnBoardingBinding

class OnBoardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnBoardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPagerAdapter = ViewPagerAdapter(this)
        binding.apply {
            vpOnBoarding.adapter = viewPagerAdapter
            tvSkip.setOnClickListener {
                toLoginPage()

            }
            vpOnBoarding.registerOnPageChangeCallback(object :
                ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    when (position) {
                        0 -> {
                            btnGetStarted.visibility = INVISIBLE
                            tvPrev.visibility = INVISIBLE
                            tvSkip.visibility = VISIBLE
                            binding.apply {
                                tvNext.setOnClickListener {
                                    vpOnBoarding.currentItem = vpOnBoarding.currentItem +1
                                }
                                tvPrev.setOnClickListener {
                                    vpOnBoarding.currentItem = vpOnBoarding.currentItem -1
                                }
                            }
                        }
                        1 -> {
                            btnGetStarted.visibility = INVISIBLE
                            tvPrev.visibility = VISIBLE
                            tvSkip.visibility = VISIBLE
                            binding.apply {
                                tvNext.setOnClickListener {
                                    binding.vpOnBoarding.apply {
                                        vpOnBoarding.currentItem = vpOnBoarding.currentItem +1
                                    }
                                    tvPrev.setOnClickListener {
                                        vpOnBoarding.currentItem = vpOnBoarding.currentItem -1
                                    }
                                }
                            }

                        }
                        else -> {
                            vpOnBoarding.isUserInputEnabled = false
                            tvPrev.visibility = INVISIBLE
                            tvNext.visibility = INVISIBLE
                            tvSkip.visibility = INVISIBLE
                            btnGetStarted.visibility = VISIBLE
                            btnGetStarted.setOnClickListener {
                                toLoginPage()
                            }
                        }
                    }
                }
            })
        }
    }

    fun toLoginPage() {
        val toLogin = Intent(this, LoginActivity::class.java)
        startActivity(toLogin)
        finish()
    }
}