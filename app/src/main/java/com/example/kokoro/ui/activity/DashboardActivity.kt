package com.example.kokoro.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.kokoro.R
import com.example.kokoro.databinding.ActivityDashboardBinding
import com.example.kokoro.ui.fragment.BookTrackerFragment
import com.example.kokoro.ui.fragment.HomeFragment
import com.example.kokoro.ui.fragment.ProfileFragment

class DashboardActivity : AppCompatActivity() {

    lateinit var binding: ActivityDashboardBinding
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.kokoroFragment,fragment)
        fragmentTransaction.commit()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        binding.bottomView.setOnItemSelectedListener { menu ->
            when(menu.itemId){
                R.id.navHome -> replaceFragment(HomeFragment())
                R.id.navBookTracker -> replaceFragment(BookTrackerFragment())
                R.id.navProfile -> replaceFragment(ProfileFragment())

                else -> {}
            }
            true
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}