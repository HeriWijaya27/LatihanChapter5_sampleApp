package com.example.latihanchapter5_login.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.latihanchapter5_login.fragment.OnBoardingFragment1
import com.example.latihanchapter5_login.fragment.OnBoardingFragment2
import com.example.latihanchapter5_login.fragment.OnBoardingFragment3

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    private val pages = 3

    override fun getItemCount(): Int {
        return pages
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                OnBoardingFragment1()
            }
            1 -> {
                OnBoardingFragment2()
            }
            else -> {
                OnBoardingFragment3()
            }
        }
    }
}