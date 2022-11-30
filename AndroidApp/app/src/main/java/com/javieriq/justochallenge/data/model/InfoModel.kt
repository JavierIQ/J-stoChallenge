package com.javieriq.justochallenge.data.model

import com.google.gson.annotations.SerializedName

data class InfoModel(
    @SerializedName("seed") val seed: String,
    @SerializedName("results") val results: Int,
    @SerializedName("page") val page: Int,
    @SerializedName("version") val version: String
)
