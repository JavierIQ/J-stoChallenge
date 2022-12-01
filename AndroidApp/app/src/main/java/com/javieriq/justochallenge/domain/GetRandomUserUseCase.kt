package com.javieriq.justochallenge.domain

import com.javieriq.justochallenge.data.RandomUserRepository
import com.javieriq.justochallenge.data.model.RandomUserModel
import com.javieriq.justochallenge.data.model.ResultsModel

class GetRandomUserUseCase {

    private val repository = RandomUserRepository()

    suspend operator fun invoke(): RandomUserModel? = repository.getRandomUserApi()
}