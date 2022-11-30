package com.javieriq.justochallenge.data.model

import com.google.gson.annotations.SerializedName

data class CoordinatesModel(
    @SerializedName("latitude") val latitude: String,
    @SerializedName("longitude") val longitude: String
)
