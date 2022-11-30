package com.javieriq.justochallenge.data.model

import com.google.gson.annotations.SerializedName

data class RegisteredModel(
    @SerializedName("date") val date: String,
    @SerializedName("age") val age: Int
)
