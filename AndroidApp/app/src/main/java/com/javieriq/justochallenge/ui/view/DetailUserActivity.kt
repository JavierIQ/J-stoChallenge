package com.javieriq.justochallenge.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedDispatcher
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.javieriq.justochallenge.data.model.RandomUserModel
import com.javieriq.justochallenge.databinding.ActivityDetailUserBinding

class DetailUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listeners()

        val gson = Gson()
        val user = gson.fromJson<RandomUserModel>(intent.getStringExtra("identifier"), RandomUserModel::class.java)

        render(user)
    }

    private fun render(user: RandomUserModel) {

        // Get Personal Info from user to Print
        val userTitle = user.results[0].name.title
        val userFirstName = user.results[0].name.first
        val userLastName = user.results[0].name.last
        val email = user.results[0].email
        val phone = user.results[0].phone
        val age = user.results[0].dob.age
        val genre = user.results[0].gender
        // Get Location Info from user to Print
        val country = user.results[0].location.country
        val state = user.results[0].location.state
        val city = user.results[0].location.city
        val timezone = user.results[0].location.timezone.description
        // Get Session Info from user to Print
        val username = user.results[0].loginInfo.username
        val userID = user.results[0].id.name
        val userUuid = user.results[0].loginInfo.uuid
        // Image
        val imageURL = user.results[0].picture.large

        // Setting View information
        Glide.with(binding.imgVProfile.context)
            .load(imageURL)
            .circleCrop()
            .into(binding.imgVProfile)

        // User Name
        binding.tvTitle.text = userTitle
        binding.tvFirstName.text = userFirstName
        binding.tvLastName.text = userLastName

        // Personal Info
        binding.tvUserEmail.text = email
        binding.tvUserPhone.text = phone
        binding.tvUserAge.text = age.toString()
        binding.tvUserGenre.text = genre

        // Location Info
        binding.tvUserCountry.text = country
        binding.tvUserState.text = state
        binding.tvUserCity.text = city
        binding.tvUserTimeZone.text = timezone

        // Session Info
        binding.tvUsername.text = username
        binding.tvUserID.text = userID.toString()
        binding.tvUserUUID.text = userUuid.toString()

    }

    private fun listeners(){
        binding.btnReturnMain.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}