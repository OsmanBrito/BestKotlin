package com.unhee.bestkotlin.api

import com.unhee.bestkotlin.data.entity.ResponseApi
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubApi {

    @GET("search/repositories")
    suspend fun repositories(@Query("q") q: String, @Query("sort") sort: String, @Query("page") page: Int): ResponseApi

}