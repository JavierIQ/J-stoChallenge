package com.javieriq.justochallenge.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.javieriq.justochallenge.R
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

        userViewModel.userModel.observe(this, Observer { currentUser ->
            if (currentUser != null) {
                val gender = currentUser.results[0].gender
                val lastName = currentUser.results[0].name.last
                val streetName = currentUser.results[0].location.street.name
                val phone = currentUser.results[0].phone
                val email = currentUser.results[0].email

                Log.d("DEBUGAPI", gender)
                Log.d("DEBUGAPI", lastName)
                Log.d("DEBUGAPI", streetName)
                Log.d("DEBUGAPI", phone)
                Log.d("DEBUGAPI", email)
            }
        })

        binding.buttonAddUser.setOnClickListener {
            userViewModel.onCreate()
        }
    }
}