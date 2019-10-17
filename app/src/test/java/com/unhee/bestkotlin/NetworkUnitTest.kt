package com.unhee.bestkotlin

import com.unhee.bestkotlin.api.RetrofitInitializer
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Test
import java.io.IOException

class NetworkUnitTest {

    @Test
    fun callSuccess() {
        val apiCall = RetrofitInitializer.githubApi
        try {
            runBlocking {
                val response = apiCall.repositories("language:kotlin", "stars", 1)
                assertTrue(response.items.size == 30)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}