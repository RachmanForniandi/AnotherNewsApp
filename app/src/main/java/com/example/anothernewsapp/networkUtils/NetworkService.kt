package com.example.anothernewsapp.networkUtils

import com.example.anothernewsapp.model.ResultNews
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {

    @GET("top-headlines")
    fun getNewsData(@Query("country") country: String,
                    @Query("apiKey")apiKey: String) : Call<ResultNews>
}