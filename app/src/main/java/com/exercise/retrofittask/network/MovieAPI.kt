package com.exercise.retrofittask.network

import com.exercise.retrofittask.model.ResponsePopularMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {
    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): Call<ResponsePopularMovie>
}
