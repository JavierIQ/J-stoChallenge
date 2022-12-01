package com.javieriq.justochallenge.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.javieriq.justochallenge.R
import com.javieriq.justochallenge.data.model.RandomUserModel
import com.javieriq.justochallenge.databinding.ActivityMainBinding
import com.javieriq.justochallenge.ui.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userViewModel.onCreate()
        listeners()

        userViewModel.userModel.observe(this, Observer { currentUser ->
            if (currentUser != null) {
                render(currentUser)
            }else{
            }
        })

        userViewModel.toastMessage.observe(this, Observer { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        })

    }

    private fun render(user: RandomUserModel) {
        val name = user.results[0].name.first
        val age = user.results[0].dob.age
        val email = user.results[0].email
        val phone = user.results[0].phone

        binding.tvName.text = "Name ${name}"
        binding.tvAge.text = "Name ${age}"
        binding.tvEmail.text = "Name ${email}"
        binding.tvPhone.text = "Name ${phone}"
    }

    private fun listeners(){
        binding.btnAdd.setOnClickListener {
            userViewModel.onCreate()
        }
    }

}