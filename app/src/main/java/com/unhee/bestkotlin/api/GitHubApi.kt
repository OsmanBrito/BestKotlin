package com.unhee.bestkotlin.api

import com.unhee.bestkotlin.data.ResponseApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubApi {

    @GET("search/repositories")
    fun repositories(@Query("q") q: String, @Query("sort") sort: String, @Query("page") page: String): Call<ResponseApi>

}