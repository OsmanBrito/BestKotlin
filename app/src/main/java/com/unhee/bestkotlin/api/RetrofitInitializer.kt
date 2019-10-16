package com.unhee.bestkotlin.api

import com.unhee.bestkotlin.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    val retrofit: Retrofit = Retrofit.Builder().baseUrl(Constants.API_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    fun githubApi(): GitHubApi = retrofit.create(GitHubApi::class.java)
}