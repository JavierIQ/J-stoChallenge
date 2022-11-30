package com.javieriq.justochallenge.data.model

import com.google.gson.annotations.SerializedName

data class StreetModel(
    @SerializedName("number") val number: Int,
    @SerializedName("name") val name: String
)
