package com.challenge.wefitchallenge.data.models

sealed class HomeState {
    object Loading:HomeState()
    data class Error(val msg:String): HomeState()
    data class Success(val response:ApiResponse): HomeState()
}
