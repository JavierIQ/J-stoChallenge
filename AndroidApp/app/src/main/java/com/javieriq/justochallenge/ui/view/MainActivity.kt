package com.javieriq.justochallenge.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.google.gson.Gson
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
            if (currentUser != null && currentUser.results.isNotEmpty()) {
                render(currentUser)
                binding.btnMoreInfo.setOnClickListener {
                    val gson = Gson()
                    val intent = Intent(this, DetailUserActivity::class.java)
                    intent.putExtra("identifier", gson.toJson(currentUser))
                    startActivity(intent)
                }
            }else{

            }
        })

    }

    private fun render(user: RandomUserModel) {
        val titleName = user.results[0].name.title
        val firstName = user.results[0].name.first
        val lastName = user.results[0].name.last
        val country = user.results[0].location.country
        val email = user.results[0].email
        val phone = user.results[0].phone
        val imageUrl = user.results[0].picture.large

        Glide.with(binding.imgVProfile.context)
            .load(imageUrl)
            .circleCrop()
            .into(binding.imgVProfile)

        binding.tvTitle.text = titleName
        binding.tvFirstName.text = firstName
        binding.tvLastName.text = lastName
        binding.tvUserEmail.text = email
        binding.tvUserCountry.text = country
        binding.tvUserPhone.text = phone

    }

    private fun listeners(){
        binding.btnAdd.setOnClickListener {
            userViewModel.onCreate()
        }
    }

}