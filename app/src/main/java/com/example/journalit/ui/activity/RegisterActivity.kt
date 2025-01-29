package com.example.journalit.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.journalit.R
import com.example.journalit.databinding.ActivityRegisterBinding
import com.example.journalit.model.UserModel
import com.example.journalit.repository.UserRepositoryImpl
import com.example.journalit.viewmodel.UserViewModel

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repo = UserRepositoryImpl()
        userViewModel = UserViewModel(repo)

        binding.registerBtn.setOnClickListener{
            var username = binding.usernameRegister.text.toString()
            var email = binding.emailRegister.text.toString()
            var password = binding.passwordRegister.text.toString()

            userViewModel.register(email,password){
                success,message,userId ->
                if(success){
                    var userModel = UserModel(userId.toString(),
                        username,email)
                    addUser(userModel)
                }else{
                    Toast.makeText(this@RegisterActivity,
                        message, Toast.LENGTH_SHORT).show()
                }
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun addUser(userModel: UserModel){
        userViewModel.addUserToDatabase(userModel.userId,userModel){
            success,message ->
            if (success){
                Toast.makeText(this@RegisterActivity,
                    message,Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this@RegisterActivity,
                    message,Toast.LENGTH_SHORT).show()
            }
        }
    }
}