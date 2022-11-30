package com.javieriq.justochallenge.data.model

import com.google.gson.annotations.SerializedName

data class LocationModel(
    @SerializedName("street") val street: StreetModel,
    @SerializedName("city") val city: String,
    @SerializedName("state") val state: String,
    @SerializedName("country") val country: String,
    @SerializedName("postcode") val postcode: Int,
    @SerializedName("coordinates") val coordinates: CoordinatesModel,
    @SerializedName("timezone") val timezone: TimezoneModel
)
