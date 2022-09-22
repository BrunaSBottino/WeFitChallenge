package com.challenge.wefitchallenge.data

import retrofit2.Response
import retrofit2.http.GET

interface API {

    @GET("users/appswefit/repos")
    suspend fun getRepos() : Response<>
}