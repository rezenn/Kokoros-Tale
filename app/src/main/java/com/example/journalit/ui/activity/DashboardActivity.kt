package com.example.journalit.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.journalit.R
import com.example.journalit.databinding.ActivityDashboardBinding
import com.example.journalit.ui.fragment.AddFragment
import com.example.journalit.ui.fragment.BookFragment
import com.example.journalit.ui.fragment.HomeFragment
import com.example.journalit.ui.fragment.ProfileFragment
import com.example.journalit.ui.fragment.SearchFragment

class DashboardActivity : AppCompatActivity() {
    lateinit var binding: ActivityDashboardBinding

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.framehome,fragment)
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
                R.id.navBookTracker -> replaceFragment(BookFragment())
                R.id.navProfile -> replaceFragment(ProfileFragment())
                R.id.navAdd -> replaceFragment(AddFragment())

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