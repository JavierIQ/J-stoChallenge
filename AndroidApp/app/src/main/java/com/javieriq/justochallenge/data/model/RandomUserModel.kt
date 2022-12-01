package com.javieriq.justochallenge.data.model

import com.google.gson.annotations.SerializedName

data class RandomUserModel(
    @SerializedName("results") val results: List<ResultsModel>,
    @SerializedName("info") val info: InfoModel
)
