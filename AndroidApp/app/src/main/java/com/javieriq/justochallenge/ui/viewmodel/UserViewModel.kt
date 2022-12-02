package com.javieriq.justochallenge.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.javieriq.justochallenge.data.model.RandomUserModel
import com.javieriq.justochallenge.domain.GetRandomUserUseCase
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {

    // Declare LiveData to post to the Activity
    val userModel = MutableLiveData<RandomUserModel?>()

    // Declare the UseCase to get one Random User
    var getRandomUserUseCase = GetRandomUserUseCase()

    // Function that we will call in the activity to get one user and store in the livedata
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