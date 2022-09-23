package com.challenge.wefitchallenge.data

import com.challenge.wefitchallenge.data.Constants.initialUser
import com.challenge.wefitchallenge.data.models.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface API {
    @GET("users/{repositoryName}/repos")
    suspend fun getRepos(
        @Path("repositoryName") repositoryName: String = initialUser
    ) : Response<ApiResponse>
}