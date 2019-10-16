package com.unhee.bestkotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.unhee.bestkotlin.api.RetrofitInitializer
import com.unhee.bestkotlin.data.ResponseApi
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response


class RepositoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_list)
        val call = RetrofitInitializer().githubApi().repositories("language:kotlin", "stars", "1")
        call.clone().enqueue(object : retrofit2.Callback<ResponseApi> {

            override fun onResponse(call: Call<ResponseApi>, response: Response<ResponseApi>) {
                Log.d(TAG, "OnResponse!!")
            }

            override fun onFailure(call: Call<ResponseApi>, t: Throwable) {
                Log.e(TAG, "OnFAilure!!")
            }
        })
    }

    companion object {
        val TAG = "RepositoryActivity"
    }
}
