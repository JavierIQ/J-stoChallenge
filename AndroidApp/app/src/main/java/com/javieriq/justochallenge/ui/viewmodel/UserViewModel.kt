package com.javieriq.justochallenge.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.javieriq.justochallenge.data.model.RandomUserModel
import com.javieriq.justochallenge.domain.GetRandomUserUseCase
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {

    val userModel = MutableLiveData<RandomUserModel?>()
    val toastMessage = MutableLiveData<String>()

    var getRandomUserUseCase = GetRandomUserUseCase()

    fun onCreate(){
        viewModelScope.launch {
            val result = getRandomUserUseCase()
            if (result != null){
                userModel.postValue(result)
            }else{
                toastMessage.postValue("User does not exist")
            }
        }
    }
}