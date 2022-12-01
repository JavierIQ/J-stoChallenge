package com.javieriq.justochallenge.data

import com.javieriq.justochallenge.data.model.RandomUserModel
import com.javieriq.justochallenge.data.model.ResultsModel
import com.javieriq.justochallenge.data.network.RandomUserService
import com.javieriq.justochallenge.data.provider.RandomUserProvider

class RandomUserRepository {

    private val api = RandomUserService()

    suspend fun getRandomUserApi(): RandomUserModel{
        val response = api.getUser()
        RandomUserProvider.user = response
        return response
    }
}