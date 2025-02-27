package com.example.kokoro.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kokoro.R
import com.example.kokoro.databinding.ActivityBookBinding

class BookActivity : AppCompatActivity() {

    lateinit var binding: ActivityBookBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityBookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floatingActionButton3.setOnClickListener {
            var intent = Intent(this@BookActivity,
                AddBookActivity::class.java
            )
            startActivity(intent)
        }

        binding.StoriesBtn.setOnClickListener {
            val intent2 = Intent(this@BookActivity,
                DashboardActivity::class.java)
            startActivity(intent2)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}