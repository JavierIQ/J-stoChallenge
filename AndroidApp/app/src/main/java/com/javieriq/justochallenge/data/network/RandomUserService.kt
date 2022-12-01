package com.javieriq.justochallenge.data.network

import android.util.Log
import com.javieriq.justochallenge.core.RetrofitHelper
import com.javieriq.justochallenge.data.model.InfoModel
import com.javieriq.justochallenge.data.model.RandomUserModel
import com.javieriq.justochallenge.data.model.ResultsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RandomUserService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getUser(): RandomUserModel{
        return try {
            withContext(Dispatchers.IO){
                val response = retrofit.create(RandomUserApiClient::class.java).getRandomUser()
                response.body() ?: RandomUserModel(emptyList(), InfoModel("", 0, 0, ""))
            }
        }catch (e: Exception){
            Log.e("DATAAPI", e.toString())
            return RandomUserModel(emptyList(), InfoModel("", 0, 0, ""))
        }
    }

}