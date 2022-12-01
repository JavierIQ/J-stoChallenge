package com.javieriq.justochallenge.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.javieriq.justochallenge.data.model.RandomUserModel
import com.javieriq.justochallenge.domain.GetRandomUserUseCase
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {

    val userModel = MutableLiveData<RandomUserModel?>()

    var getRandomUserUseCase = GetRandomUserUseCase()

    fun onCreate(){
        viewModelScope.launch {
            val result = getRandomUserUseCase()
            if (result != null){
                userModel.postValue(result)
            }else{
                Log.d("DATA_API","User does not exist")
            }
        }
    }
}