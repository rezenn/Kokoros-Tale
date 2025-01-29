package com.example.journalit.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.journalit.R
import com.example.journalit.databinding.ActivityForgotPasswordBinding
import com.example.journalit.repository.UserRepositoryImpl
import com.example.journalit.utils.LoadingUtils
import com.example.journalit.viewmodel.UserViewModel

class ForgotPasswordActivity : AppCompatActivity() {
    lateinit var binding: ActivityForgotPasswordBinding
    lateinit var userViewModel: UserViewModel
    lateinit var loadingUtils: LoadingUtils


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadingUtils = LoadingUtils(this)

        var repo = UserRepositoryImpl()
        userViewModel = UserViewModel(repo)

        binding.resetPasswordBtn.setOnClickListener {
            loadingUtils.show()

            var email: String =binding.emailForgotPassword.text.toString()

            userViewModel.forgotPassword(email){
                success, message ->
                if(success){
                    loadingUtils.dismiss()

                    Toast.makeText(this@ForgotPasswordActivity,
                        message, Toast.LENGTH_SHORT).show()
                    finish()
                }else{
                    loadingUtils.dismiss()

                    Toast.makeText(this@ForgotPasswordActivity,
                        message, Toast.LENGTH_SHORT).show()
                }
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.signupForgotLink.setOnClickListener {
            val intent = Intent(
                this@ForgotPasswordActivity, LoginActivity::class.java
            )
            startActivity(intent)
        }
    }
}