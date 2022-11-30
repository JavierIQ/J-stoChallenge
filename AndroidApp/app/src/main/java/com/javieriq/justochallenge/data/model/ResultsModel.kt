package com.javieriq.justochallenge.data.model

import com.google.gson.annotations.SerializedName

data class ResultsModel(
    @SerializedName("gender") val gender:String,
    @SerializedName("name") val name: NameModel,
    @SerializedName("location") val location: LocationModel,
    @SerializedName("email") val email: String,
    @SerializedName("login") val loginInfo: LoginModel,
    @SerializedName("dob") val dob: DobModel,
    @SerializedName("registered") val registeredInfo: RegisteredModel,
    @SerializedName("phone") val phone: String,
    @SerializedName("cell") val cell: String,
    @SerializedName("id") val id: IdModel,
    @SerializedName("picture") val picture: PictureModel,
    @SerializedName("nat") val nat: String
)
