package com.challenge.wefitchallenge.presentation.home.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.challenge.wefitchallenge.data.Constants.initialUser
import com.challenge.wefitchallenge.data.Constants.tag
import com.challenge.wefitchallenge.data.RetrofitInstance
import com.challenge.wefitchallenge.data.models.HomeState
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val state_ = MutableLiveData<HomeState>()
    val state
        get() = state_

    fun loadRepositories(repositoryName : String = initialUser) {
        viewModelScope.launch {
            val response = try {
                RetrofitInstance.api.getRepos(repositoryName)
            } catch (e:Exception) {
                Log.e(tag, "message: ${e.message}")
                state_.value = HomeState.Error(e.message ?: "")
                null
            }
            if (response?.isSuccessful == true) {
                Log.d(tag, "Success -> value: ${response.body()}")
                state_.value = response.body()?.let { HomeState.Success(it) }
            }
        }
    }
}