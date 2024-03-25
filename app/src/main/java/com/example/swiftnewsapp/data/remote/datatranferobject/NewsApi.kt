package com.example.swiftnewsapp.data.remote.datatranferobject

import com.example.swiftnewsapp.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("page") page: Int,
        @Query("sources") string: String,
        @Query("apiKay") apiKey: String = API_KEY,
        sources: String
    ):NewsResponse

    abstract fun getNews(sources: String, page: Int): NewsResponse
}