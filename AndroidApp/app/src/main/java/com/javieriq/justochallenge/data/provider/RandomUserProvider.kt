package com.javieriq.justochallenge.data.provider

import com.javieriq.justochallenge.data.model.InfoModel
import com.javieriq.justochallenge.data.model.RandomUserModel

class RandomUserProvider {
    companion object{
        var user: RandomUserModel = RandomUserModel(emptyList(), InfoModel("", 0, 0, ""))
    }
}