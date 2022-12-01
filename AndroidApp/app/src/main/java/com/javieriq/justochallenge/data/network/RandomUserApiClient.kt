package com.javieriq.justochallenge.data.network

import com.javieriq.justochallenge.data.model.RandomUserModel
import com.javieriq.justochallenge.data.model.ResultsModel
import retrofit2.Response
import retrofit2.http.GET

interface RandomUserApiClient {

    @GET("api/")
    suspend fun getRandomUser(): Response<RandomUserModel>
}